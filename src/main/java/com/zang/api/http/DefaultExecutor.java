package com.zang.api.http;

import com.zang.api.configuration.ZangConfiguration;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.*;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.jboss.resteasy.client.jaxrs.engines.ApacheHttpClient4Engine;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


public class DefaultExecutor {

    public static ApacheHttpClient4Engine createExecutor(ZangConfiguration conf) throws NoSuchAlgorithmException, KeyManagementException {
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
                new UsernamePasswordCredentials(conf.getSid(), conf.getAuthToken()));

        AuthCache authCache = new BasicAuthCache();
        AuthScheme basicAuth = new BasicScheme();
        authCache.put(new HttpHost("*"), basicAuth);
        HttpClientContext localContext = HttpClientContext.create();
        localContext.setCredentialsProvider(credentialsProvider);
        localContext.setAuthCache(authCache);
        ArrayList<Header> headers = new ArrayList<Header>();

        String credentials = conf.getSid() + ":" + conf.getAuthToken();
        byte[] bcreds = credentials.getBytes(Charset.forName("UTF8"));
        bcreds = Base64.encodeBase64(bcreds);
        String finalCreads = new String(bcreds, Charset.forName("UTF8"));
        headers.add(new BasicHeader("Authorization", "Basic " + finalCreads));
        HttpClient client = HttpClientBuilder.create().setDefaultHeaders(headers)
                //.addInterceptorLast(logResponseInterceptor)
                .build();
        ApacheHttpClient4Engine engine = new ApacheHttpClient4Engine(client);
        return engine;

    }

    private static HttpResponseInterceptor logResponseInterceptor = new HttpResponseInterceptor() {
        @Override
        public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
            httpResponse.setEntity(logResponse(httpResponse.getEntity()));
        }
    };

    private static HttpEntity logResponse(final HttpEntity entity)
    {
        Header h = entity.getContentType();
        ContentType contentType = h != null ? ContentType.parse(h.getValue()) : ContentType.DEFAULT_TEXT;
        String content = null;
        try {
            content = EntityUtils.toString(entity, contentType.getCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(content);
        return new StringEntity(content, contentType);
    }

    DefaultExecutor() {
    }

}
