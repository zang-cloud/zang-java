package com.zang.api.connectors;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.configuration.ZangConstants;
import com.zang.api.exceptions.ZangException;
import com.zang.api.http.RestExecutor;
import org.jboss.resteasy.client.ClientExecutor;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Date;

/**
 * The class used for all forms of communication with the Zang REST API.
 */
class BaseConnector {

    private ClientExecutor executor;
    protected ZangConfiguration conf;
    private String fullBaseUrl;

    /**
     * Creates a new ZangConnector based on the provided configuration.
     *
     * @param conf     The configuration based on which the ZangConnector will be
     *                 created.
     * @param executor The executor used for REST calls, a default executor will be
     *                 created if left null.
     * @see BasicZangConfiguration , PropertiesFileZangConfiguration,
     * ZangConfiguration
     */

    BaseConnector(ZangConfiguration conf, ClientExecutor executor) {
        this.conf = conf;
        this.executor = executor;

        if (this.executor == null) {
            try {
                this.executor = RestExecutor.createExecutor(conf);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        URI baseUrl = UriBuilder.fromUri(conf.getBaseUrl())
                .path(ZangConstants.API_VERSION).build();
        this.fullBaseUrl = baseUrl.toString();
    }

    <T> T createProxy(Class<T> clazz) {
        return ProxyFactory.create(clazz, fullBaseUrl, executor);
    }

    <T> T returnThrows(ClientResponse<T> response)
            throws ZangException {
        int status = response.getStatus();
        if (status > 399) {
            throw response
                    .getEntity(ZangException.class);
        }
        return response.getEntity();
    }

    protected static String getDateString(Date date) {
        if (date == null)
            return null;
        return ZangConstants.queryDateFormat.format(date);
    }


}
