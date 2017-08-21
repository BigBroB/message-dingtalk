package com.yeehaw.message.common.httpClient;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.yeehaw.message.common.exception.OtherAPIException;
import com.yeehaw.message.common.httpClient.header.HeaderEnum;
import com.yeehaw.message.common.httpClient.header.MyHeader;
import com.yeehaw.message.common.httpClient.sslFactory.ClientCustomSSL;
import com.yeehaw.message.common.util.CommonUtils;

public class HttpsClient {

	public static String doPost(String url, String params) throws OtherAPIException {

		try {
			// BasicCookieStore cookieStore = new BasicCookieStore();
			SSLContext sslContext = SSLContext.getInstance("TLS");
			// 初始化SSL上下文
			sslContext.init(null, new TrustManager[] { ClientCustomSSL.tm }, null);
			// SSL套接字连接工厂,NoopHostnameVerifier为信任所有服务器
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,
					NoopHostnameVerifier.INSTANCE);
			/**
			 * 通过setSSLSocketFactory(sslsf)保证httpclient实例能发送Https请求
			 */
			CloseableHttpClient client = HttpClients.custom().setSSLSocketFactory(sslsf).setMaxConnTotal(50)
					.setMaxConnPerRoute(50)
					.setDefaultRequestConfig(RequestConfig.custom().setConnectionRequestTimeout(60000)
							.setConnectTimeout(60000).setSocketTimeout(60000).build())
					.build();
			/**
			 * 请求参数配置 connectionRequestTimeout: 从连接池中获取连接的超时时间，超过该时间未拿到可用连接，
			 * 会抛出org.apache.http.conn.ConnectionPoolTimeoutException: Timeout waiting for
			 * connection from pool connectTimeout: 连接上服务器(握手成功)的时间，超出该时间抛出connect timeout
			 * socketTimeout: 服务器返回数据(response)的时间，超过该时间抛出read timeout
			 */

			HttpPost post = new HttpPost(url);

			StringEntity reqEntity = new StringEntity(params, ContentType.APPLICATION_JSON);
			post.setEntity(reqEntity);

			// post.addHeader(new MyHeader(HeaderEnum.JSON));
			CloseableHttpResponse response = client.execute(post);
			HttpEntity entity = response.getEntity();
			if (response.getStatusLine().getStatusCode() == 200) {
				if (CommonUtils.isNotEmpty(entity)) {
					String returnStr = EntityUtils.toString(entity, "utf-8");
					return returnStr;
				} else {
					// 释放资源
					EntityUtils.consume(entity);
					throw new OtherAPIException("访问失败");
				}
			} else {
				// 释放资源
				EntityUtils.consume(entity);
				throw new OtherAPIException("访问失败");
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new OtherAPIException("访问失败", e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new OtherAPIException("访问失败", e);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new OtherAPIException("访问失败", e);
		} catch (KeyManagementException e) {
			e.printStackTrace();
			throw new OtherAPIException("访问失败", e);
		} catch (OtherAPIException e) {
			e.printStackTrace();
			throw new OtherAPIException("访问失败", e);
		}

	}

	public static String doGet(String url, Map<String, String> params) throws OtherAPIException {
		try {
			if (CommonUtils.isEmpty(params)) {
				params = new HashMap<String, String>();
			}
			BasicCookieStore cookieStore = new BasicCookieStore();
			SSLContext sslContext = SSLContext.getInstance("TLS");
			// 初始化SSL上下文
			sslContext.init(null, new TrustManager[] { ClientCustomSSL.tm }, null);
			// SSL套接字连接工厂,NoopHostnameVerifier为信任所有服务器
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,
					NoopHostnameVerifier.INSTANCE);
			/**
			 * 通过setSSLSocketFactory(sslsf)保证httpclient实例能发送Https请求
			 */
			CloseableHttpClient client = HttpClients.custom().setSSLSocketFactory(sslsf).setMaxConnTotal(50)
					.setMaxConnPerRoute(50)
					.setDefaultRequestConfig(RequestConfig.custom().setConnectionRequestTimeout(60000)
							.setConnectTimeout(60000).setSocketTimeout(60000).build())
					.build();
			/**
			 * 请求参数配置 connectionRequestTimeout: 从连接池中获取连接的超时时间，超过该时间未拿到可用连接，
			 * 会抛出org.apache.http.conn.ConnectionPoolTimeoutException: Timeout waiting for
			 * connection from pool connectTimeout: 连接上服务器(握手成功)的时间，超出该时间抛出connect timeout
			 * socketTimeout: 服务器返回数据(response)的时间，超过该时间抛出read timeout
			 */

			List<NameValuePair> list = new ArrayList<NameValuePair>();
			Iterator<Entry<String, String>> iterator = params.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<String, String> elem = (Entry<String, String>) iterator.next();
				list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
			}
			NameValuePair[] param = new NameValuePair[list.size()];

			HttpUriRequest get = RequestBuilder.get(url).addHeader(new MyHeader(HeaderEnum.JSON))
					.addParameters(list.toArray(param)).build();

			CloseableHttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			if (response.getStatusLine().getStatusCode() == 200) {
				if (CommonUtils.isNotEmpty(entity)) {
					String returnStr = EntityUtils.toString(entity, "utf-8");
					return returnStr;
				} else {
					// 释放资源
					EntityUtils.consume(entity);
					throw new OtherAPIException("访问失败");
				}
			} else {
				// 释放资源
				EntityUtils.consume(entity);
				throw new OtherAPIException("访问失败");
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new OtherAPIException("访问失败", e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new OtherAPIException("访问失败", e);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new OtherAPIException("访问失败", e);
		} catch (KeyManagementException e) {
			e.printStackTrace();
			throw new OtherAPIException("访问失败", e);
		} catch (OtherAPIException e) {
			e.printStackTrace();
			throw new OtherAPIException("访问失败", e);
		}
	}

}
