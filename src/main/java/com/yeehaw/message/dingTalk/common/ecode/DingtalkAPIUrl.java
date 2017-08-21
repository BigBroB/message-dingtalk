package com.yeehaw.message.dingTalk.common.ecode;

public enum DingtalkAPIUrl {
	AccessToken("https://oapi.dingtalk.com/gettoken","get","获取token"),
	SsoToken("https://oapi.dingtalk.com/sso/gettoken","get","获取ssoToken"),
	CreateGroupChat("https://oapi.dingtalk.com/chat/create","post","创建群会话"),
	UpdateGroupChat("https://oapi.dingtalk.com/chat/update","post","修改群会话"),
	GetGroupChat("https://oapi.dingtalk.com/chat/get","post","获取会话"),
	SendGroupChat("https://oapi.dingtalk.com/chat/send","post","发送消息到群会话"),
	GetUserid("https://oapi.dingtalk.com/user/getUseridByUnionid","get","根据 unionid 获取成员的 userid"),
	GetDepartment("https://oapi.dingtalk.com/department/list","get","获取部门列表"),
	SendCompanyMessage("https://oapi.dingtalk.com/message/send","post","发送企业消息"),
	RestAPI("https://eco.taobao.com/router/rest","post","异步发送消息"),
	MessageStatus("https://oapi.dingtalk.com/message/list_message_status","post","获取企业会话消息已读未读状态"),
	;
	String url;
	String way;
	String detail;
	private DingtalkAPIUrl(String url, String way, String detail) {
		this.url = url;
		this.way = way;
		this.detail = detail;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getWay() {
		return way;
	}
	public void setWay(String way) {
		this.way = way;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
}
