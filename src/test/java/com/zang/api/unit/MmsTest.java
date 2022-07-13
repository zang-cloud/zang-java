package com.zang.api.unit;

import java.io.IOException;
import java.net.URI;

import org.junit.Test;

import com.zang.api.connectors.MmsConnector;
import com.zang.api.domain.MmsMessage;
import com.zang.api.exceptions.ZangException;

import junit.framework.Assert;

public class MmsTest extends BaseUnitTest {

	@Test
	public void sendMms() throws ZangException, IOException {
		createExpectation("MmsTest", "sendMms");

		MmsConnector connector = connectorFactory.getMmsConnector();
		MmsMessage mmsMessage = connector.sendMmsMessage("+123456", "+654321", "This is MMS sent from Zang", "callback.url",
				URI.create("https://media.giphy.com/media/zZJzLrxmx5ZFS/giphy.gif"));
		checkMessage(mmsMessage);

	}

	private void checkMessage(MmsMessage msg) {
		Assert.assertEquals("This is MMS sent from Zang", msg.getBody());
		Assert.assertEquals(URI.create("https://media.giphy.com/media/zZJzLrxmx5ZFS/giphy.gif"), msg.getMediaUrl());
	}

}
