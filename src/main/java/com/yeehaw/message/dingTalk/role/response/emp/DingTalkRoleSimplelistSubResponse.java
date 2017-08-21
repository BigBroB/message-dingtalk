package com.yeehaw.message.dingTalk.role.response.emp;

public class DingTalkRoleSimplelistSubResponse {
	private UserResult result;

	private String request_id;

	public DingTalkRoleSimplelistSubResponse() {
		super();
	}

	public DingTalkRoleSimplelistSubResponse(UserResult result, String request_id) {
		super();
		this.result = result;
		this.request_id = request_id;
	}

	public void setResult(UserResult result) {
		this.result = result;
	}

	public UserResult getResult() {
		return this.result;
	}

	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}

	public String getRequest_id() {
		return this.request_id;
	}
}
