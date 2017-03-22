package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.enums.AvailableNumberType;
import com.zang.api.domain.list.AvailablePhoneNumbersList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.ListAvailableNumbersParams;
import com.zang.api.restproxies.AvailablePhoneNumbersProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;


public class AvailablePhoneNumbersConnector extends BaseConnector {

    private AvailablePhoneNumbersProxy proxy;

    AvailablePhoneNumbersConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(AvailablePhoneNumbersProxy.class);
    }

    public AvailablePhoneNumbersList listAvailableNumbers(String accountSid, String country, AvailableNumberType type, String contains, String areaCode, String inRegion, String inPostalCode, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listAvailableNumbers(accountSid, country, type, contains, areaCode, inRegion, inPostalCode, page, pageSize), AvailablePhoneNumbersList.class);
    }

    public AvailablePhoneNumbersList listAvailableNumbers(String country, AvailableNumberType type, String contains, String areaCode, String inRegion, String inPostalCode, Integer page, Integer pageSize) throws ZangException {
        return listAvailableNumbers(conf.getSid(), country, type, contains, areaCode, inRegion, inPostalCode, page, pageSize);
    }

    public AvailablePhoneNumbersList listAvailableNumbers(ListAvailableNumbersParams params) throws ZangException {
        return listAvailableNumbers(params.getAccountSid() != null ? params.getAccountSid() : conf.getSid(), params.getCountry(), params.getType(), params.getContains(), params.getAreaCode(), params.getInRegion(), params.getInPostalCode(), params.getPage(), params.getPageSize());
    }

}


