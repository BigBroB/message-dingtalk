package com.yeehaw.message.dingTalk.role.response.role;

import java.util.List;

public class RoleListResponse {
	
	private RoleListSubResponse dingtalk_corp_role_list_response;

	public RoleListResponse(RoleListSubResponse dingtalk_corp_role_list_response) {
		this.dingtalk_corp_role_list_response = dingtalk_corp_role_list_response;
	}

	public RoleListResponse() {
	
	}

	public RoleListSubResponse getDingtalk_corp_role_list_response() {
		return dingtalk_corp_role_list_response;
	}

	public void setDingtalk_corp_role_list_response(RoleListSubResponse dingtalk_corp_role_list_response) {
		this.dingtalk_corp_role_list_response = dingtalk_corp_role_list_response;
	}
	
	/** 
	 * @Title: getDingTalkRoleGroups 
	 * @Description: 获取所有角色列表分组 
	 * @param @return    
	 * @return List<DingTalkRoleGroup>
	 */
	public List<DingTalkRoleGroup> getDingTalkRoleGroups (){
		return this.dingtalk_corp_role_list_response.getResult().getList().getRole_groups();
	}
	
	/** 
	 * @Title: getGroupsRoleListByGroupName 
	 * @Description: 获取某个角色分组
	 * @param groupName
	 * @param @return    
	 * @return List<DingTalkRole>
	 */
	public List<DingTalkRole> getGroupsRoleListByGroupName(String groupName){
		
		List<DingTalkRoleGroup> groups = this.dingtalk_corp_role_list_response.getResult().getList().getRole_groups();
		for(DingTalkRoleGroup group:groups ) {
			if(groupName.equals(group.getGroup_name())) {
				return group.getRoles().getRoles();
			}
		}
		return null;
		
	}
	/** 
	 * @Title: getRoleByRoleName 
	 * @Description: 通过角色名称获取角色
	 * @param roleName
	 * @return DingTalkRole
	 */
	public DingTalkRole getRoleByRoleName(String roleName){
		
		List<DingTalkRoleGroup> groups = this.dingtalk_corp_role_list_response.getResult().getList().getRole_groups();
		for(DingTalkRoleGroup group:groups ) {
			for(DingTalkRole role:group.getRoles().getRoles()) {
				if(roleName.equals(role.getRole_name())) {
					return role;
				}
			}
		}
		return null;
	}
	
	/** 
	 * @Title: getRoleByRoleId 
	 * @Description: 通过角色ID获取角色
	 * @param roleId
	 * @return DingTalkRole
	 */
	public DingTalkRole getRoleByRoleId(Long roleId){
		
		List<DingTalkRoleGroup> groups = this.dingtalk_corp_role_list_response.getResult().getList().getRole_groups();
		for(DingTalkRoleGroup group:groups ) {
			for(DingTalkRole role:group.getRoles().getRoles()) {
				if(role.getId() == roleId) {
					return role;
				}
			}
		}
		return null;
	}
	
	
	
	
}	
