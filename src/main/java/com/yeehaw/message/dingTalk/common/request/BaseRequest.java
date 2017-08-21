package com.yeehaw.message.dingTalk.common.request;

import java.util.Date;

import com.yeehaw.message.common.util.JsonUtils;

public class BaseRequest {
	private String method;
	private String session;
	private String timestamp = JsonUtils.to(new Date());
	private String format = "json";
	private String v= "2.0";
	private boolean simplify = true;
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}
	public boolean isSimplify() {
		return simplify;
	}
	public void setSimplify(boolean simplify) {
		this.simplify = simplify;
	}
	
	
}
