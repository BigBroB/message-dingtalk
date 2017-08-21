package com.yeehaw.message.dingTalk.role.response.role;

public class DingTalkRoleGroup {

	private String group_name;
	private DingTalkRoles roles;

	public String getGroup_name() {
		return group_name;
	}

	public DingTalkRoleGroup() {

	}

	public DingTalkRoleGroup(String group_name, DingTalkRoles roles) {
		this.group_name = group_name;
		this.roles = roles;
	}

	public DingTalkRoles getRoles() {
		return roles;
	}

	public void setRoles(DingTalkRoles roles) {
		this.roles = roles;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

}
