package com.zang.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.zang.api.domain.ZangList;
import com.zang.api.domain.Transcription;

public class TranscriptionList extends ZangList<Transcription>{

	@Override
	@JsonProperty("transcriptions")
	protected void mapElements(List<Transcription> elements) {
		setElements(elements);
	}

}
