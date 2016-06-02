package com.zang.api;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.zang.api.domain.Conference;
import com.zang.api.domain.Participant;
import com.zang.api.domain.list.ConferenceList;
import com.zang.api.exceptions.ZangException;

public class ConferenceTest extends BaseZangTest {
	

	@Test
	public void testViewConference() throws ZangException {
		ConferenceList conferences = connector.listConferences();
		Conference c = conferences.iterator().next();
		connector.viewConference(c.getSid());
	}

	@Test
	public void testListConferences() throws ZangException {
		connector.listConferences("fname", "in-progress", new Date(0L), new Date(), new Date(0L), new Date(), 0L, 10L);
	}
	
	@Test
	public void testListParticipants() throws ZangException {
		ConferenceList conferences = connector.listConferences(null, null, null, null, null, null, 0L, 2L);
		Conference c = conferences.iterator().next();
		connector.listParticipants(c.getSid(), false, false, 0L, 10L);
	}
	
	@Test
	public void testViewParticipant() throws ZangException {
		ConferenceList conferences = connector.listConferences(null, null, null, null, null, null, 0L, 2L);
		Conference c = conferences.iterator().next();
		List<Participant> participants = connector.listParticipants(c.getSid());
		Participant p = participants.iterator().next();
		connector.viewParticipant(c.getSid(), p.getCallSid());
	}
	
	@Test
	public void testMuteDeafParticipant() throws ZangException {
		ConferenceList conferences = connector.listConferences(null, null, null, null, null, null, 0L, 2L);
		Conference c = conferences.iterator().next();
		List<Participant> participants = connector.listParticipants(c.getSid());
		Participant p = participants.iterator().next();
		connector.deafOrMuteParticipant(c.getSid(), p.getCallSid(), true, false);
	}

	@Test
	public void testPlayAudio() throws ZangException {
		Conference c = connector.listConferences(null, null, null, null, null, null, 0L, 2L).iterator().next();
		Participant participant = connector.listParticipants(c.getSid()).iterator().next();
		connector.playAudioToParticipant(c.getSid(), participant.getCallSid(), testParameters.getMp3Url());
	}
	
	
	@Test
	public void testHangupMember() throws ZangException {
		Conference c = connector.listConferences(null, null, null, null, null, null, 0L, 2L).iterator().next();
		Participant participant = connector.listParticipants(c.getSid()).iterator().next();
		connector.hangupParticipant(c.getSid(), participant.getCallSid());
	}
}
