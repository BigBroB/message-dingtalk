package com.yeehaw.message.dingTalk.role.response.emp;

import java.util.List;

public class RoleSimplelistResponse {
	private DingTalkRoleSimplelistSubResponse dingtalk_corp_role_simplelist_response;

	public RoleSimplelistResponse() {
		super();
	}

	public RoleSimplelistResponse(DingTalkRoleSimplelistSubResponse dingtalk_corp_role_simplelist_response) {
		super();
		this.dingtalk_corp_role_simplelist_response = dingtalk_corp_role_simplelist_response;
	}

	public void setDingtalk_corp_role_simplelist_response(
			DingTalkRoleSimplelistSubResponse dingtalk_corp_role_simplelist_response) {
		this.dingtalk_corp_role_simplelist_response = dingtalk_corp_role_simplelist_response;
	}

	public DingTalkRoleSimplelistSubResponse getDingtalk_corp_role_simplelist_response() {
		return this.dingtalk_corp_role_simplelist_response;
	}
	
	public List<DingTalkUser> getUserList(){
		return this.dingtalk_corp_role_simplelist_response.getResult().getList().getEmp_simple_list();
	}
	
}
