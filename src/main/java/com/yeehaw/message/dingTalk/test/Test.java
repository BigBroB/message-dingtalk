package com.yeehaw.message.dingTalk.test;

import java.util.List;

import com.taobao.api.ApiException;
import com.yeehaw.message.common.exception.OtherAPIException;
import com.yeehaw.message.dingTalk.department.DingTalkDepartmentUtils;
import com.yeehaw.message.dingTalk.department.response.Department;

public class Test {
	public static void main(String[] args) throws OtherAPIException, ApiException {
//		 TextMessage text = new TextMessage();
//		 text.setContent("这是真的测试信息");
//		 TextMessageRequest request = new TextMessageRequest(text);
//		 request.setToparty("48425280");
		//DingTalkMessageUtils.sendCompanySynMessage(request);
		 List<Department> departments =
		 DingTalkDepartmentUtils.getDepartmentList("1");
		 
		 
		 
		 // for(Department department:departments) {
		// MarkdownMessage markdownMessage = new MarkdownMessage("这是markdown测试信息3", "###
		// 标题 \n **貌似是粗体a3**");
		// MarkdownMessageRequest request = new MarkdownMessageRequest(markdownMessage);
		// request.setToparty(department.getId().toString());
		// //DingTalkMessageUtils.sendCompanyAsyMessage(request);
		// DingTalkMessageUtils.sendCompanySynMessage(request);
		// }
		// BaseRoleRequest request = new BaseRoleRequest();
		//
		// //DingTalkRoleUtils.getRoleList(request);
		//
		// DingTalkRole role = new DingTalkRole();
		// role.setId(5L);
		// role.setRole_name("sdasd");
		// List<DingTalkRole> roless = new ArrayList<DingTalkRole>();
		// roless.add(role);
		// roless.add(role);
		// DingTalkRoles roles = new DingTalkRoles();
		// roles.setRoles(roless);
		// DingTalkBigRoles big = new DingTalkBigRoles(roles);
		// DingTalkRoleGroup group = new DingTalkRoleGroup("group", big);
		// List<DingTalkRoleGroup> gr = new ArrayList<DingTalkRoleGroup>();
		// gr.add(group);
		// gr.add(group);
		// DingTalkRoleGroups groups = new DingTalkRoleGroups(gr);
		// RoleListResult result = new RoleListResult("false",groups );
		//
		// RoleListSubResponse resSub = new RoleListSubResponse(result,"sadsad");
		//
		// RoleListResponse res = new RoleListResponse(resSub);
		// System.out.println(JsonUtils.to(res));
		//
		//
		//
		//
		// DingTalkClient client = new
		// DefaultDingTalkClient("https://eco.taobao.com/router/rest");
		// CorpRoleListRequest req = new CorpRoleListRequest();
		// req.setSize(20L);
		// req.setOffset(0L);
		// CorpRoleListResponse rsp = client.execute(req,
		// AccessTokenMaintain.getAccessToken());
		// TypeToken< RoleListResponse> type = new TypeToken<RoleListResponse>() {};
		// RoleListResponse response = JsonUtils.gsonDate.fromJson(rsp.getBody(),
		// type.getType());
		// System.out.println(JsonUtils.to(response));
		// RoleListResponse response = DingTalkRoleUtils.getRoleList();
		// System.out.println(JsonUtils.to(response));

//		DingTalkClient client = new DefaultDingTalkClient("https://eco.taobao.com/router/rest");
//		CorpRoleSimplelistRequest req = new CorpRoleSimplelistRequest();
//		req.setRoleId(233794327L);
//		req.setSize(20L);
//		req.setOffset(0L);
//		CorpRoleSimplelistResponse rsp = client.execute(req, AccessTokenMaintain.getAccessToken());
//		TypeToken<RoleSimplelistResponse> type = new TypeToken<RoleSimplelistResponse>() {
//		};
//		RoleSimplelistResponse response = JsonUtils.gsonDate.fromJson(rsp.getBody(), type.getType());
//		System.out.println(rsp.getBody());

//		RoleSimplelistResponse response = DingTalkRoleUtils.getUserListByRoleIdDefault(233794327L);
	
	}












}
