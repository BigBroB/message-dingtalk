package com.yeehaw.message.dingTalk.role.response.role;

public class RoleListSubResponse {
	
	private RoleListResult result;
	private String request_id;
	public RoleListSubResponse() {
	
	}
	public RoleListSubResponse(RoleListResult result, String request_id) {
		super();
		this.result = result;
		this.request_id = request_id;
	}
	public RoleListResult getResult() {
		return result;
	}
	public void setResult(RoleListResult result) {
		this.result = result;
	}
	public String getRequest_id() {
		return request_id;
	}
	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}
	
	
	
	
}
