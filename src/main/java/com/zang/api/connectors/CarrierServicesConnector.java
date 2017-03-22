package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.BnaLookup;
import com.zang.api.domain.CarrierLookup;
import com.zang.api.domain.CnamLookup;
import com.zang.api.domain.list.BnaLookupsList;
import com.zang.api.domain.list.CarrierLookupsList;
import com.zang.api.domain.list.CnamLookupsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.restproxies.CarrierServicesProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;


public class CarrierServicesConnector extends BaseConnector {

    private CarrierServicesProxy proxy;

    CarrierServicesConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(CarrierServicesProxy.class);
    }

    public CarrierLookup carrierLookup(String accountSid, String phoneNumber) throws ZangException {
        return returnThrows(proxy.carrierLookup(accountSid, phoneNumber), CarrierLookup.class);
    }

    public CarrierLookup carrierLookup(String phoneNumber) throws ZangException {
        return carrierLookup(conf.getSid(), phoneNumber);
    }

    public CarrierLookupsList listCarrierLookups(String accountSid, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listCarrierLookups(accountSid, page, pageSize), CarrierLookupsList.class);
    }

    public CarrierLookupsList listCarrierLookups(Integer page, Integer pageSize) throws ZangException {
        return listCarrierLookups(conf.getSid(), page, pageSize);
    }

    public CnamLookup cnamLookup(String accountSid, String phoneNumber) throws ZangException {
        return returnThrows(proxy.cnamLookup(accountSid, phoneNumber), CnamLookup.class);
    }

    public CnamLookup cnamLookup(String phoneNumber) throws ZangException {
        return cnamLookup(conf.getSid(), phoneNumber);
    }

    public CnamLookupsList listCnamLookups(String accountSid, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listCnamLookups(accountSid, page, pageSize), CnamLookupsList.class);
    }

    public CnamLookupsList listCnamLookups(Integer page, Integer pageSize) throws ZangException {
        return listCnamLookups(conf.getSid(), page, pageSize);
    }

    public BnaLookup bnaLookup(String accountSid, String phoneNumber) throws ZangException {
        return returnThrows(proxy.bnaLookup(accountSid, phoneNumber), BnaLookup.class);
    }

    public BnaLookup bnaLookup(String phoneNumber) throws ZangException {
        return bnaLookup(conf.getSid(), phoneNumber);
    }

    public BnaLookupsList listBnaLookups(String accountSid, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listBnaLookups(accountSid, page, pageSize), BnaLookupsList.class);
    }

    public BnaLookupsList listBnaLookups(Integer page, Integer pageSize) throws ZangException {
        return listBnaLookups(conf.getSid(), page, pageSize);
    }
}


