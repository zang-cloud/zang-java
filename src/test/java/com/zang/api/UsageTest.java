package com.zang.api;

import com.zang.api.connectors.UsageConnector;
import com.zang.api.domain.Usage;
import com.zang.api.domain.enums.Product;
import com.zang.api.domain.list.UsagesList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.requests.UsagesRequest;
import org.junit.Test;

public class UsageTest extends BaseZangTest {

	@Test
	public void testListAndGetUsages() throws ZangException{
		UsageConnector connector = connectorFactory.getUsageConnector();
		UsagesRequest ur = new UsagesRequest();
		ur.setPage(0L);
		ur.setPageSize(25L);
		ur.setProduct(Product.OUTBOUND_SMS);
		UsagesList ul = connector.listUsages(ur);

		Usage firstUsage = null;
		for(Usage u : ul) {
			firstUsage = u;
			break;
		}
		if (firstUsage != null) {
			Usage usage = connector.viewUsage(firstUsage.getSid());
		}
	}
	
}
