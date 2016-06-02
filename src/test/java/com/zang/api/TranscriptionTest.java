package com.zang.api;

import java.util.Date;

import org.junit.Test;

import com.zang.api.domain.Recording;
import com.zang.api.domain.Transcription;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.enums.TranscriptionStatus;
import com.zang.api.domain.enums.TranscriptionType;
import com.zang.api.domain.list.TranscriptionList;
import com.zang.api.exceptions.ZangException;

public class TranscriptionTest extends BaseZangTest {

	@Test
	public void testTranscribeAudio() throws ZangException {
		Transcription tr = connector.transcribeAudioUrl(testParameters.getMp3Url(), "callbackurl.com", HttpMethod.GET, TranscriptionType.AUTO);
		String tt = connector.viewTranscriptionText(tr.getSid());
		System.out.println(tt);
	}
	
	@Test
	public void testListTranscriptions() throws ZangException {
		TranscriptionList list = connector.listTranscriptions(TranscriptionStatus.COMPLETED, new Date(0L), new Date(), 0L, 10L);
		for (Transcription t : list) {
			System.out.println(t.getSid());
		}
	}
	
	@Test
	public void testViewTranscription() throws ZangException {
		TranscriptionList list = connector.listTranscriptions();
		Transcription t = list.iterator().next();
		connector.viewTranscription(t.getSid());
	}
	
	@Test
	public void testViewTranscriptionText() throws ZangException {
		TranscriptionList list = connector.listTranscriptions();
		Transcription t = list.iterator().next();
		String transcription = connector.viewTranscriptionText(t.getSid());
		System.out.println(transcription);
	}
	
	@Test
	public void testTranscribeRecording() throws ZangException {
		Recording r = connector.listRecordings(null, null, null, null).iterator().next();
		connector.transcribeRecording(r.getSid(), "transcribecallback.com", HttpMethod.GET, TranscriptionType.AUTO);
	}
	
}
