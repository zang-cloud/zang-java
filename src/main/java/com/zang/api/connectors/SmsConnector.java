package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.SmsMessage;
import com.zang.api.domain.Usage;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.enums.Product;
import com.zang.api.domain.list.SmsMessageList;
import com.zang.api.domain.list.UsagesList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.requests.UsagesRequest;
import com.zang.api.restproxies.SmsProxy;
import com.zang.api.restproxies.UsageProxy;
import org.jboss.resteasy.client.ClientExecutor;
import org.jboss.resteasy.client.ClientResponse;

import java.util.Date;

/**
 * 
 * The class used for all forms of communication with the Usage endpoint of the Zang REST API.
 * 
 */
public class SmsConnector extends BaseConnector {

	private SmsProxy smsProxy;

	/**
	 * @see BaseConnector, PropertiesFileZangConfiguration,
	 *      ZangConfiguration
	 */
	SmsConnector(ZangConfiguration conf, ClientExecutor executor) {
		super(conf, executor);
		smsProxy = createProxy(SmsProxy.class);
	}

	/**
	 * Used for specifying a different accountSid.
	 *
	 * @see #viewSmsMessage(String)
	 * @param sid
	 *            The account sid (required).
	 * @return An Sms Message resource.
	 * @throws ZangException
	 */
	public SmsMessage viewSmsMessage(String sid, String smsMessageSid)
			throws ZangException {
		ClientResponse<SmsMessage> sms = smsProxy.getSmsMessage(sid,
				smsMessageSid);
		return returnThrows(sms);
	}

	/**
	 * Text messages sent to and from Zang phone numbers are represented with
	 * the Sms resource.
	 *
	 * @param smsMessageSid
	 *            The sms message sid (required).
	 * @return An Sms Message resource.
	 * @throws ZangException
	 */
	public SmsMessage viewSmsMessage(String smsMessageSid)
			throws ZangException {
		return viewSmsMessage(conf.getSid(), smsMessageSid);
	}

	/**
	 * @see #listSmsMessages(String, String, Date, Date, Long, Long)
	 * @param accountSid
	 *            The account sid (required).
	 * @return A list of SmsMessage resources.
	 * @throws ZangException
	 */
	public SmsMessageList listSmsMessages(String accountSid, String to,
										  String from, Date dateSentGte, Date dateSentLt, Long page,
										  Long pageSize) throws ZangException {

		ClientResponse<SmsMessageList> smsList = smsProxy.getSmsMessageList(
				accountSid, to, from, getDateString(dateSentGte),
				getDateString(dateSentLt), page, pageSize);
		return returnThrows(smsList);
	}

	/**
	 * Just as with calls, a list of all messages sent to and from a given
	 * Zang account's phone numbers can be requested via our REST API.
	 *
	 * @param to
	 *            Lists all SMS messages sent to this number.
	 * @param from
	 *            Lists all SMS messages sent from this number.
	 * @param dateSentGte
	 *            Lists all SMS messages beginning on or from a certain date.
	 * @param dateSentLt
	 *            Lists all SMS messages before a certain date.
	 * @param page
	 *            Used to return a particular page within the list.
	 * @param pageSize
	 *            Used to specify the amount of list items to return per page.
	 * @return A list of SmsMessage resources.
	 * @throws ZangException
	 */
	public SmsMessageList listSmsMessages(String to, String from,
										  Date dateSentGte, Date dateSentLt, Long page, Long pageSize)
			throws ZangException {
		return listSmsMessages(conf.getSid(), to, from, dateSentGte,
				dateSentLt, page, pageSize);
	}

	/**
	 * Lists all Sms Messages for the configured account.
	 *
	 * @return A list of Sms Message.
	 * @throws ZangException
	 */
	public SmsMessageList listSmsMessages() throws ZangException {
		return listSmsMessages(conf.getSid(), null, null, null, null, null,
				null);
	}

	/**
	 * @see #sendSmsMessage(String, String, String, String)
	 * @param accountSid
	 *            The account sid (required).
	 * @throws ZangException
	 */
	public SmsMessage sendSmsMessage(String accountSid, String to, String from,
									 String body, String statusCallback, HttpMethod statusCallbackMethod,
									 Boolean allowMultiple) throws ZangException {
		ClientResponse<SmsMessage> smsMessage = smsProxy.sendSmsMessage(
				accountSid, to, from, body, statusCallback, statusCallbackMethod, allowMultiple);
		return returnThrows(smsMessage);
	}

	/**
	 * Sends an SMS message.
	 *
	 * @param to
	 *            The number you want to send the SMS to (required).
	 * @param from
	 *            The number you want to display as sending the SMS. A subcharge
	 *            will apply when sending via a custom From number (required).
	 * @param body
	 *            Text of the SMS message to be sent. Plain text up to 160
	 *            characters in length (required).
	 * @param statusCallback
	 *            URL that a set of default parameters will be forwarded to once
	 *            the SMS is complete.
	 * @return The SMS message which was sent.
	 * @throws ZangException
	 */
	public SmsMessage sendSmsMessage(String to, String from, String body,
									 String statusCallback, HttpMethod statusCallbackMethod,
									 Boolean allowMultiple) throws ZangException {
		return sendSmsMessage(conf.getSid(), to, from, body, statusCallback, statusCallbackMethod, allowMultiple);
	}

}
