package com.zang.api.examples;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.connectors.CallsConnector;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.domain.Call;
import com.zang.api.domain.enums.AudioDirection;
import com.zang.api.domain.enums.EndCallStatus;
import com.zang.api.domain.enums.IfMachine;
import com.zang.api.domain.enums.RecordingAudioDirection;
import com.zang.api.domain.list.CallsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.MakeCallParams;

public class CallsExample {

    public static void main(String[] args) {
        BasicZangConfiguration conf = new BasicZangConfiguration();
        conf.setSid("{AccountSid}");
        conf.setAuthToken("{AuthToken}");
        CallsConnector conn = ZangConnectorFactory.getCallsConnector(conf);

        try {
            Call newCall = conn.makeCall(MakeCallParams.builder()
                    .setTo("(XXX) XXX-XXXX")
                    .setFrom("(XXX) XXX-XXXX")
                    .setUrl("http://mydomain.com/inboundxml.xml")
                    .setIfMachine(IfMachine.HANGUP)
                    .build()
            );

            conn.recordLiveCall(newCall.getSid(), true, RecordingAudioDirection.BOTH, 60, null, null, null, null, null, null);
            conn.applyVoiceEffect(newCall.getSid(), AudioDirection.OUT, 5, null, null, null, null);
            conn.playAudioToLiveCall(newCall.getSid(), "http://mydomain.com/audio.mp3", RecordingAudioDirection.BOTH, false);
            conn.sendDigitsToLiveCall(newCall.getSid(), "112163", AudioDirection.OUT);
            conn.interruptLiveCall(newCall.getSid(), null, null, EndCallStatus.COMPLETED);

            conn.viewCall(newCall.getSid());

            CallsList callsList = conn.listCalls();
            for (Call call: callsList) {
                System.out.println(call.getSid());
            }
        } catch (ZangException e) {
            e.printStackTrace();
        }
    }
}
