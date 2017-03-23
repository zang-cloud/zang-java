package com.zang.api.unit;

import com.zang.api.connectors.FraudControlConnector;
import com.zang.api.domain.FraudControlRule;
import com.zang.api.domain.list.FraudControlRulesList;
import com.zang.api.exceptions.ZangException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.model.Parameter;

import java.io.IOException;


public class FraudControlTest extends BaseUnitTest {

    private FraudControlConnector connector;

    @Before
    public void initConnector() {
        connector = connectorFactory.getFraudControlConnector();
    }

    @Test
    public void listFraudControlResources() throws ZangException, IOException {
        createExpectation("GET", "Fraud.json", null, new Parameter[]{
                        new Parameter("Page", "0"),
                        new Parameter("PageSize", "22")
                },
                "/fraudcontrol/list.json");
        FraudControlRulesList result = connector.listFraudControlResources(0, 22);
        Assert.assertEquals(2, result.getAuthorized().size());
        Assert.assertEquals("FR", result.getAuthorized().get(1).getCountryCode());
    }

    @Test
    public void blockDestination() throws ZangException, IOException {
        createExpectation("POST", "Fraud/Block/HR.json", new Parameter[]{
                        new Parameter("MobileEnabled", "false"),
                        new Parameter("LandlineEnabled", "true"),
                        new Parameter("SmsEnabled", "false")
                }, null,
                "/fraudcontrol/blocked.json");
        FraudControlRule rule = connector.blockDestination("HR", false, true, false);
        checkRule(rule);
    }

    @Test
    public void authorizeDestination() throws ZangException, IOException {
        createExpectation("POST", "Fraud/Authorize/HR.json", new Parameter[]{
                        new Parameter("MobileEnabled", "false"),
                        new Parameter("LandlineEnabled", "true"),
                        new Parameter("SmsEnabled", "false")
                }, null,
                "/fraudcontrol/authorized.json");
        FraudControlRule rule = connector.authorizeDestination("HR", false, true, false);
        checkRule(rule);
    }

    @Test
    public void extendDestinationAuthorization() throws ZangException, IOException {
        createExpectation("POST", "Fraud/Extend/HR.json", null, null,
                "/fraudcontrol/authorized.json");
        FraudControlRule rule = connector.extendDestinationAuthorization("HR");
        checkRule(rule);
    }

    @Test
    public void whitelistDestination() throws ZangException, IOException {
        createExpectation("POST", "Fraud/Whitelist/HR.json", new Parameter[]{
                        new Parameter("MobileEnabled", "false"),
                        new Parameter("LandlineEnabled", "true"),
                        new Parameter("SmsEnabled", "false")
                }, null,
                "/fraudcontrol/whitelisted.json");
        FraudControlRule rule = connector.whitelistDestination("HR", false, true, false);
        checkRule(rule);
    }


    private void checkRule(FraudControlRule rule) {
        Assert.assertEquals("TestFraudControlRuleSid", rule.getSid());
    }

}
