package com.yeehaw.message.common.httpClient.sslFactory;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

public class ClientCustomSSL {
	private static String reqStr = "txnType=00&signMethod=01&certId=68759663125&encoding=UTF-8&merId=777290058110048&bizType=000201&txnSubType=00&signature=k0lrWgeLK%2Fx%2B8ajj15QCYfmdQxZSKBjXUJN0bLt17rp87ptogxWgHAAq7EUt8RlEbxD6GaRngwtdLGiy6are45Gj1dBLJBtW2841WIq4Ywzx3oK6538Kfh9ll91GJcZJGYz8LuJoZfii7HFPlpl1ZsPZbbdKP6WFVHNMnGnL9nk9QSa%2BihXGpyK%2Fy1FA42AJpfc%2FTT3BV6C%2FxpoEhXzVckHnniVnCpLdGnPfZOd76wK%2Fa%2BALNmniwUZmMj9uNPwnONIIwL%2FFqrqQinQArolW%2FrcIt9NL7qKvQujM%2BdRvd1fboAHI5bZC3ktVPB0s5QFfsRhSRFghVi4RHOzL8ZG%2FVQ%3D%3D&orderId=20160309145206&version=5.0.0&txnTime=20160309145206&accessType=0";
    private static String url = "https://101.231.204.80:5000/gateway/api/queryTrans.do";

    public static X509TrustManager tm = new X509TrustManager() {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    };

}
