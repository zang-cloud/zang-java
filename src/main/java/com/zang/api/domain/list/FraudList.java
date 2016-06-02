package com.zang.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.zang.api.domain.Fraud;
import com.zang.api.domain.ZangList;

public class FraudList extends ZangList<Fraud>{

	@Override
	protected void mapElements(List<Fraud> elements) {
		setElements(elements);
	}

	@JsonProperty("frauds")
	private Fraud frauds;

	public Fraud getFrauds() {
		return frauds;
	}

	public void setFrauds(Fraud frauds) {
		this.frauds = frauds;
	}

}
