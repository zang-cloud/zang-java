package com.zang.api;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccountsTest.class,
        ApplicationClientsTest.class,
        ApplicationsTest.class,
        CallsTest.class,
        ConferencesTest.class,
        InboundXmlTest.class,
        SipDomainsTest.class,
        SmsTest.class,
        UsagesTest.class,
        SipCredentialsTest.class
})
public class UnitTestSuite {


}
