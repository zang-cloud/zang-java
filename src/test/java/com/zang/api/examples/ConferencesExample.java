package com.zang.api.examples;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.connectors.ConferencesConnector;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.domain.Conference;
import com.zang.api.domain.Participant;
import com.zang.api.domain.list.ConferencesList;
import com.zang.api.domain.list.ParticipantsList;
import com.zang.api.exceptions.ZangException;

public class ConferencesExample {

    public static void main(String[] args) {
        BasicZangConfiguration conf = new BasicZangConfiguration();
        conf.setSid("{AccountSid}");
        conf.setAuthToken("{AuthToken}");
        ConferencesConnector conn = ZangConnectorFactory.getConferencesConnector(conf);

        try {
            ConferencesList conferences = conn.listConferences();
            Conference firstConference = conferences.iterator().next();
            ParticipantsList participants = conn.listParticipants(firstConference.getSid());
            for(Participant participant : participants) {
                if (participant.getCallerNumber().equals("NUMBER_TO_MUTE")) {
                    conn.playAudioToParticipant(firstConference.getSid(), participant.getSid(), "http://mydomain.com/muted.mp3");
                    conn.deafOrMuteParticipant(firstConference.getSid(), participant.getSid(), true, false);
                }
                if (participant.getCallerNumber().equals("NUMBER_TO_HANGUP")) {
                    conn.hangupParticipant(firstConference.getSid(), participant.getSid());
                }
            }
            Conference conference = conn.viewConference(firstConference.getSid());

            if (conference.getActiveParticipantsCount() > 0) {
                System.out.println("There are still active participants in the conference.");
            }

        } catch (ZangException e) {
            e.printStackTrace();
        }
    }
}
