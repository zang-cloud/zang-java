package com.zang.api;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.client.core.executors.ApacheHttpClient4Executor;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.configuration.ZangConstants;
import com.zang.api.domain.Account;
import com.zang.api.domain.Application;
import com.zang.api.domain.Call;
import com.zang.api.domain.Conference;
import com.zang.api.domain.IncomingPhoneNumber;
import com.zang.api.domain.Notification;
import com.zang.api.domain.Participant;
import com.zang.api.domain.Recording;
import com.zang.api.domain.SmsMessage;
import com.zang.api.domain.Transcription;
import com.zang.api.domain.enums.AudioDirection;
import com.zang.api.domain.enums.CallInterruptStatus;
import com.zang.api.domain.enums.CallStatus;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.enums.Legs;
import com.zang.api.domain.enums.LogLevel;
import com.zang.api.domain.enums.TranscriptionStatus;
import com.zang.api.domain.enums.TranscriptionType;
import com.zang.api.domain.list.AccountsList;
import com.zang.api.domain.list.ApplicationList;
import com.zang.api.domain.list.AvailablePhoneNumberList;
import com.zang.api.domain.list.CallList;
import com.zang.api.domain.list.CarrierLookupList;
import com.zang.api.domain.list.CnamDipList;
import com.zang.api.domain.list.ConferenceList;
import com.zang.api.domain.list.FraudList;
import com.zang.api.domain.list.IncomingPhoneNumberList;
import com.zang.api.domain.list.NotificationList;
import com.zang.api.domain.list.RecordingList;
import com.zang.api.domain.list.SmsMessageList;
import com.zang.api.domain.list.TranscriptionList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.http.RestExecutor;
import com.zang.api.requests.ApplicationRequest;
import com.zang.api.requests.CallRequest;
import com.zang.api.requests.IncomingPhoneNumberRequest;
import com.zang.api.restproxies.AccountsProxy;
import com.zang.api.restproxies.ApplicationProxy;
import com.zang.api.restproxies.AvailablePhoneNumberProxy;
import com.zang.api.restproxies.CallProxy;
import com.zang.api.restproxies.CarrierLookupProxy;
import com.zang.api.restproxies.ConferenceProxy;
import com.zang.api.restproxies.FraudControlProxy;
import com.zang.api.restproxies.IncomingPhoneNumberProxy;
import com.zang.api.restproxies.NotificationProxy;
import com.zang.api.restproxies.RecordingProxy;
import com.zang.api.restproxies.SmsProxy;
import com.zang.api.restproxies.TranscriptionProxy;

/**
 * 
 * The class used for all forms of communication with the Zang REST API.
 * 
 */
public class ZangConnector {

	private ApacheHttpClient4Executor executor;
	private ZangConfiguration conf;
	private String fullBaseUrl;

	private AccountsProxy accountsProxy;
	private SmsProxy smsProxy;
	private CallProxy callProxy;
	private ConferenceProxy conferenceProxy;
	private ApplicationProxy applicationProxy;
	private IncomingPhoneNumberProxy incomingPhoneNumberProxy;
	private AvailablePhoneNumberProxy availablePhoneNumberProxy;
	private RecordingProxy recordingProxy;
	private NotificationProxy notificationProxy;
	private TranscriptionProxy transcriptionProxy;
	private CarrierLookupProxy carrierLookupProxy;
	private FraudControlProxy fraudControlProxy;

	/**
	 * Creates a new ZangConnector based on the provided configuration.
	 * 
	 * @param conf
	 *            The configuration based on which the ZangConnector will be
	 *            created.
	 * @see BasicZangConfiguration, PropertiesFileZangConfiguration,
	 *      ZangConfiguration
	 */
	public ZangConnector(ZangConfiguration conf) {
		this.conf = conf;
		executor = RestExecutor.createExecutor(conf);
		URI baseUrl = UriBuilder.fromUri(conf.getBaseUrl())
				.path(ZangConstants.API_VERSION).build();
		fullBaseUrl = baseUrl.toString();

		accountsProxy = createProxy(AccountsProxy.class);
		smsProxy = createProxy(SmsProxy.class);
		callProxy = createProxy(CallProxy.class);
		conferenceProxy = createProxy(ConferenceProxy.class);
		applicationProxy = createProxy(ApplicationProxy.class);
		incomingPhoneNumberProxy = createProxy(IncomingPhoneNumberProxy.class);
		availablePhoneNumberProxy = createProxy(AvailablePhoneNumberProxy.class);
		recordingProxy = createProxy(RecordingProxy.class);
		notificationProxy = createProxy(NotificationProxy.class);
		transcriptionProxy = createProxy(TranscriptionProxy.class);
		carrierLookupProxy = createProxy(CarrierLookupProxy.class);
		fraudControlProxy = createProxy(FraudControlProxy.class);
	}

	private <T> T createProxy(Class<T> clazz) {
		return ProxyFactory.create(clazz, fullBaseUrl, executor);
	}

	private <T> T returnThrows(ClientResponse<T> response)
			throws ZangException {
		int status = response.getStatus();
		if (status > 399) {
			ZangException exception = response
					.getEntity(ZangException.class);
			throw exception;
		}
		return response.getEntity();
	}

	private String getDateString(Date date) {
		if (date == null)
			return null;
		return ZangConstants.queryDateFormat.format(date);
	}

	// ACCOUNT

	/**
	 * An account resource provides information about a single Zang account.
	 * This methods gets the info of the account with the provided Sid.
	 * 
	 * @param accountSid
	 * @return
	 * @throws ZangException
	 */
	public Account viewAccount(String accountSid) throws ZangException {
		ClientResponse<Account> acc = accountsProxy.getAccount(accountSid);
		return returnThrows(acc);
	}

	/**
	 * @see #viewAccount(String)
	 * @return The account with the Sid defined in the configuration.
	 * @throws ZangException
	 */
	public Account viewAccount() throws ZangException {
		return viewAccount(conf.getSid());
	}

	public AccountsList viewAccounts() throws ZangException {
		ClientResponse<AccountsList> accounts = accountsProxy.getAccounts();
		return returnThrows(accounts);
	}

	// SMSMESSAGE

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
			String body, String statusCallback) throws ZangException {
		ClientResponse<SmsMessage> smsMessage = smsProxy.sendSmsMessage(
				accountSid, to, from, body, statusCallback);
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
			String statusCallback) throws ZangException {
		return sendSmsMessage(conf.getSid(), to, from, body, statusCallback);
	}

	// CALLS

	/**
	 * @see #viewCall(String)
	 * @param accountSid
	 *            The account sid (required).
	 * @throws ZangException
	 */
	public Call viewCall(String accountSid, String callSid)
			throws ZangException {
		return returnThrows(callProxy.viewCall(accountSid, callSid));
	}

	/**
	 * Gets the specified call resource. A call resource provides information
	 * about an individual call that has occurred through Zang. Both inbound
	 * and outbound voice communication through Zang are categorized as calls.
	 * 
	 * @param callSid
	 *            The sid of the requested Call resource (required).
	 * @return The requested Call resource.
	 * @throws ZangException
	 */
	public Call viewCall(String callSid) throws ZangException {
		return viewCall(conf.getSid(), callSid);
	}

	/**
	 * @see #listCalls(String, String, CallStatus, Date, Date, Long, Long)
	 * @param accountSid
	 *            The account sid (required).
	 * @throws ZangException
	 */
	public CallList listCalls(String accountSid, String to, String from,
			CallStatus status, Date startTimeGte, Date startTimeLt, Long page,
			Long pageSize, Integer recordingsCount) throws ZangException {
		return returnThrows(callProxy.listCalls(accountSid, to, from, status,
				getDateString(startTimeGte), getDateString(startTimeLt), page,
				pageSize));
	}

	/**
	 * To view a list of all inbound and outbound call resources associated with
	 * a given account, use this method. The response returned lists the calls
	 * in chronological order and also includes paging information.
	 * 
	 * @param to
	 *            Lists all calls made to this number only.
	 * @param from
	 *            Lists all calls made from this number.
	 * @param status
	 *            Lists all calls with the specified status only.
	 * @param startTimeGte
	 *            Lists all calls beginning on or from a certain date.
	 * @param startTimeLt
	 *            Lists all calls beginning before a certain date.
	 * @param page
	 *            Used to return a particular page within the list.
	 * @param pageSize
	 *            Used to specify the amount of list items to return per page.
	 * @return A list of calls.
	 * @throws ZangException
	 */
	public CallList listCalls(String to, String from, CallStatus status,
			Date startTimeGte, Date startTimeLt, Long page, Long pageSize,Integer recordingsCount)
			throws ZangException {
		return listCalls(conf.getSid(), to, from, status, startTimeGte,
				startTimeLt, page, pageSize, recordingsCount);
	}
	
	/**
	 * To view a list of all inbound and outbound call resources associated with
	 * a given account, use this method. The response returned lists the calls
	 * in chronological order and also includes paging information.
	 * 
	 * @return A list of calls.
	 * @throws ZangException
	 */
	public CallList listCalls()
			throws ZangException {
		return listCalls(conf.getSid(), null, null, null, null,
				null, null, null, null);
	}

	/**
	 * @see #makeCall(String, String, String, HttpMethod, String, HttpMethod,
	 *      String, HttpMethod, String, HttpMethod, String, String, Long,
	 *      Boolean, Boolean, String, HttpMethod, Boolean, String, HttpMethod)
	 * @throws ZangException
	 */
	public Call makeCall(String accountSid, String to, String from, String url,
			HttpMethod method, String fallbackUrl, HttpMethod fallbackMethod,
			String statusCallback, HttpMethod statusCallbackMethod,
			String heartbeatUrl, HttpMethod heartbeatMethod,
			String forwardedFrom, String sendDigits, Long timeout,
			Boolean hideCallerId, Boolean record, String recordCallback,
			HttpMethod recordCallbackMethod, Boolean transcribe,
			String transcribeCallback, HttpMethod transcribeCallbackMethod)
			throws ZangException {
		return returnThrows(callProxy.makeCall(accountSid, to, from, url,
				method, fallbackUrl, fallbackMethod, statusCallback,
				statusCallbackMethod, heartbeatUrl, heartbeatMethod,
				forwardedFrom, sendDigits, timeout, hideCallerId, record,
				recordCallback, recordCallbackMethod, transcribe,
				transcribeCallback, transcribeCallbackMethod));
	}

	/**
	 * Makes a call.
	 * 
	 * @param to
	 *            The number to call (required).
	 * @param from
	 *            The number to display as calling (required).
	 * @param url
	 *            The URL requested once the call connects. A set of default
	 *            parameters will be sent here.
	 * @param method
	 *            Specifies the HTTP method used to request the required URL
	 *            once call connects. Defaults to POST.
	 * @param fallbackUrl
	 *            URL used if any errors occur during execution of InboundXML or
	 *            at initial request of the required Url provided with the POST.
	 * @param fallbackMethod
	 *            Specifies the HTTP method used to request FallbackUrl.
	 *            Defaults to POST.
	 * @param statusCallback
	 *            URL that can be requested to receive notification when call
	 *            has ended. A set of default parameters will be sent here once
	 *            the call is finished.
	 * @param statusCallbackMethod
	 *            Specifies the HTTP method used to request StatusCallbackUrl.
	 *            Defaults to POST.
	 * @param heartbeatUrl
	 *            URL that can be requested every 60 seconds during the call to
	 *            notify of elapsed time and pass other general information.
	 * @param heartbeatMethod
	 *            Specifies the HTTP method used to request the Heartbeat URL.
	 * @param forwardedFrom
	 *            Specifies the forwarding number to pass to the receiving
	 *            carrier.
	 * @param sendDigits
	 *            Dials digits once call connects. Can be used to forward
	 *            callers to different extensions or numbers. Allowed values are
	 *            numbers, # and *.
	 * @param timeout
	 *            Number of seconds call stays on the line while waiting for an
	 *            answer. The max time limit is 999 and the default limit is 60
	 *            seconds but lower times can be set. Defaults to 60.
	 * @param hideCallerId
	 *            Specifies if the caller id will be hidden.
	 * @param record
	 *            Specifies whether this call should be recorded. Defaults to
	 *            false.
	 * @param recordCallback
	 *            A URL some parameters regarding the recording will be past to
	 *            once it is completed.
	 * @param recordCallbackMethod
	 *            Method used to request the RecordCallback URL.
	 * @param transcribe
	 *            Specifies whether this call should be transcribed. Defaults to
	 *            false.
	 * @param transcribeCallback
	 *            A URL some parameters regarding the transcription will be past
	 *            to once it is completed.
	 * @param transcribeCallbackMethod
	 *            Method used to request the TranscribeCallback URL.
	 * @return The newly made call.
	 * @throws ZangException
	 */
	public Call makeCall(String to, String from, String url,
			HttpMethod method, String fallbackUrl, HttpMethod fallbackMethod,
			String statusCallback, HttpMethod statusCallbackMethod,
			String heartbeatUrl, HttpMethod heartbeatMethod,
			String forwardedFrom, String sendDigits, Long timeout,
			Boolean hideCallerId, Boolean record, String recordCallback,
			HttpMethod recordCallbackMethod, Boolean transcribe,
			String transcribeCallback, HttpMethod transcribeCallbackMethod) throws ZangException {
		return makeCall(conf.getSid(), to, from, url,
				method, fallbackUrl, fallbackMethod, statusCallback,
				statusCallbackMethod, heartbeatUrl, heartbeatMethod,
				forwardedFrom, sendDigits, timeout, hideCallerId, record,
				recordCallback, recordCallbackMethod, transcribe,
				transcribeCallback, transcribeCallbackMethod);
	}

	/**
	 * Convenience method which accepts a CallRequest object containing
	 * parameters.
	 * 
	 * @see #makeCall(String, String, String, HttpMethod, String, HttpMethod,
	 *      String, HttpMethod, String, HttpMethod, String, String, Long,
	 *      Boolean, Boolean, String, HttpMethod, Boolean, String, HttpMethod)
	 * @return The newly made call.
	 * @throws ZangException
	 */
	public Call makeCall(CallRequest callRequest) throws ZangException {
		String accountSid = conf.getSid();
		if (callRequest.getAccountSid() != null)
			accountSid = callRequest.getAccountSid();

		return makeCall(accountSid, callRequest.getTo(), callRequest.getFrom(),
				callRequest.getUrl(), callRequest.getMethod(),
				callRequest.getFallbackUrl(), callRequest.getFallbackMethod(),
				callRequest.getStatusCallback(),
				callRequest.getStatusCallbackMethod(),
				callRequest.getHeartbeatUrl(),
				callRequest.getHeartbeatMethod(),
				callRequest.getForwardedFrom(), callRequest.getSendDigits(),
				callRequest.getTimeout(), callRequest.getHideCallerId(),
				callRequest.getRecord(), callRequest.getRecordCallback(),
				callRequest.getRecordCallbackMethod(),
				callRequest.getTranscribe(),
				callRequest.getTranscribeCallback(),
				callRequest.getTranscribeCallbackMethod());
	}

	/**
	 * @see #hangUpCall(String)
	 * @throws ZangException
	 */
	public Call hangUpCall(String accountSid, String callSid) throws ZangException {
		return returnThrows(callProxy.hangupCall(accountSid, callSid, CallInterruptStatus.COMPLETED));
	}

	/**
	 * Hangs up a call.
	 * 
	 * @param callSid The sid of the Call to hang up.
	 * @return The hung up call.
	 * @throws ZangException
	 */
	public Call hangUpCall(String callSid)
			throws ZangException {
		return hangUpCall(conf.getSid(), callSid);
	}

	/**
	 * @see #sendDigits(String, String, Legs)
	 * @throws ZangException
	 */
	public Call sendDigits(String accountSid, String callSid, String playDtfm,
			Legs dtmfLeg) throws ZangException {
		return returnThrows(callProxy.sendDigits(accountSid, callSid, playDtfm,
				dtmfLeg));
	}

	/**
	 * DTMFs, aka touch tone signals, can be sent to a call.
	 * 
	 * @param callSid
	 *            The call to which to send DTMF signals.
	 * @param playDtfm
	 *            Specifies which touch tone signals to send to a call. W or w
	 *            can be used to include half second pauses within the digit
	 *            transmission. For example: wwww1234 waits two seconds before
	 *            sending the digits and 12wwww34 waits two seconds in between
	 *            the sending of 12 and 34. Allowed values are digits, #, *, W
	 *            or w.
	 * @param dtmfLeg
	 *            Specifies which leg of the call digits will be sent to. 'aleg'
	 *            leg is the originator of the call, 'bleg' is the recipient of
	 *            the call. Defaults to aleg.
	 * @return The call to which DTMF signals are sent.
	 * @throws ZangException
	 */
	public Call sendDigits(String callSid, String playDtfm, Legs dtmfLeg)
			throws ZangException {
		return sendDigits(conf.getSid(), callSid, playDtfm, dtmfLeg);
	}

	/**
	 * @see #playAudioToCall(String, String, Long, Legs, Boolean, Boolean)
	 * @throws ZangException
	 */
	public Call playAudioToCall(String accountSid, String callSid,
			String soundsUrl, Long length, Legs legs, Boolean loop, Boolean mix)
			throws ZangException {
		return returnThrows(callProxy.playAudio(accountSid, callSid, soundsUrl,
				length, legs, loop, mix));
	}

	/**
	 * Zang allows you to play an audio file during a call. This is useful for
	 * playing hold music, providing IVR prompts, etc.
	 * 
	 * @param callSid
	 *            The call to which to play audio to.
	 * @param soundsUrl
	 *            URL containg the sound file to play during the call. If
	 *            multiple sounds are to be played, separate each by a comma in
	 *            the request.
	 * @param length
	 *            Time limit in seconds for audio play back.
	 * @param legs
	 *            Specifies which leg of the call sound will play on. 'aleg' is
	 *            the originator of the call, 'bleg' is the recipient of the
	 *            call. Defaults to both.
	 * @param loop
	 *            Specifies whether sound will loop. Set to true to play sound
	 *            indefinitely. Defaults to false.
	 * @param mix
	 *            Specifies whether sound should mix with call audio.
	 * @return The Call to which audio is played.
	 * @throws ZangException
	 */
	public Call playAudioToCall(String callSid, String soundsUrl, Long length,
			Legs legs, Boolean loop, Boolean mix) throws ZangException {
		return playAudioToCall(conf.getSid(), callSid, soundsUrl, length, legs,
				loop, mix);
	}
	
	/**
	 * Zang allows you to play an audio file during a call. This is useful for
	 * playing hold music, providing IVR prompts, etc. Plays the whole audio to
	 * both legs, without mixing and looping.
	 * 
	 * @param callSid
	 *            The call to which to play audio to.
	 * @param soundsUrl
	 *            URL containg the sound file to play during the call. If
	 *            multiple sounds are to be played, separate each by a comma in
	 *            the request.
	 * @return The Call to which audio is played.
	 * @throws ZangException
	 */
	public Call playAudioToCall(String callSid, String soundsUrl) throws ZangException {
		return playAudioToCall(conf.getSid(), callSid, soundsUrl, null, null,
				null, null);
	}

	/**
	 * @see #voiceEffects(String, AudioDirection, Double, Long, Long, Double)
	 * @throws ZangException
	 */
	public Call voiceEffects(String accountSid, String callSid,
			AudioDirection audioDirection, Double pitch, Long pitchSemiTones,
			Long pitchOctaves, Double rate) throws ZangException {
		return returnThrows(callProxy.voiceEffects(accountSid, callSid,
				audioDirection, pitch, pitchSemiTones, pitchOctaves, rate));
	}

	/**
	 * With Zang you can modify the way a callers voice sounds by changing
	 * things such as speed and pitch of the audio.
	 * 
	 * @param callSid
	 *            The call to which to apply voice effects.
	 * @param audioDirection
	 *            Specifies the stream of audio that effects will occur on. Set
	 *            "in" to change incoming audio stream or "out" to change
	 *            outgoing audio stream. Defaults to out.
	 * @param pitch
	 *            Manually sets the pitch. The lower the value, the lower the
	 *            tone. Must be a value greater than 0. Defaults to 1.
	 * @param pitchSemiTones
	 *            Changes the pitch of audio in semitone intervals. Must be a
	 *            value between -14 and 14. Defaults to 0.
	 * @param pitchOctaves
	 *            Changes the pitch of audio in octave intervals. Must be a
	 *            value between -1 and 1. Defaults to 0.
	 * @param rate
	 *            Manually sets the rate starting from 1. The lower the value,
	 *            the lower the rate. Defaults to 1.
	 * @return The Call to which voice effects are applied.
	 * @throws ZangException
	 */
	public Call voiceEffects(String callSid, AudioDirection audioDirection,
			Double pitch, Long pitchSemiTones, Long pitchOctaves, Double rate)
			throws ZangException {
		return voiceEffects(conf.getSid(), callSid, audioDirection, pitch,
				pitchSemiTones, pitchOctaves, rate);
	}

	/**
	 * @see #recordCall(String, Boolean, Long, String)
	 * @throws ZangException
	 */
	public RecordingList recordCall(String accountSid, String callSid,
			Boolean record, Long timeLimit, String callbackUrl)
			throws ZangException {
		return returnThrows(callProxy.recordCall(accountSid, callSid, record,
				timeLimit, callbackUrl));
	}

	/**
	 * Zang offers a way to both initiate or end a call recording. Both
	 * processes are achieved using the same method. The parameters sent are
	 * what determines whether a recording will start or end if it is already
	 * in-progress.
	 * 
	 * @param callSid
	 *            The call which is to be recorded.
	 * @param record
	 *            Specifies if call recording should beging or end. To start
	 *            recording a call, value must be true. To stop recording a
	 *            call, value must be false.
	 * @param timeLimit
	 *            The time in seconds the duration a call recording should not
	 *            exceed. If no value specified, recordings are 60 seconds by
	 *            default.
	 * @param callbackUrl
	 *            URL where recording information will be relayed to after it
	 *            has completed.
	 * @return A list of recordings.
	 * @throws ZangException
	 */
	public RecordingList recordCall(String callSid, Boolean record, Long timeLimit,
			String callbackUrl) throws ZangException {
		return recordCall(conf.getSid(), callSid, record, timeLimit,
				callbackUrl);
	}

	// CONFERENCE

	/**
	 * @see #viewConference(String)
	 * @throws ZangException
	 */
	public Conference viewConference(String accountSid, String conferenceSid)
			throws ZangException {
		return returnThrows(conferenceProxy.viewConference(accountSid,
				conferenceSid));
	}

	/**
	 * @see #listConferences(String, Boolean, Boolean, Long, Long)
	 * @throws ZangException
	 */
	public ConferenceList listConferences(String accountSid,
			String friendlyName, String status, Date dateCreatedGte,
			Date dateCreatedLt, Date dateUpdatedGte, Date dateUpdatedLt,
			Long page, Long pageSize) throws ZangException {
		return returnThrows(conferenceProxy.listConferences(accountSid,
				friendlyName, status, getDateString(dateCreatedGte),
				getDateString(dateCreatedLt), getDateString(dateUpdatedGte),
				getDateString(dateUpdatedLt), page, pageSize));
	}


	/**
	 * @see #viewParticipant(String, String)
	 * @throws ZangException
	 */
	public Participant viewParticipant(String accountSid, String conferenceSid,
			String callSid) throws ZangException {
		return returnThrows(conferenceProxy.viewParticipant(accountSid,
				conferenceSid, callSid));
	}
	
	/**
	 * Participants of a conference are identified by the CallSid created when
	 * they dial into the conference. To access individual conference
	 * participants, use this method.
	 * 
	 * @param conferenceSid
	 *            The conference the participant is part of.
	 * @param callSid
	 *            The call with which the participant participates in the
	 *            conference.
	 * @return The selected participant.
	 * @throws ZangException
	 */
	public Participant viewParticipant(String conferenceSid, String callSid)
			throws ZangException {
		return returnThrows(conferenceProxy.viewParticipant(conf.getSid(),
				conferenceSid, callSid));
	}
	
	/**
	 * @see #listParticipants(String, Boolean, Boolean, Long, Long)
	 * @throws ZangException
	 */
	public List<Participant> listParticipants(String accountSid,
			String conferenceSid, Boolean muted, Boolean deaf, Long page,
			Long pageSize) throws ZangException {
		return returnThrows(conferenceProxy.listParticipants(accountSid,
				conferenceSid, muted, deaf, page, pageSize));
	}
	
	
	/**
	 * Used to get a list of participants currently connected to a particular
	 * conference.
	 * 
	 * @param conferenceSid
	 *            The sid of the Conference for which participants are
	 *            requested.
	 * @param muted
	 *            Only list participants that are muted. Defaults to false.
	 * @param deaf
	 *            Only list participants that are deaf. Defaults to false.
	 * @param page
	 *            Used to return a particular page within the list.
	 * @param pageSize
	 *            Used to specify the amount of list items to return per page.
	 * @return A list of participants currently connected to a particular
	 *         conference.
	 * @throws ZangException
	 */
	public List<Participant> listParticipants(
			String conferenceSid, Boolean muted, Boolean deaf, Long page,
			Long pageSize) throws ZangException {
		return listParticipants(conf.getSid(), conferenceSid, muted, deaf, page, pageSize);
	}
	
	/**
	 * Convenience method.
	 * @see #listParticipants(String, Boolean, Boolean, Long, Long)
	 * @throws ZangException
	 */
	public List<Participant> listParticipants(String conferenceSid) throws ZangException {
		return listParticipants(conferenceSid, null, null, null, null);
	}
	
	
	/**
	 * @see #deafOrMuteParticipant(String, String, Boolean, Boolean)
	 * @throws ZangException
	 */
	public Participant deafOrMuteParticipant(String accountSid, String conferenceSid, String callSid, Boolean muted, Boolean deaf) throws ZangException {
		return returnThrows(conferenceProxy.muteDeafParticipant(accountSid, conferenceSid, callSid, muted, deaf));
	}
	
	/**
	 * Conference participants can be muted or deafed by calling this method.
	 * 
	 * @param conferenceSid The Conference the participant is a part of.
	 * @param callSid The Call used to identify the participant.
	 * @param muted Specifies whether the participant should be muted.
	 * @param deaf Specifies whether the participant should be deaf.
	 * @return The participant which was muted/unmuted/deafened/undeafened.
	 * @throws ZangException
	 */
	public Participant deafOrMuteParticipant(String conferenceSid, String callSid, Boolean muted, Boolean deaf) throws ZangException {
		return returnThrows(conferenceProxy.muteDeafParticipant(conf.getSid(), conferenceSid, callSid, muted, deaf));
	}
	

	/**
	 * @see #hangupMember(String, String)
	 * @throws ZangException
	 */
	public Participant hangupParticipant(String accountSid, String conferenceSid,
			String callSid) throws ZangException {
		return returnThrows(conferenceProxy.hangupParticipant(accountSid, conferenceSid, callSid));
	}
	
	/**
	 * Hangup conference members by conference sid and call sid.
	 * 
	 * @param conferenceSid
	 *            The sid of the requested Conference.
	 * @param callSid
	 *            Specifies the member to hangup via the call used by the member
	 *            to enter the conference.
	 * @return The Participant which was hung up on.
	 * @throws ZangException
	 */
	public Participant hangupParticipant(String conferenceSid, String callSid)
			throws ZangException {
		return returnThrows(conferenceProxy.hangupParticipant(conf.getSid(),
				conferenceSid, callSid));
	}

	/**
	 * @see #playAudioToParticipant(String, String, String)
	 * @throws ZangException
	 */
	public Participant playAudioToParticipant(String accountSid,
			String conferenceSid, String callSid, String url)
			throws ZangException {
		return returnThrows(conferenceProxy.playAudioToParticipant(accountSid,
				conferenceSid, callSid, url));
	}

	/**
	 * Resource properties about conference calls that occurred through a Zang
	 * account can be requested using our API.
	 * 
	 * @param conferenceSid
	 *            The sid of the requested Conference.
	 * @return The requested conference.
	 * @throws ZangException
	 */
	public Conference viewConference(String conferenceSid)
			throws ZangException {
		return viewConference(conf.getSid(), conferenceSid);
	}

	/**
	 * To view a list of all conference resources associated with a given
	 * account, the URI below is provided. The response returned lists
	 * conferences in chronological order and includes information on each
	 * member of the conference.
	 * 
	 * @param friendlyName
	 *            List conferences with the given FriendlyName.
	 * @param status
	 *            List conferences with the given status. Allowed values are:
	 *            init, in-progress, or completed.
	 * @param dateCreatedGte
	 *            List conferences created on or after this date.
	 * @param dateCreatedLt
	 *            List conferences created before this date.
	 * @param dateUpdatedGte
	 *            List conferences updated on or after this date.
	 * @param dateUpdatedLt
	 *            List conferences updated before this date.
	 * @param page
	 *            Used to return a particular page within the list.
	 * @param pageSize
	 *            Used to specify the amount of list items to return per page.
	 * @return A list of Conferences accorded to the specified parameters.s
	 * @throws ZangException
	 */
	public ConferenceList listConferences(String friendlyName, String status, Date dateCreatedGte,
			Date dateCreatedLt, Date dateUpdatedGte, Date dateUpdatedLt,
			Long page, Long pageSize) throws ZangException {
		return listConferences(conf.getSid(), friendlyName, status,
				dateCreatedGte, dateCreatedLt, dateUpdatedGte, dateUpdatedLt,
				page, pageSize);
	}
	
	/**
	 * To view a list of all conference resources associated with a given
	 * account, the URI below is provided. The response returned lists
	 * conferences in chronological order and includes information on each
	 * member of the conference.
	 * 
	 * @return A list of all the Conferences belonging to the account.
	 * @throws ZangException
	 */
	public ConferenceList listConferences() throws ZangException {
		return listConferences(null, null, null, null, null, null, null, null);
	}

	/**
	 * Pre-recorded sound from a file can be played to conference members.
	 * 
	 * @param conferenceSid
	 *            The sid of the requested Conference.
	 * @param callSid
	 *            Specifies the conference member to be spoken to via Call sid.
	 * @param audioUrl
	 *            URL containing the audio file to play.
	 * @return The Participant to which the audio was played.
	 * @throws ZangException
	 */
	public Participant playAudioToParticipant(String conferenceSid,
			String callSid, String audioUrl) throws ZangException {
		return playAudioToParticipant(conf.getSid(), conferenceSid, callSid,
				audioUrl);
	}

	// APPLICATIONS

	/**
	 * @see #viewApplication(String)
	 * @throws ZangException
	 */
	public Application viewApplication(String accountSid, String applicationSid)
			throws ZangException {
		return returnThrows(applicationProxy.viewApplication(accountSid,
				applicationSid));
	}

	/**
	 * @see #listApplications(String, Long, Long)
	 * @throws ZangException
	 */
	public ApplicationList listApplications(String accountSid,
			String friendlyName, Long page, Long pageSize)
			throws ZangException {
		return returnThrows(applicationProxy.listApplications(accountSid,
				friendlyName, page, pageSize));
	}

	/**
	 * @see #createApplication(String, String, HttpMethod, String, HttpMethod,
	 *      Boolean, String, HttpMethod, String, HttpMethod, String, HttpMethod,
	 *      String, HttpMethod)
	 * @throws ZangException
	 */
	public Application createApplication(String accountSid,
			String friendlyName, String voiceUrl, HttpMethod voiceMethod,
			String voiceFallbackUrl, HttpMethod voiceFallbackMethod,
			Boolean voiceCallerIdLookup, String smsUrl, HttpMethod smsMethod,
			String smsFallbackUrl, HttpMethod smsFallbackMethod,
			String heartbeatUrl, HttpMethod heartbeatMethod,
			String hangupCallback, HttpMethod hangupCallbackMethod)
			throws ZangException {
		return returnThrows(applicationProxy.createApplication(accountSid,
				friendlyName, voiceUrl, voiceMethod, voiceFallbackUrl,
				voiceFallbackMethod, voiceCallerIdLookup, smsUrl, smsMethod,
				smsFallbackUrl, smsFallbackMethod, heartbeatUrl,
				heartbeatMethod, hangupCallback, hangupCallbackMethod));
	}

	/**
	 * @see #createApplication(String, String, HttpMethod, String, HttpMethod,
	 *      Boolean, String, HttpMethod, String, HttpMethod, String, HttpMethod,
	 *      String, HttpMethod)
	 * @throws ZangException
	 */
	public Application createApplication(ApplicationRequest applicationRequest)
			throws ZangException {
		String accountSid = conf.getSid();
		if (applicationRequest.getAccountSid() != null) {
			accountSid = applicationRequest.getAccountSid();
		}
		return createApplication(accountSid,
				applicationRequest.getFriendlyName(),
				applicationRequest.getVoiceUrl(),
				applicationRequest.getVoiceMethod(),
				applicationRequest.getVoiceFallbackUrl(),
				applicationRequest.getVoiceFallbackMethod(),
				applicationRequest.getVoiceCallerIdLookup(),
				applicationRequest.getSmsUrl(),
				applicationRequest.getSmsMethod(),
				applicationRequest.getSmsFallbackUrl(),
				applicationRequest.getSmsFallbackMethod(),
				applicationRequest.getHeartbeatUrl(),
				applicationRequest.getHeartbeatMethod(),
				applicationRequest.getStatusCallback(),
				applicationRequest.getStatusCallbackMethod());
	}

	/**
	 * @see #updateApplication(String, String, String, HttpMethod, String,
	 *      HttpMethod, Boolean, String, HttpMethod, String, HttpMethod, String,
	 *      HttpMethod, String, HttpMethod)
	 * @throws ZangException
	 */
	public Application updateApplication(String accountSid,
			String applicationSid, String friendlyName, String voiceUrl,
			HttpMethod voiceMethod, String voiceFallbackUrl,
			HttpMethod voiceFallbackMethod, Boolean voiceCallerIdLookup,
			String smsUrl, HttpMethod smsMethod, String smsFallbackUrl,
			HttpMethod smsFallbackMethod, String heartbeatUrl,
			HttpMethod heartbeatMethod, String hangupCallback,
			HttpMethod hangupCallbackMethod) throws ZangException {
		return returnThrows(applicationProxy.updateApplication(accountSid,
				applicationSid, friendlyName, voiceUrl, voiceMethod,
				voiceFallbackUrl, voiceFallbackMethod, voiceCallerIdLookup,
				smsUrl, smsMethod, smsFallbackUrl, smsFallbackMethod,
				heartbeatUrl, heartbeatMethod, hangupCallback,
				hangupCallbackMethod));
	}

	/**
	 * @see #updateApplication(String, String, String, HttpMethod, String,
	 *      HttpMethod, Boolean, String, HttpMethod, String, HttpMethod, String,
	 *      HttpMethod, String, HttpMethod)
	 * @throws ZangException
	 */
	public Application updateApplication(ApplicationRequest applicationRequest)
			throws ZangException {
		String accountSid = conf.getSid();
		if (applicationRequest.getAccountSid() != null) {
			accountSid = applicationRequest.getAccountSid();
		}
		return updateApplication(accountSid, applicationRequest.getSid(),
				applicationRequest.getFriendlyName(),
				applicationRequest.getVoiceUrl(),
				applicationRequest.getVoiceMethod(),
				applicationRequest.getVoiceFallbackUrl(),
				applicationRequest.getVoiceFallbackMethod(),
				applicationRequest.getVoiceCallerIdLookup(),
				applicationRequest.getSmsUrl(),
				applicationRequest.getSmsMethod(),
				applicationRequest.getSmsFallbackUrl(),
				applicationRequest.getSmsFallbackMethod(),
				applicationRequest.getHeartbeatUrl(),
				applicationRequest.getHeartbeatMethod(),
				applicationRequest.getStatusCallback(),
				applicationRequest.getStatusCallbackMethod());
	}

	/**
	 * @see #deleteApplication(String)
	 * @throws ZangException
	 */
	public Application deleteApplication(String accountSid,
			String applicationSid) throws ZangException {
		return returnThrows(applicationProxy.deleteApplication(accountSid,
				applicationSid));
	}

	/**
	 * Zang offers the ability to preset all voice and sms urls for a given
	 * application name. This application can then be assigned to multiple
	 * numbers so you don't have to update all of their urls manually.
	 * Application details can be accessed by using this method.
	 * 
	 * @param applicationSid
	 *            The sid of the requested Application.
	 * @return The requested application.
	 * @throws ZangException
	 */
	public Application viewApplication(String applicationSid)
			throws ZangException {
		return viewApplication(conf.getSid(), applicationSid);
	}

	/**
	 * Used to get a list of application resources associated with a given
	 * account.
	 * 
	 * @param friendlyName
	 *            Specifies that only application resources matching the input
	 *            FreindlyName should be returned in the list request.
	 * @param page
	 *            Used to return a particular page within the list.
	 * @param pageSize
	 *            Used to specify the amount of list items to return per page.
	 * @return A list of applications.
	 * @throws ZangException
	 */
	public ApplicationList listApplications(String friendlyName, Long page,
			Long pageSize) throws ZangException {
		return listApplications(conf.getSid(), friendlyName, page, pageSize);
	}
	
	/**
	 * Used to get a list of all application resources associated with a given
	 * account.
	 * 
	 * @return A list of all applications.
	 * @throws ZangException
	 */
	public ApplicationList listApplications() throws ZangException {
		return listApplications(conf.getSid(), null, null, null);
	}

	/**
	 * Creates a new application for managing Zang phone numbers,
	 * 
	 * @param friendlyName
	 *            The name used to identify this application.
	 * @param voiceUrl
	 *            The URL returning InboundXML incoming calls should execute
	 *            when connected.
	 * @param voiceMethod
	 *            Specifies the HTTP method used to request the VoiceUrl once
	 *            incoming call connects. Defaults to POST.
	 * @param voiceFallbackUrl
	 *            URL used if any errors occur during execution of InboundXML on
	 *            a call or at initial request of the VoiceUrl.
	 * @param voiceFallbackMethod
	 *            Specifies the HTTP method (GET or POST) used to request the
	 *            VoiceFallBackUrl if it is needed. Defaults to POST.
	 * @param voiceCallerIdLookup
	 *            Look up the caller's caller ID name from the CNAM database
	 *            (additional charges apply). Defaults to false.
	 * @param smsUrl
	 *            The URL returning InboundXML incoming phone numbers should
	 *            execute when receiving an sms.
	 * @param smsMethod
	 *            The HTTP method used when making requests to the SmsUrl.
	 *            Either GET or POST.
	 * @param smsFallbackUrl
	 *            URL used if any errors occur during execution of InboundXML
	 *            from an sms or at initial request of the SmsUrl.
	 * @param smsFallbackMethod
	 *            Specifies the HTTP method (GET or POST) used to request the
	 *            SmsFallbackUrl. Defaults to POST.
	 * @param heartbeatUrl
	 *            URL that can be used to monitor the phone number.
	 * @param heartbeatMethod
	 *            The HTTP method Zang will use when requesting the
	 *            HeartbeatURL. Either GET or POST. Defaults to POST.
	 * @param hangupCallback
	 *            URL that can be requested to receive notification when and how
	 *            incoming call has ended.
	 * @param hangupCallbackMethod
	 *            Specifies the HTTP method (GET or POST) used to request the
	 *            HangupCallback URL.
	 * @return The created Application.
	 * @throws ZangException
	 */
	public Application createApplication(String friendlyName, String voiceUrl,
			HttpMethod voiceMethod, String voiceFallbackUrl,
			HttpMethod voiceFallbackMethod, Boolean voiceCallerIdLookup,
			String smsUrl, HttpMethod smsMethod, String smsFallbackUrl,
			HttpMethod smsFallbackMethod, String heartbeatUrl,
			HttpMethod heartbeatMethod, String hangupCallback,
			HttpMethod hangupCallbackMethod) throws ZangException {
		return createApplication(conf.getSid(), friendlyName, voiceUrl,
				voiceMethod, voiceFallbackUrl, voiceFallbackMethod,
				voiceCallerIdLookup, smsUrl, smsMethod, smsFallbackUrl,
				smsFallbackMethod, heartbeatUrl, heartbeatMethod,
				hangupCallback, hangupCallbackMethod);
	}

	/**
	 * Used to update an existing application.
	 * 
	 * @param applicationSid
	 *            The sid of the application to update.
	 * @param friendlyName
	 *            The name used to identify this application.
	 * @param voiceUrl
	 *            The URL returning InboundXML incoming calls should execute
	 *            when connected.
	 * @param voiceMethod
	 *            Specifies the HTTP method used to request the VoiceUrl once
	 *            incoming call connects. Defaults to POST.
	 * @param voiceFallbackUrl
	 *            URL used if any errors occur during execution of InboundXML on
	 *            a call or at initial request of the VoiceUrl.
	 * @param voiceFallbackMethod
	 *            Specifies the HTTP method (GET or POST) used to request the
	 *            VoiceFallBackUrl if it is needed. Defaults to POST.
	 * @param voiceCallerIdLookup
	 *            Look up the caller's caller ID name from the CNAM database
	 *            (additional charges apply). Defaults to false.
	 * @param smsUrl
	 *            The URL returning InboundXML incoming phone numbers should
	 *            execute when receiving an sms.
	 * @param smsMethod
	 *            The HTTP method used when making requests to the SmsUrl.
	 *            Either GET or POST.
	 * @param smsFallbackUrl
	 *            URL used if any errors occur during execution of InboundXML
	 *            from an sms or at initial request of the SmsUrl.
	 * @param smsFallbackMethod
	 *            Specifies the HTTP method (GET or POST) used to request the
	 *            SmsFallbackUrl. Defaults to POST.
	 * @param heartbeatUrl
	 *            URL that can be used to monitor the phone number.
	 * @param heartbeatMethod
	 *            The HTTP method Zang will use when requesting the
	 *            HeartbeatURL. Either GET or POST. Defaults to POST.
	 * @param hangupCallback
	 *            URL that can be requested to receive notification when and how
	 *            incoming call has ended.
	 * @param hangupCallbackMethod
	 *            Specifies the HTTP method (GET or POST) used to request the
	 *            HangupCallback URL.
	 * @return The edited Application.
	 * @throws ZangException
	 */
	public Application updateApplication(String applicationSid,
			String friendlyName, String voiceUrl, HttpMethod voiceMethod,
			String voiceFallbackUrl, HttpMethod voiceFallbackMethod,
			Boolean voiceCallerIdLookup, String smsUrl, HttpMethod smsMethod,
			String smsFallbackUrl, HttpMethod smsFallbackMethod,
			String heartbeatUrl, HttpMethod heartbeatMethod,
			String hangupCallback, HttpMethod hangupCallbackMethod)
			throws ZangException {
		return updateApplication(conf.getSid(), applicationSid, friendlyName,
				voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod,
				voiceCallerIdLookup, smsUrl, smsMethod, smsFallbackUrl,
				smsFallbackMethod, heartbeatUrl, heartbeatMethod,
				hangupCallback, hangupCallbackMethod);
	}

	/**
	 * Deletes an existing application.
	 * 
	 * @param applicationSid
	 *            The sid of the Application to delete.
	 * @return The deleted application.
	 * @throws ZangException
	 */
	public Application deleteApplication(String applicationSid)
			throws ZangException {
		return deleteApplication(conf.getSid(), applicationSid);
	}

	// INCOMING PHONE NUMBERS

	/**
	 * @see #viewIncomingPhoneNumber(String)
	 * @throws ZangException
	 */
	public IncomingPhoneNumber viewIncomingPhoneNumber(String accountSid,
			String incomingPhoneNumberSid) throws ZangException {
		return returnThrows(incomingPhoneNumberProxy.viewIncomingPhoneNumber(
				accountSid, incomingPhoneNumberSid));
	}

	/**
	 * @see #listIncomingPhoneNumbers(String, String, Long, Long)
	 * @throws ZangException
	 */
	public IncomingPhoneNumberList listIncomingPhoneNumbers(String accountSid,
			String phoneNumber, String friendlyName, Long page, Long pageSize)
			throws ZangException {
		return returnThrows(incomingPhoneNumberProxy.listIncomingPhoneNumbers(
				accountSid, phoneNumber, friendlyName, page, pageSize));
	}

	/**
	 * @see #addIncomingPhoneNumber(String, String)
	 * @throws ZangException
	 */
	public IncomingPhoneNumber addIncomingPhoneNumber(String accountSid,
			String phoneNumber, String areaCode) throws ZangException {
		return returnThrows(incomingPhoneNumberProxy.addIncomingPhoneNumber(
				accountSid, phoneNumber, areaCode));
	}

	/**
	 * @see #deleteIncomingPhoneNumber(String)
	 * @throws ZangException
	 */
	public IncomingPhoneNumber deleteIncomingPhoneNumber(String accountSid,
			String incomingPhoneNumberSid) throws ZangException {
		return returnThrows(incomingPhoneNumberProxy.deleteIncomingPhoneNumber(
				accountSid, incomingPhoneNumberSid));
	}

	/**
	 * @see #updateIncomingPhoneNumber(String, String, String, HttpMethod,
	 *      String, HttpMethod, Boolean, String, HttpMethod, String, HttpMethod,
	 *      String, HttpMethod, String, HttpMethod)
	 * @throws ZangException
	 */
	public IncomingPhoneNumber updateIncomingPhoneNumber(String accountSid,
			String incomingPhoneNumberSid, String friendlyName,
			String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl,
			HttpMethod voiceFallbackMethod, Boolean voiceCallerIdLookup,
			String smsUrl, HttpMethod smsMethod, String smsFallbackUrl,
			HttpMethod smsFallbackMethod, String hangupCallback,
			HttpMethod hangupCallbackMethod, String heartbeatUrl,
			HttpMethod heartbeatMethod) throws ZangException {
		return returnThrows(incomingPhoneNumberProxy.updateIncomingPhoneNumber(
				accountSid, incomingPhoneNumberSid, friendlyName, voiceUrl,
				voiceMethod, voiceFallbackUrl, voiceFallbackMethod,
				voiceCallerIdLookup, smsUrl, smsMethod, smsFallbackUrl,
				smsFallbackMethod, hangupCallback, hangupCallbackMethod,
				heartbeatUrl, heartbeatMethod));
	}

	/**
	 * @see #updateIncomingPhoneNumber(String, String, String, HttpMethod,
	 *      String, HttpMethod, Boolean, String, HttpMethod, String, HttpMethod,
	 *      String, HttpMethod)
	 * @throws ZangException
	 */
	public IncomingPhoneNumber updateIncomingPhoneNumber(
			IncomingPhoneNumberRequest ipnRequest) throws ZangException {
		String accountSid = conf.getSid();
		if (ipnRequest.getAccountSid() != null) {
			accountSid = ipnRequest.getAccountSid();
		}
		return updateIncomingPhoneNumber(accountSid,
				ipnRequest.getIncomingPhoneNumberSid(),
				ipnRequest.getFriendlyName(), ipnRequest.getVoiceUrl(),
				ipnRequest.getVoiceMethod(), ipnRequest.getVoiceFallbackUrl(),
				ipnRequest.getVoiceFallbackMethod(),
				ipnRequest.getVoiceCallerIdLookup(), ipnRequest.getSmsUrl(),
				ipnRequest.getSmsMethod(), ipnRequest.getSmsFallbackUrl(),
				ipnRequest.getSmsFallbackMethod(),
				ipnRequest.getHangupCallback(),
				ipnRequest.getHangupCallbackMethod(),
				ipnRequest.getHeartbeatUrl(), ipnRequest.getHeartbeatMethod());
	}

	/**
	 * Zang phone numbers associated with an account are represented with the
	 * IncomingPhoneNumber resource. This method gets information about an
	 * IncomingPhoneNumber.
	 * 
	 * @param incomingPhoneNumberSid
	 *            An alphanumeric string used for identification of incoming
	 *            phone numbers.
	 * @return The requested IncomingPhoneNumber.
	 * @throws ZangException
	 */
	public IncomingPhoneNumber viewIncomingPhoneNumber(
			String incomingPhoneNumberSid) throws ZangException {
		return viewIncomingPhoneNumber(conf.getSid(), incomingPhoneNumberSid);
	}

	/**
	 * Retrieves a list of incoming phone number resources associated with a
	 * given account.
	 * 
	 * @param phoneNumber
	 *            Specifies which IncomingPhoneNumber resources should be
	 *            returned in the list request.
	 * @param friendlyName
	 *            Specifies that only IncomingPhoneNumber resources matching the
	 *            input FreindlyName should be returned in the list request.
	 * @param page
	 *            Used to return a particular page within the list.
	 * @param pageSize
	 *            Used to specify the amount of list items to return per page.
	 * @return A list of IncomingPhoneNumber resources.
	 * @throws ZangException
	 */
	public IncomingPhoneNumberList listIncomingPhoneNumbers(String phoneNumber,
			String friendlyName, Long page, Long pageSize)
			throws ZangException {
		return listIncomingPhoneNumbers(conf.getSid(), phoneNumber,
				friendlyName, page, pageSize);
	}
	
	/**
	 * Retrieves a list of all incoming phone number resources associated with a
	 * given account.
	 * 
	 * @return A list of all IncomingPhoneNumber resources.
	 * @throws ZangException
	 */
	public IncomingPhoneNumberList listIncomingPhoneNumbers()
			throws ZangException {
		return listIncomingPhoneNumbers(conf.getSid(), null,
				null, null, null);
	}

	/**
	 * Zang incoming phone numbers can be added or removed from an account
	 * through our REST API. Note that adding numbers to an account via the REST
	 * API costs the same as purchasing them through your account dashboard on
	 * zang.io.
	 * 
	 * @param phoneNumber
	 *            Desired phone number to add to the account (E.164 format).
	 *            Must be a valid and available phone number (see
	 *            {@link #listAvailablePhoneNumbers(String, String, String, String, String)}
	 *            ).
	 * @param areaCode
	 *            Desired area code of phone number to add to the account.
	 * @return The added IncomingPhoneNumber.s
	 * @throws ZangException
	 */
	public IncomingPhoneNumber addIncomingPhoneNumber(String phoneNumber,
			String areaCode) throws ZangException {
		return addIncomingPhoneNumber(conf.getSid(), phoneNumber, areaCode);
	}

	/**
	 * Deletes an IncomingPhoneNumber from your account. If the deletion is
	 * successful the incoming phone number resource of the item you have
	 * deleted will be returned. Please keep in mind that this resource item
	 * will be visible only once after deletion in the return so note anything
	 * about the resource you may need before it no longer exists.
	 * 
	 * @param incomingPhoneNumberSid
	 *            The sid of the IncomingPhoneNumber which is to be deleted.
	 * @return The deleted IncomingPhoneNumber
	 * @throws ZangException
	 */
	public IncomingPhoneNumber deleteIncomingPhoneNumber(
			String incomingPhoneNumberSid) throws ZangException {
		return deleteIncomingPhoneNumber(conf.getSid(), incomingPhoneNumberSid);
	}

	/**
	 * Updates properties of an IncomingPhoneNumber.
	 * 
	 * @param incomingPhoneNumberSid
	 *            The sid of the IncomingPhoneNumber which is to be updated.
	 * @param friendlyName
	 *            The Zang phone number in an easier to read domestic format
	 *            (e.g. 1234567890 to (123)-456-7890).
	 * @param voiceUrl
	 *            The URL returning InboundXML incoming phone numbers should
	 *            execute when connected.
	 * @param voiceMethod
	 *            Specifies the HTTP method used to request the VoiceUrl once
	 *            incoming call connects.
	 * @param voiceFallbackUrl
	 *            URL used if any errors occur during execution of InboundXML
	 *            during a call or at initial request of the VoiceUrl.
	 * @param voiceFallbackMethod
	 *            Specifies the HTTP method used to request the VoiceFallBackUrl
	 *            if it is needed.
	 * @param voiceCallerIdLookup
	 *            Specifies whether CNAM caller ID look up is enabled with a
	 *            particular incoming number.
	 * @param hangupCallback
	 *            URL that can be requested to receive notification when and how
	 *            incoming call has ended.
	 * @param hangupCallbackMethod
	 *            Specifies the HTTP method used to request the HangupCallback
	 *            URL.
	 * @param heartbeatUrl
	 *            URL that can be requested every 60 seconds during the call to
	 *            notify of elapsed time and pass other general information.
	 * @param heartBeatMethod
	 *            Specifies the HTTP method used to request the Heartbeat URL.
	 * @param smsUrl
	 *            The URL returning InboundXML incoming phone numbers should
	 *            execute when receiving an sms.
	 * @param smsMethod
	 *            Specifies the HTTP method used to request the SmsUrl.
	 * @param smsFallbackUrl
	 *            URL used if any errors occur during execution of InboundXML
	 *            from an sms or at initial request of the SmsUrl.
	 * @param smsFallbackMethod
	 *            Specifies the HTTP method used to request the SmsFallbackUrl.
	 * @return The updated IncomingPhoneNumber.
	 * @throws ZangException
	 */
	public IncomingPhoneNumber updateIncomingPhoneNumber(
			String incomingPhoneNumberSid, String friendlyName,
			String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl,
			HttpMethod voiceFallbackMethod, Boolean voiceCallerIdLookup,
			String smsUrl, HttpMethod smsMethod, String smsFallbackUrl,
			HttpMethod smsFallbackMethod, String hangupCallback,
			HttpMethod hangupCallbackMethod, String heartbeatUrl,
			HttpMethod heartbeatMethod) throws ZangException {
		return updateIncomingPhoneNumber(conf.getSid(), incomingPhoneNumberSid,
				friendlyName, voiceUrl, voiceMethod, voiceFallbackUrl,
				voiceFallbackMethod, voiceCallerIdLookup, smsUrl, smsMethod,
				smsFallbackUrl, smsFallbackMethod, hangupCallback,
				hangupCallbackMethod, heartbeatUrl, heartbeatMethod);
	}

	// AVAILABLE PHONE NUMBERS

	/**
	 * @see #listAvailablePhoneNumbers(String, String, String, String, String)
	 * @throws ZangException
	 */
	public AvailablePhoneNumberList listAvailablePhoneNumbers(
			String accountSid, String isoCountryCode, String areaCode,
			String contains, String inRegion, String inPostalCode, Long page, Long pageSize)
			throws ZangException {
		return returnThrows(availablePhoneNumberProxy
				.listAvailablePhoneNumbers(accountSid, isoCountryCode,
						areaCode, contains, inRegion, inPostalCode, page, pageSize));
	}

	/**
	 * If you want to add a new Zang number, you need to know what ones are
	 * available. Our REST API provides a way to request a list of available
	 * numbers along with all of their resource properties so you know the
	 * numbers you have to choose from.
	 * 
	 * @param isoCountryCode
	 *            ISO country code used for search (required).
	 * @param areaCode
	 *            Specifies the area code that the returned list of available
	 *            numbers should be in. Only available for North American
	 *            numbers
	 * @param contains
	 *            Specifies the desired characters contained within the
	 *            available numbers to list. Allowed values are 0-9, Aa-Zz and
	 *            *.
	 * @param inRegion
	 *            Specifies the desired region of the available numbers to be
	 *            listed.
	 * @param inPostalCode
	 *            Specifies the desired postal code of the available numbers to
	 *            be listed.
	 * @param page
	 *            Used to return a particular page within the list.
	 * @param pageSize
	 *            Used to specify the amount of list items to return per page.
	 * @return A list of available phone numbers.
	 * @throws ZangException
	 */
	public AvailablePhoneNumberList listAvailablePhoneNumbers(
			String isoCountryCode, String areaCode, String contains,
			String inRegion, String inPostalCode, Long page, Long pageSize) throws ZangException {
		return returnThrows(availablePhoneNumberProxy
				.listAvailablePhoneNumbers(conf.getSid(), isoCountryCode,
						areaCode, contains, inRegion, inPostalCode, page, pageSize));
	}

	// RECORDINGS

	/**
	 * @see #listRecordings(Date, Date, Long, Long)
	 * @throws ZangException
	 */
	public RecordingList listRecordings(String accountSid, Date dateCreatedGte,
			Date dateCreatedLt, Long page, Long pageSize)
			throws ZangException {
		return returnThrows(recordingProxy.listRecordings(accountSid,
				getDateString(dateCreatedGte), getDateString(dateCreatedLt),
				page, pageSize));
	}

	/**
	 * Gets a list of Recordings.
	 * 
	 * @param dateCreatedGte
	 *            Recordings with a creation date greater or equal than this
	 *            will be returned.
	 * @param dateCreatedLt
	 *            Recordings with a creation date lesser than this will be
	 *            returned.
	 * @param page
	 *            Used to return a particular page within the list.
	 * @param pageSize
	 *            Used to specify the amount of list items to return per page.
	 * @return A list of Recordings.
	 * @throws ZangException
	 */
	public RecordingList listRecordings(Date dateCreatedGte,
			Date dateCreatedLt, Long page, Long pageSize)
			throws ZangException {
		return listRecordings(conf.getSid(), dateCreatedGte, dateCreatedLt,
				page, pageSize);
	}
	
	/**
	 * Gets a list of all Recordings.
	 * 
	 * @return A list of all Recordings.
	 * @throws ZangException
	 */
	public RecordingList listRecordings()
			throws ZangException {
		return listRecordings(conf.getSid(), null, null,
				null, null);
	}

	/**
	 * @see #listCallRecordings(String, Date, Date, Long, Long)
	 * @throws ZangException
	 */
	public RecordingList listCallRecordings(String accountSid, String callSid,
			Date dateCreatedGte, Date dateCreatedLt, Long page, Long pageSize)
			throws ZangException {
		return returnThrows(recordingProxy.listCallRecordings(accountSid,
				callSid, getDateString(dateCreatedGte),
				getDateString(dateCreatedLt), page, pageSize));
	}

	/**
	 * Gets a list of Recordings which belong to a specified Call.
	 * 
	 * @param callSid
	 *            The sid of the Call for which the recordings are requested.
	 * @param dateCreatedGte
	 *            Recordings with a creation date greater or equal than this
	 *            will be returned.
	 * @param dateCreatedLt
	 *            Recordings with a creation date lesser than this will be
	 *            returned.
	 * @param page
	 *            Used to return a particular page within the list.
	 * @param pageSize
	 *            Used to specify the amount of list items to return per page.
	 * @return A list of Recordings.
	 * @throws ZangException
	 */
	public RecordingList listCallRecordings(String callSid,
			Date dateCreatedGte, Date dateCreatedLt, Long page, Long pageSize)
			throws ZangException {
		return listCallRecordings(conf.getSid(), callSid, dateCreatedGte,
				dateCreatedLt, page, pageSize);
	}

	/**
	 * @see #viewRecording(String)
	 * @throws ZangException
	 */
	public Recording viewRecording(String accountSid, String recordingSid)
			throws ZangException {
		return returnThrows(recordingProxy.viewRecording(accountSid,
				recordingSid));
	}

	/**
	 * A single recording details can be viewed by calling this method.
	 * 
	 * @param recordingSid
	 *            The sid of the requested Recording (required).
	 * @return The requested Recording.
	 * @throws ZangException
	 */
	public Recording viewRecording(String recordingSid) throws ZangException {
		return viewRecording(conf.getSid(), recordingSid);
	}

	/**
	 * @see #getRecordingUrl(String)
	 * @throws ZangException
	 */
	public String getRecordingUrl(String accountSid, String recordingSid)
			throws ZangException {
		ClientResponse<String> response = recordingProxy.getRecording(accountSid, recordingSid);
		String retVal = response.getLocation().getHref();
		returnThrows(response);
		return retVal;
	}

	/**
	 * Gets the URL of the audio file containing the recording.
	 * 
	 * @param recordingSid
	 *            The recording for which the audio file is requested.
	 * @return The URL to the audio file containing the selected Recording.
	 * @throws ZangException
	 */
	public String getRecordingUrl(String recordingSid) throws ZangException {
		return getRecordingUrl(conf.getSid(), recordingSid);
	}

	// NOTIFICATIONS

	/**
	 * @see #listNotifications(LogLevel, Long, Long)
	 * @throws ZangException
	 */
	public NotificationList listNotifications(String accountSid, LogLevel log,
			Long page, Long pageSize) throws ZangException {
		return returnThrows(notificationProxy.listNotifications(accountSid,
				log, page, pageSize));
	}

	/**
	 * Returns a list of notifications associated with the account.
	 * 
	 * @param log
	 *            Specifies that only notifications with the given log level
	 *            value should be listed. INFO, WARNING, or ERROR.
	 * @param page
	 *            Used to return a particular page within the list.
	 * @param pageSize
	 *            Used to specify the amount of list items to return per page.
	 * @return A list of Notifications.
	 * @throws ZangException
	 */
	public NotificationList listNotifications(LogLevel log, Long page,
			Long pageSize) throws ZangException {
		return listNotifications(conf.getSid(), log, page, pageSize);
	}
	
	/**
	 * Returns a list of all notifications associated with the account.
	 * 
	 * @return A list of all Notifications.
	 * @throws ZangException
	 */
	public NotificationList listNotifications() throws ZangException {
		return listNotifications(conf.getSid(), null, null, null);
	}

	/**
	 * @see #listCallNotifications(String, LogLevel, Long, Long)
	 * @throws ZangException
	 */
	public NotificationList listCallNotifications(String accountSid,
			String callSid, LogLevel log, Long page, Long pageSize)
			throws ZangException {
		return returnThrows(notificationProxy.listCallNotifications(accountSid,
				callSid, log, page, pageSize));
	}

	/**
	 * Returns a list of notifications associated with a certain Call.
	 * 
	 * @param callSid
	 *            The sid of the Call for which Notifications are to be
	 *            retrieved.
	 * @param log
	 *            Specifies that only notifications with the given log level
	 *            value should be listed. INFO, WARNING, or ERROR.
	 * @param page
	 *            Used to return a particular page within the list.
	 * @param pageSize
	 *            Used to specify the amount of list items to return per page.
	 * @return A list of Notifications.
	 * @throws ZangException
	 */
	public NotificationList listCallNotifications(String callSid, LogLevel log,
			Long page, Long pageSize) throws ZangException {
		return listCallNotifications(conf.getSid(), callSid, log, page,
				pageSize);
	}

	/**
	 * @see #viewNotification(String)
	 * @throws ZangException
	 */
	public Notification viewNotification(String accountSid,
			String notificationSid) throws ZangException {
		return returnThrows(notificationProxy.viewNotification(accountSid,
				notificationSid));
	}

	/**
	 * Retrieves details about a Notification.
	 * 
	 * @param notificationSid
	 *            The sid of the Notification to be retrieved.
	 * @return The requested Notification.
	 * @throws ZangException
	 */
	public Notification viewNotification(String notificationSid)
			throws ZangException {
		return viewNotification(conf.getSid(), notificationSid);
	}

	// TRANSCRIPTIONS

	/**
	 * @see #viewTranscription(String)
	 * @throws ZangException
	 */
	public Transcription viewTranscription(String accountSid,
			String transcriptionSid) throws ZangException {
		return returnThrows(transcriptionProxy.viewTranscription(accountSid,
				transcriptionSid));
	}

	/**
	 * @see #viewTranscriptionText(String)
	 * @throws ZangException
	 */
	public String viewTranscriptionText(String accountSid,
			String transcriptionSid) throws ZangException {
		return returnThrows(transcriptionProxy.viewTranscriptionText(
				accountSid, transcriptionSid));
	}

	/**
	 * @see #listTranscriptions(TranscriptionStatus, Date, Date, Long, Long)
	 * @throws ZangException
	 */
	public TranscriptionList listTranscriptions(String accountSid, TranscriptionStatus status, Date dateTranscribedGte, Date dateTranscribedLt, Long page,
			Long pageSize) throws ZangException {
		return returnThrows(transcriptionProxy.listTranscriptions(accountSid, status, getDateString(dateTranscribedGte), getDateString(dateTranscribedLt),
				page, pageSize));
	}

	/**
	 * @see #listRecordingTranscriptions(String, TranscriptionStatus, Date, Date, Long, Long)
	 * @throws ZangException
	 */
	public TranscriptionList listRecordingTranscriptions(String accountSid, String recordingSid,
			TranscriptionStatus status, Date dateTranscribedGte, Date dateTranscribedLt, Long page,
			Long pageSize) throws ZangException {
		return returnThrows(transcriptionProxy.listRecordingTranscriptions(
				accountSid, recordingSid, status, getDateString(dateTranscribedGte), getDateString(dateTranscribedLt), page, pageSize));
	}

	/**
	 * @see #transcribeRecording(String, String, HttpMethod, TranscriptionType)
	 * @throws ZangException
	 */
	public Transcription transcribeRecording(String accountSid,
			String recordingSid, String transcribeCallback,
			HttpMethod callbackMethod, TranscriptionType quality)
			throws ZangException {
		return returnThrows(transcriptionProxy.transcribeRecording(accountSid,
				recordingSid, transcribeCallback, callbackMethod, quality));
	}

	/**
	 * @see #transcribeAudioUrl(String, String, HttpMethod, TranscriptionType)
	 * @throws ZangException
	 */
	public Transcription transcribeAudioUrl(String accountSid, String audioUrl,
			String transcribeCallback, HttpMethod callbackMethod,
			TranscriptionType quality) throws ZangException {
		return returnThrows(transcriptionProxy.transcribeAudioUrl(accountSid,
				audioUrl, transcribeCallback, callbackMethod, quality));
	}

	/**
	 * Gets the details of a Transcription resource.
	 * 
	 * @param transcriptionSid
	 *            The sid of the requested Transcription (required).
	 * @return The requested Transcription.
	 * @throws ZangException
	 */
	public Transcription viewTranscription(String transcriptionSid)
			throws ZangException {
		return viewTranscription(conf.getSid(), transcriptionSid);
	}

	/**
	 * Gets just the transcription text of a Transcription.
	 * 
	 * @param transcriptionSid
	 *            The sid of the requested Transcription (required).
	 * @return The transcription text of the requested Transcription.
	 * @throws ZangException
	 */
	public String viewTranscriptionText(String transcriptionSid)
			throws ZangException {
		return viewTranscriptionText(conf.getSid(), transcriptionSid);
	}

	/**
	 * Lists transcriptions belonging to an account.
	 * 
	 * @param status
	 *            Used to only return transcriptions with a given status
	 *            (completed, in-progress or failed).
	 * @param dateTranscribedGte
	 *            Used to only return transcriptions that occurred at or after
	 *            the given date.
	 * @param dateTranscribedLt
	 *            Used to only return transcriptions that occurred at or before
	 *            the given date.
	 * @param page
	 *            Used to return a particular page within the list.
	 * @param pageSize
	 *            Used to specify the amount of list items to return per page.
	 * 
	 * @return A list of Transcriptions.
	 * @throws ZangException
	 */
	public TranscriptionList listTranscriptions(TranscriptionStatus status, Date dateTranscribedGte, Date dateTranscribedLt, Long page,
			Long pageSize) throws ZangException {
		return listTranscriptions(conf.getSid(), status, dateTranscribedGte, dateTranscribedLt, page, pageSize);
	}
	
	/**
	 * Lists all the transcriptions belonging to an account.
	 * 
	 * @return A list of all Transcriptions.
	 * @throws ZangException
	 */
	public TranscriptionList listTranscriptions() throws ZangException {
		return listTranscriptions(conf.getSid(), null, null, null, null, null);
	}

	/**
	 * Lists all the transcriptions belonging to an account.
	 * 
	 * @param recordingSid
	 *            The sid of the Recording for which transcriptions are
	 *            requested (required).
	 * @param status
	 *            Used to only return transcriptions with a given status
	 *            (completed, in-progress or failed).
	 * @param dateTranscribedGte
	 *            Used to only return transcriptions that occurred at or after
	 *            the given date.
	 * @param dateTranscribedLt
	 *            Used to only return transcriptions that occurred at or before
	 *            the given date.
	 * @param page
	 *            Used to return a particular page within the list.
	 * @param pageSize
	 *            Used to specify the amount of list items to return per page.
	 * @return A list of Transcriptions.
	 * @throws ZangException
	 */
	public TranscriptionList listRecordingTranscriptions(String recordingSid,
			TranscriptionStatus status, Date dateTranscribedGte, Date dateTranscribedLt, Long page,
			Long pageSize)
			throws ZangException {
		return listRecordingTranscriptions(conf.getSid(), recordingSid, status, dateTranscribedGte, dateTranscribedLt, page,
				pageSize);
	}

	/**
	 * Transcribes a recording.
	 * 
	 * @param recordingSid
	 *            The sid of the Recording to be transcribed (required).
	 * @param transcribeCallback
	 *            URL that will be requested when the transcription has finished
	 *            processing.
	 * @param callbackMethod
	 *            Specifies the HTTP method to use when requesting the
	 *            TranscribeCallback URL. Defaults to POST.
	 * @param quality
	 *            Specifies the transcription quality. Transcription price
	 *            differs for each quality tier. See the pricing page for
	 *            details.
	 * @return The newly created Transcription.
	 * @throws ZangException
	 */
	public Transcription transcribeRecording(String recordingSid,
			String transcribeCallback, HttpMethod callbackMethod,
			TranscriptionType quality) throws ZangException {
		return transcribeRecording(conf.getSid(), recordingSid,
				transcribeCallback, callbackMethod, quality);
	}

	/**
	 * Transcribes audio found on an URL.
	 * 
	 * @param audioUrl
	 *            URL where the audio to be transcribed is located (required).
	 * @param transcribeCallback
	 *            URL that will be requested when the transcription has finished
	 *            processing.
	 * @param callbackMethod
	 *            Specifies the HTTP method to use when requesting the
	 *            TranscribeCallback URL. Defaults to POST.
	 * @param quality
	 *            Specifies the transcription quality. Transcription price
	 *            differs for each quality tier. See the pricing page for
	 *            details.
	 * @return The newly created Transcription.
	 * @throws ZangException
	 */
	public Transcription transcribeAudioUrl(String audioUrl,
			String transcribeCallback, HttpMethod callbackMethod,
			TranscriptionType quality) throws ZangException {
		return transcribeAudioUrl(conf.getSid(), audioUrl, transcribeCallback,
				callbackMethod, quality);
	}

	// CARRIER SERVICES

	/**
	 * @see #carrierLookup(String)
	 * @throws ZangException
	 */
	public CarrierLookupList carrierLookup(String accountSid, String phoneNumber)
			throws ZangException {
		return returnThrows(carrierLookupProxy.carrierLookup(accountSid,
				phoneNumber));
	}
	
	/**
	 * @see #carrierLookup(List)
	 * @throws ZangException
	 */
	public CarrierLookupList carrierLookup(String accountSid, List<String> phoneNumber)
			throws ZangException {
		return returnThrows(carrierLookupProxy.carrierLookup(accountSid,
				phoneNumber));
	}

	/**
	 * @see #cnamLookup(String)
	 * @throws ZangException
	 */
	public CnamDipList cnamLookup(String accountSid, String phoneNumber)
			throws ZangException {
		return returnThrows(carrierLookupProxy.cnamLookup(accountSid,
				phoneNumber));
	}

	/**
	 * @see #cnamLookup(List)
	 * @throws ZangException
	 */
	public CnamDipList cnamLookup(String accountSid, List<String> phoneNumbers)
			throws ZangException {
		return returnThrows(carrierLookupProxy.cnamLookup(accountSid,
				phoneNumbers));
	}

	/**
	 * Provides a way to look up the carrier of a phone number.
	 * 
	 * @param phoneNumber
	 *            The number of the phone you are attempting to perform the
	 *            carrier look up on. Multiple PhoneNumbers to lookup can be
	 *            specified in a single request by seperating them with commas.
	 * @return The CarrierLookup information for the requested number.
	 * @throws ZangException
	 */
	public CarrierLookupList carrierLookup(String phoneNumber)
			throws ZangException {
		return carrierLookup(conf.getSid(), phoneNumber);
	}
	
	/**
	 * Provides a way to look up the carrier of phone numbers.
	 * 
	 * @param phoneNumber
	 *            The phone numbers you are attempting to perform the carrier look
	 *            up on.
	 * @return The CarrierLookup information for the requested numbers.
	 * @throws ZangException
	 */
	public CarrierLookupList carrierLookup(List<String> phoneNumber)
			throws ZangException {
		return carrierLookup(conf.getSid(), phoneNumber);
	}

	/**
	 * Performs a CNAM lookup for a phone number.
	 * 
	 * @param phoneNumber
	 *            The number of the phone you are attempting to perform the CNAM
	 *            look up on. Multiple PhoneNumbers to lookup can be specified
	 *            in a single request by seperating them with commas.
	 * @return CNAM lookup information.
	 * @throws ZangException
	 */
	public CnamDipList cnamLookup(String phoneNumber) throws ZangException {
		return cnamLookup(conf.getSid(), phoneNumber);
	}

	/**
	 * Performs a CNAM lookup for multiple phone numbers.
	 * 
	 * @param phoneNumbers
	 *            The phone numbers you are attempting to perform the CNAM look
	 *            up on.
	 * @return CNAM lookup information.
	 * @throws ZangException
	 */
	public CnamDipList cnamLookup(List<String> phoneNumbers)
			throws ZangException {
		return cnamLookup(conf.getSid(), phoneNumbers);
	}

	// FRAUD CONTROL

	/**
	 * @see #listFraudControlResources(Long, Long)
	 * @throws ZangException
	 */
	public FraudList listFraudControlResources(String accountSid, Long page,
			Long pageSize) throws ZangException {
		return returnThrows(fraudControlProxy.listFraudControlResources(
				accountSid, page, pageSize));
	}

	/**
	 * @see #authorizeDestination(String, Boolean, Boolean, Boolean)
	 * @throws ZangException
	 */
	public FraudList authorizeDestination(String accountSid,
			String countryCode, Boolean mobileEnabled, Boolean landlineEnabled,
			Boolean smsEnabled) throws ZangException {
		return returnThrows(fraudControlProxy.authorizeDestination(accountSid,
				countryCode, mobileEnabled, landlineEnabled, smsEnabled));
	}

	/**
	 * @see #blockDestination(String, Boolean, Boolean, Boolean)
	 * @throws ZangException
	 */
	public FraudList blockDestination(String accountSid, String countryCode,
			Boolean mobileEnabled, Boolean landlineEnabled, Boolean smsEnabled)
			throws ZangException {
		return returnThrows(fraudControlProxy.blockDestination(accountSid,
				countryCode, mobileEnabled, landlineEnabled, smsEnabled));
	}

	/**
	 * @see #extendDestinationAuth(String, Boolean, Boolean, Boolean)
	 * @throws ZangException
	 */
	public FraudList extendDestinationAuth(String accountSid,
			String countryCode, Boolean mobileEnabled, Boolean landlineEnabled,
			Boolean smsEnabled) throws ZangException {
		return returnThrows(fraudControlProxy.extendDestinationAuth(accountSid,
				countryCode, mobileEnabled, landlineEnabled, smsEnabled));
	}

	/**
	 * @see #whitelistDestination(String, Boolean, Boolean, Boolean)
	 * @throws ZangException
	 */
	public FraudList whitelistDestination(String accountSid,
			String countryCode, Boolean mobileEnabled, Boolean landlineEnabled,
			Boolean smsEnabled) throws ZangException {
		return returnThrows(fraudControlProxy.whitelistDestination(accountSid,
				countryCode, mobileEnabled, landlineEnabled, smsEnabled));
	}

	/**
	 * Gets a list of Fraud control resources for a certain account.
	 * 
	 * @param page
	 *            Used to return a particular page within the list.
	 * @param pageSize
	 *            Used to specify the amount of list items to return per page.
	 * @return A list of Fraud control resources.
	 * @throws ZangException
	 */
	public FraudList listFraudControlResources(Long page, Long pageSize)
			throws ZangException {
		return listFraudControlResources(conf.getSid(), page, pageSize);
	}
	
	/**
	 * Gets a list of Fraud control resources for a certain account.
	 * 
	 * @return A list of Fraud control resources.
	 * @throws ZangException
	 */
	public FraudList listFraudControlResources()
			throws ZangException {
		return listFraudControlResources(conf.getSid(), null, null);
	}

	/**
	 * Used to authorize previously blocked destinations for outbound calls and
	 * sms messages. Authorize is only meant to provide temporary permission:
	 * see the whitelist docs if you want to permanently enable a destinations.
	 * Unless extended, authorized destination will expire after 30 days. For
	 * examples of valid country codes to use in the request URL see <a
	 * href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">this article</a>.
	 * 
	 * @param countryCode
	 *            The country code which you want to authorize.
	 * @param mobileEnabled
	 *            Mobile status for the destination. If false, all mobile call
	 *            activity will be rejected or disabled. Defaults to true.
	 * @param landlineEnabled
	 *            Landline status for the destination. If false, all landline
	 *            call activity will be rejected or disabled. Defaults to true.
	 * @param smsEnabled
	 *            SMS status for the destination. If false, all SMS activity
	 *            will be rejected or disabled. Defaults to true.
	 * @return A list of Fraud control resources.
	 * @throws ZangException
	 */
	public FraudList authorizeDestination(String countryCode,
			Boolean mobileEnabled, Boolean landlineEnabled, Boolean smsEnabled)
			throws ZangException {
		return authorizeDestination(conf.getSid(), countryCode, mobileEnabled,
				landlineEnabled, smsEnabled);
	}

	/**
	 * Zang will restrict outbound calls and sms messages to blocked
	 * destinations. For examples of valid country codes to use in the request
	 * URL see <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">this
	 * article</a>.
	 * 
	 * @param countryCode
	 *            The country code which you want to authorize.
	 * @param mobileEnabled
	 *            Mobile status for the destination. If false, all mobile call
	 *            activity will be rejected or disabled. Defaults to true.
	 * @param landlineEnabled
	 *            Landline status for the destination. If false, all landline
	 *            call activity will be rejected or disabled. Defaults to true.
	 * @param smsEnabled
	 *            SMS status for the destination. If false, all SMS activity
	 *            will be rejected or disabled. Defaults to true.
	 * @return A list of Fraud control resources.
	 * @throws ZangException
	 */
	public FraudList blockDestination(String countryCode,
			Boolean mobileEnabled, Boolean landlineEnabled, Boolean smsEnabled)
			throws ZangException {
		return blockDestination(conf.getSid(), countryCode, mobileEnabled,
				landlineEnabled, smsEnabled);
	}

	/**
	 * By default, authorized destinations will expire and return to fully
	 * blocked status after 30 days. The extend method is provided to extend a
	 * destinations authorization expiration by 30 days. The extention is not
	 * additive, it will put the expiration date 30 days from the date the
	 * extension was made. For examples of valid country codes to use in the
	 * request URL see <a
	 * href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">this article</a>.
	 * 
	 * @param countryCode
	 *            The country code which you want to authorize.
	 * @param mobileEnabled
	 *            Mobile status for the destination. If false, all mobile call
	 *            activity will be rejected or disabled. Defaults to true.
	 * @param landlineEnabled
	 *            Landline status for the destination. If false, all landline
	 *            call activity will be rejected or disabled. Defaults to true.
	 * @param smsEnabled
	 *            SMS status for the destination. If false, all SMS activity
	 *            will be rejected or disabled. Defaults to true.
	 * @return A list of Fraud control resources.
	 * @throws ZangException
	 */
	public FraudList extendDestinationAuth(String countryCode,
			Boolean mobileEnabled, Boolean landlineEnabled, Boolean smsEnabled)
			throws ZangException {
		return extendDestinationAuth(conf.getSid(), countryCode, mobileEnabled,
				landlineEnabled, smsEnabled);
	}

	/**
	 * Whitelisting is provided for destinations you wish to permanently
	 * authorize.
	 * 
	 * @param countryCode
	 *            The country code which you want to authorize.
	 * @param mobileEnabled
	 *            Mobile status for the destination. If false, all mobile call
	 *            activity will be rejected or disabled. Defaults to true.
	 * @param landlineEnabled
	 *            Landline status for the destination. If false, all landline
	 *            call activity will be rejected or disabled. Defaults to true.
	 * @param smsEnabled
	 *            SMS status for the destination. If false, all SMS activity
	 *            will be rejected or disabled. Defaults to true.
	 * @return A list of Fraud control resources.
	 * @throws ZangException
	 */
	public FraudList whitelistDestination(String countryCode,
			Boolean mobileEnabled, Boolean landlineEnabled, Boolean smsEnabled)
			throws ZangException {
		return whitelistDestination(conf.getSid(), countryCode, mobileEnabled,
				landlineEnabled, smsEnabled);
	}

}
