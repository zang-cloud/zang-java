package com.zang.api;

import com.zang.api.unit.*;
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
        SipCredentialsTest.class,
        SipAclTest.class,
        IncomingPhoneNumbersTest.class,
        RecordingsTest.class,
        NotificationsTest.class,
        AvailablePhoneNumbersTest.class,
        TranscriptionsTest.class
})
public class UnitTestSuite {


}
