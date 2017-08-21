package com.yeehaw.message.dingTalk.common.ecode;

public enum RestMethod {
	RoleList("dingtalk.corp.role.list"),
	Asyncsend("dingtalk.corp.message.corpconversation.asyncsend"),
	;
	
	String method;

	RestMethod(String method) {
		this.method = method;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	
	
}
