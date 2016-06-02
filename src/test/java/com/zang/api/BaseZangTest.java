package com.zang.api;

import com.zang.api.configuration.PropertiesFileZangConfiguration;
import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.testutil.TestParameters;

public abstract class BaseZangTest {
	
	protected ZangConfiguration conf;
	protected TestParameters testParameters;
	protected ZangConnector connector;
	
	public BaseZangTest(){
		this.testParameters = new TestParameters();
		conf = new PropertiesFileZangConfiguration();
		connector = new ZangConnector(conf);
	}
	
}
