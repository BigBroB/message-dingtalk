package com.yeehaw.message.dingTalk.role.response.emp;

import java.util.List;

public class DingTalkUserList {
	
	private List<DingTalkUser> emp_simple_list;

	public DingTalkUserList() {
	
	}

	public DingTalkUserList(List<DingTalkUser> emp_simple_list) {
		this.emp_simple_list = emp_simple_list;
	}

	public List<DingTalkUser> getEmp_simple_list() {
		return emp_simple_list;
	}

	public void setEmp_simple_list(List<DingTalkUser> emp_simple_list) {
		this.emp_simple_list = emp_simple_list;
	}
	
	
}
