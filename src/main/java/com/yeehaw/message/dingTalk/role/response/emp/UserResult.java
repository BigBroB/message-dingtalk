package com.yeehaw.message.dingTalk.role.response.emp;

public class UserResult {

	private String has_more;
	private DingTalkUserList list;
	
	public UserResult() {
	
	}

	public UserResult(String has_more, DingTalkUserList list) {
		this.has_more = has_more;
		this.list = list;
	}

	public String getHas_more() {
		return has_more;
	}

	public void setHas_more(String has_more) {
		this.has_more = has_more;
	}

	public DingTalkUserList getList() {
		return list;
	}

	public void setList(DingTalkUserList list) {
		this.list = list;
	}


	
}
