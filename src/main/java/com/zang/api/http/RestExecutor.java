package com.zang.api.http;

public class RestExecutor {

//    public static ApacheHttpClient4Executor createExecutor(ZangConfiguration conf) throws NoSuchAlgorithmException, KeyManagementException {
//        Credentials credentials = new UsernamePasswordCredentials(conf.getSid(), conf.getAuthToken());
//        ApacheHttpClient4Executor executor = new ApacheHttpClient4Executor();
//        DefaultHttpClient httpClient = (DefaultHttpClient) executor.getHttpClient();
//
//        try {
//            TrustManager[] trustAllCerts = new TrustManager[]{
//                    new X509TrustManager() {
//                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//                            return null;
//                        }
//
//                        public void checkClientTrusted(
//                                java.security.cert.X509Certificate[] certs, String authType) {
//                        }
//
//                        public void checkServerTrusted(
//                                java.security.cert.X509Certificate[] certs, String authType) {
//                        }
//                    }
//            };
//
//            SSLContext sslContext;
//            sslContext = SSLContext.getInstance("SSL");
//            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
//            SSLSocketFactory sslSocketFactory = new SSLSocketFactory(sslContext, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
//            Scheme scheme = new Scheme("https", sslSocketFactory, 443);
//            httpClient.getConnectionManager().getSchemeRegistry().register(scheme);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        if (conf.getProxyHost() != null && !conf.getProxyHost().trim().isEmpty()) {
//            HttpHost proxy = new HttpHost(conf.getProxyHost(), Integer.parseInt(conf.getProxyPort()), conf.getProxyProtocol());
//            httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
//        }
//
//        httpClient.addRequestInterceptor(new PreemptiveAuthInterceptor(), 0);
//        httpClient.getCredentialsProvider().setCredentials(
//                new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
//                credentials
//        );
//
//
//        BasicHttpContext localContext = new BasicHttpContext();
//        BasicScheme basicAuth = new BasicScheme();
//        localContext.setAttribute("preemptive-auth", basicAuth);
//        executor.setHttpContext(localContext);
//        return executor;
//    }
//
//    private RestExecutor() {
//    }
//
//
//    static class PreemptiveAuthInterceptor implements HttpRequestInterceptor {
//        public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
//            AuthState authState = (AuthState) context.getAttribute(ClientContext.TARGET_AUTH_STATE);
//            if (authState.getAuthScheme() == null) {
//                AuthScheme authScheme = (AuthScheme) context.getAttribute("preemptive-auth");
//                CredentialsProvider credsProvider = (CredentialsProvider) context.getAttribute(ClientContext.CREDS_PROVIDER);
//                HttpHost targetHost = (HttpHost) context.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
//                if (authScheme != null) {
//                    Credentials creds = credsProvider.getCredentials(new AuthScope(targetHost.getHostName(), targetHost.getPort()));
//                    if (creds == null) {
//                        throw new HttpException("No credentials for preemptive authentication");
//                    }
//                    authState.setAuthScheme(authScheme);
//                    authState.setCredentials(creds);
//                }
//            }
//        }
//
//    }
}
