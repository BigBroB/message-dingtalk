package com.yeehaw.message.dingTalk.department.response;

import java.io.Serializable;

public class Department implements Serializable{
	
	private static final long serialVersionUID = -4750485453061555083L;
	
	private Long id;
	private String name;
	private boolean createDeptGroup;
	private boolean autoAddUser;
	
	public Department() {
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCreateDeptGroup() {
		return createDeptGroup;
	}

	public void setCreateDeptGroup(boolean createDeptGroup) {
		this.createDeptGroup = createDeptGroup;
	}

	public boolean isAutoAddUser() {
		return autoAddUser;
	}

	public void setAutoAddUser(boolean autoAddUser) {
		this.autoAddUser = autoAddUser;
	}
	
	
	
}
