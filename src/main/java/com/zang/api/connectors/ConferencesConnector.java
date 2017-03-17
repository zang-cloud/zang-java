package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.Conference;
import com.zang.api.domain.Participant;
import com.zang.api.domain.enums.ConferenceStatus;
import com.zang.api.domain.list.ConferencesList;
import com.zang.api.domain.list.ParticipantsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.restproxies.ConferencesProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;

import java.util.Date;


public class ConferencesConnector extends BaseConnector {

    private ConferencesProxy conferencesProxy;

    ConferencesConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        conferencesProxy = createProxy(ConferencesProxy.class);
    }


    public Conference viewConference(String accountSid, String conferenceSid)
            throws ZangException {
        return returnThrows(conferencesProxy.viewConference(accountSid,
                conferenceSid), Conference.class);
    }

    public Conference viewConference(String conferenceSid)
            throws ZangException {
        return viewConference(conf.getSid(), conferenceSid);
    }


    public ConferencesList listConferences(String accountSid,
                                           String friendlyName, ConferenceStatus status, Date dateCreatedGte,
                                           Date dateCreatedLt, Date dateUpdatedGte, Date dateUpdatedLt,
                                           Integer page, Integer pageSize) throws ZangException {
        return returnThrows(conferencesProxy.listConferences(accountSid,
                friendlyName, status, getDateString(dateCreatedGte),
                getDateString(dateCreatedLt), getDateString(dateUpdatedGte),
                getDateString(dateUpdatedLt), page, pageSize), ConferencesList.class);
    }

    public ConferencesList listConferences(String friendlyName, ConferenceStatus status, Date dateCreatedGte,
                                           Date dateCreatedLt, Date dateUpdatedGte, Date dateUpdatedLt,
                                           Integer page, Integer pageSize) throws ZangException {
        return listConferences(conf.getSid(), friendlyName, status,
                dateCreatedGte, dateCreatedLt, dateUpdatedGte, dateUpdatedLt,
                page, pageSize);
    }


    public ConferencesList listConferences() throws ZangException {
        return listConferences(null, null, null, null, null, null, null, null);
    }


    public Participant viewParticipant(String accountSid, String conferenceSid,
                                       String participantSid) throws ZangException {
        return returnThrows(conferencesProxy.viewParticipant(accountSid,
                conferenceSid, participantSid), Participant.class);
    }


    public Participant viewParticipant(String conferenceSid, String participantSid)
            throws ZangException {
        return returnThrows(conferencesProxy.viewParticipant(conf.getSid(),
                conferenceSid, participantSid), Participant.class);
    }


    public ParticipantsList listParticipants(String accountSid,
                                             String conferenceSid, Boolean muted, Boolean deaf, Integer page,
                                             Integer pageSize) throws ZangException {
        return returnThrows(conferencesProxy.listParticipants(accountSid,
                conferenceSid, muted, deaf, page, pageSize), ParticipantsList.class);
    }


    public ParticipantsList listParticipants(
            String conferenceSid, Boolean muted, Boolean deaf, Integer page,
            Integer pageSize) throws ZangException {
        return listParticipants(conf.getSid(), conferenceSid, muted, deaf, page, pageSize);
    }


    public ParticipantsList listParticipants(String conferenceSid) throws ZangException {
        return listParticipants(conferenceSid, null, null, null, null);
    }


    public Participant deafOrMuteParticipant(String accountSid, String conferenceSid, String participantSid, Boolean muted, Boolean deaf) throws ZangException {
        return returnThrows(conferencesProxy.muteDeafParticipant(accountSid, conferenceSid, participantSid, muted, deaf), Participant.class);
    }


    public Participant deafOrMuteParticipant(String conferenceSid, String participantSid, Boolean muted, Boolean deaf) throws ZangException {
        return returnThrows(conferencesProxy.muteDeafParticipant(conf.getSid(), conferenceSid, participantSid, muted, deaf), Participant.class);
    }


    public Participant hangupParticipant(String accountSid, String conferenceSid,
                                         String participantSid) throws ZangException {
        return returnThrows(conferencesProxy.hangupParticipant(accountSid, conferenceSid, participantSid), Participant.class);
    }


    public Participant hangupParticipant(String conferenceSid, String participantSid)
            throws ZangException {
        return returnThrows(conferencesProxy.hangupParticipant(conf.getSid(),
                conferenceSid, participantSid), Participant.class);
    }


    public Participant playAudioToParticipant(String accountSid,
                                              String conferenceSid, String participantSid, String url)
            throws ZangException {
        return returnThrows(conferencesProxy.playAudioToParticipant(accountSid,
                conferenceSid, participantSid, url), Participant.class);
    }

    public Participant playAudioToParticipant(String conferenceSid,
                                              String participantSid, String audioUrl) throws ZangException {
        return playAudioToParticipant(conf.getSid(), conferenceSid, participantSid,
                audioUrl);
    }

}
