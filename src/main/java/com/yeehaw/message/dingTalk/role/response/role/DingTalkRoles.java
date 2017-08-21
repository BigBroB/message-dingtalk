package com.yeehaw.message.dingTalk.role.response.role;

import java.util.List;

public class DingTalkRoles {
	
	
	private List<DingTalkRole> roles;
	
	
	public DingTalkRoles() {

	}
	
	public DingTalkRoles(List<DingTalkRole> roles) {
		this.roles = roles;
	}
	

	public List<DingTalkRole> getRoles() {
		return roles;
	}

	public void setRoles(List<DingTalkRole> roles) {
		this.roles = roles;
	}
	
	
}
