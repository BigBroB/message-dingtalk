package com.yeehaw.message.dingTalk.role.response.role;

public class RoleListResult {
	
	private String has_more;
	private DingTalkRoleGroups list;
	public RoleListResult() {
	
	}
	public RoleListResult(String has_more, DingTalkRoleGroups list) {
		this.has_more = has_more;
		this.list = list;
	}
	public String getHas_more() {
		return has_more;
	}
	public void setHas_more(String has_more) {
		this.has_more = has_more;
	}
	public DingTalkRoleGroups getList() {
		return list;
	}
	public void setList(DingTalkRoleGroups list) {
		this.list = list;
	}
	
	
	
	
}
