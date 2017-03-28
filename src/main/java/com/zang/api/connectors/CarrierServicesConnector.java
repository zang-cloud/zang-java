package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.list.BnaLookupsList;
import com.zang.api.domain.list.CarrierLookupsList;
import com.zang.api.domain.list.CnamLookupsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.restproxies.CarrierServicesProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;

import java.util.Arrays;
import java.util.List;


/**
 * Used for all forms of communication with the Carrier Services endpoint of the Zang REST API.
 * @see ZangConnectorFactory
 */
public class CarrierServicesConnector extends BaseConnector {

    private CarrierServicesProxy proxy;

    CarrierServicesConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(CarrierServicesProxy.class);
    }

    public CarrierLookupsList carrierLookup(String accountSid, List<String> phoneNumbers) throws ZangException {
        return returnThrows(proxy.carrierLookup(accountSid, phoneNumbers), CarrierLookupsList.class);
    }

    public CarrierLookupsList carrierLookup(String...phoneNumbers) throws ZangException {
        return carrierLookup(conf.getSid(), Arrays.asList(phoneNumbers));
    }

    public CarrierLookupsList listCarrierLookups(String accountSid, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listCarrierLookups(accountSid, page, pageSize), CarrierLookupsList.class);
    }

    public CarrierLookupsList listCarrierLookups(Integer page, Integer pageSize) throws ZangException {
        return listCarrierLookups(conf.getSid(), page, pageSize);
    }

    public CnamLookupsList cnamLookup(String accountSid, List<String> phoneNumbers) throws ZangException {
        return returnThrows(proxy.cnamLookup(accountSid, phoneNumbers), CnamLookupsList.class);
    }

    public CnamLookupsList cnamLookup(String... phoneNumbers) throws ZangException {
        return cnamLookup(conf.getSid(), Arrays.asList(phoneNumbers));
    }

    public CnamLookupsList listCnamLookups(String accountSid, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listCnamLookups(accountSid, page, pageSize), CnamLookupsList.class);
    }

    public CnamLookupsList listCnamLookups(Integer page, Integer pageSize) throws ZangException {
        return listCnamLookups(conf.getSid(), page, pageSize);
    }

    public BnaLookupsList bnaLookup(String accountSid, List<String> phoneNumbers) throws ZangException {
        return returnThrows(proxy.bnaLookup(accountSid, phoneNumbers), BnaLookupsList.class);
    }

    public BnaLookupsList bnaLookup(String... phoneNumbers) throws ZangException {
        return bnaLookup(conf.getSid(), Arrays.asList(phoneNumbers));
    }

    public BnaLookupsList listBnaLookups(String accountSid, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listBnaLookups(accountSid, page, pageSize), BnaLookupsList.class);
    }

    public BnaLookupsList listBnaLookups(Integer page, Integer pageSize) throws ZangException {
        return listBnaLookups(conf.getSid(), page, pageSize);
    }
}


