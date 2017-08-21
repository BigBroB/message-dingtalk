package com.yeehaw.message.dingTalk.role.response.role;

import java.util.List;

public class DingTalkRoleGroups {
	
	private List<DingTalkRoleGroup> role_groups;

	public DingTalkRoleGroups(List<DingTalkRoleGroup> role_groups) {
		this.role_groups = role_groups;
	}

	public DingTalkRoleGroups() {
	}

	public List<DingTalkRoleGroup> getRole_groups() {
		return role_groups;
	}

	public void setRole_groups(List<DingTalkRoleGroup> role_groups) {
		this.role_groups = role_groups;
	}
	
	
	
	
}
