package com.zang.api;

import com.zang.api.configuration.PropertiesFileZangConfiguration;
import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.testutil.TestParameters;

public abstract class BaseZangTest {
	
	ZangConfiguration conf;
	TestParameters testParameters;
	ZangConnectorFactory connectorFactory;
	//TODO remove this
	protected ZangConnector connector;
	
	public BaseZangTest(){
		this.testParameters = new TestParameters();
		conf = new PropertiesFileZangConfiguration();
		connectorFactory = new ZangConnectorFactory(conf);

		//TODO remove this
		connector = new ZangConnector(conf);
	}
	
}
