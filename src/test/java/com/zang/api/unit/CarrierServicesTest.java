package com.zang.api.unit;

import com.zang.api.connectors.CarrierServicesConnector;
import com.zang.api.domain.BnaLookup;
import com.zang.api.domain.CarrierLookup;
import com.zang.api.domain.CnamLookup;
import com.zang.api.exceptions.ZangException;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.model.Parameter;

import java.io.IOException;


public class CarrierServicesTest extends BaseUnitTest {

    private CarrierServicesConnector connector;

    @Before
    public void initConnector() {
        connector = connectorFactory.getCarrierServicesConnector();
    }

    @Test
    public void carrierLookup() throws ZangException, IOException {
        createExpectation("POST", "Lookups/Carrier.json", new Parameter[]{
                        new Parameter("PhoneNumber", "+1234")
                }, null,
                "/carrierservices/carrierlookupslist.json");
        checkCarrierLookup(connector.carrierLookup("+1234").iterator().next());
    }

    @Test
    public void listCarrierLookups() throws ZangException, IOException {
        createExpectation("GET", "Lookups/Carrier.json", null, new Parameter[]{
                        new Parameter("Page", "0"),
                        new Parameter("PageSize", "33"),
                },
                "/carrierservices/carrierlookupslist.json");
        checkCarrierLookup(connector.listCarrierLookups(0, 33).iterator().next());
    }

    @Test
    public void cnamLookup() throws ZangException, IOException {
        createExpectation("POST", "Lookups/Cnam.json", new Parameter[]{
                        new Parameter("PhoneNumber", "+1234")
                }, null,
                "/carrierservices/cnamlookupslist.json");
        checkCnamLookup(connector.cnamLookup("+1234").iterator().next());
    }

    @Test
    public void listCnamLookups() throws ZangException, IOException {
        createExpectation("GET", "Lookups/Cnam.json", null, new Parameter[]{
                        new Parameter("Page", "0"),
                        new Parameter("PageSize", "33"),
                },
                "/carrierservices/cnamlookupslist.json");
        checkCnamLookup(connector.listCnamLookups(0, 33).iterator().next());
    }

    @Test
    public void bnaLookup() throws ZangException, IOException {
        createExpectation("POST", "Lookups/Bna.json", new Parameter[]{
                        new Parameter("PhoneNumber", "+1234")
                }, null,
                "/carrierservices/bnalookupslist.json");
        checkBnaLookup(connector.bnaLookup("+1234").iterator().next());
    }

    @Test
    public void listBnaLookups() throws ZangException, IOException {
        createExpectation("GET", "Lookups/Bna.json", null, new Parameter[]{
                        new Parameter("Page", "0"),
                        new Parameter("PageSize", "33"),
                },
                "/carrierservices/bnalookupslist.json");
        checkBnaLookup(connector.listBnaLookups(0, 33).iterator().next());
    }


    private void checkCarrierLookup(CarrierLookup carrierLookup) {

    }

    private void checkCnamLookup(CnamLookup cnamLookup) {

    }

    private void checkBnaLookup(BnaLookup bnaLookup) {

    }

}
