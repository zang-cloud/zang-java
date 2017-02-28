package com.zang.api.configuration;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * A ZangConfiguration implementation which loads the configuration from a file.
 *
 * @see ZangConfiguration
 */
public class PropertiesFileZangConfiguration extends Properties implements ZangConfiguration {
    private static final long serialVersionUID = -7348144965758395514L;
    Logger logger = Logger.getLogger(PropertiesFileZangConfiguration.class);

    /**
     * Creates a ZangConfiguration from a file called "zang.properties" which must be on the classpath.
     */
    public PropertiesFileZangConfiguration() {
        this("zang.properties");
    }

    /**
     * Creates a ZangConfiguration from a file which must be on the classpath.
     *
     * @param propFileName The fileName of the properties file.
     */
    public PropertiesFileZangConfiguration(String propFileName) {
        URL url = ClassLoader.getSystemResource(propFileName);
        try {
            load(url.openStream());
        } catch (IOException e) {
            logger.error("Cannot load or find Zang properties file on classpath: "
                    + propFileName, e);
        }
    }

    /**
     * Creates a ZangConfiguration by loading properties from the provided FileInputStream.
     *
     * @param is The FileInputStream from which to load the configuration.
     */
    public PropertiesFileZangConfiguration(FileInputStream is) {
        try {
            load(is);
        } catch (IOException e) {
            logger.error("Cannot load the specified Zang properties file.");
        }
    }

    @Override
    public String getSid() {
        return getProperty("sid");
    }

    @Override
    public String getAuthToken() {
        return getProperty("authToken");
    }

    @Override
    public String getBaseUrl() {
        return getProperty("baseUrl", ZangConstants.BASE_URL);
    }

    @Override
    public String getProxyHost() {
        return getProperty("proxyHost", null);
    }

    @Override
    public String getProxyPort() {
        return getProperty("proxyPort", null);
    }

    @Override
    public String getProxyProtocol() {
        return getProperty("proxyProtocol", null);
    }


}
