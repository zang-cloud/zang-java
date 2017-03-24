package com.zang.api;

import com.zang.api.it.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ItCalls.class,
        ItCarrierServices.class,
        ItNotifications.class,
        ItPhoneNumbers.class,
        ItRecordings.class,
        ItSip.class,
        ItTranscription.class,
        ItUsage.class
})
public class IntegrationTestSuite {


}
