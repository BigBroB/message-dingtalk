package com.yeehaw.message.dingTalk.role.response.role;

public class DingTalkRole {
	
	private Long id;
	private String role_name;
	
	public DingTalkRole() {
	}

	public DingTalkRole(Long id, String role_name) {
		this.id = id;
		this.role_name = role_name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	
	
	
}
