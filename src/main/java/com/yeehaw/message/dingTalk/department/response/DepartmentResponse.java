package com.yeehaw.message.dingTalk.department.response;

import java.util.List;

import com.yeehaw.message.dingTalk.common.response.BaseResponse;

public class DepartmentResponse extends BaseResponse{
	
	private List<Department> department;

	public DepartmentResponse() {
	
	}

	public List<Department> getDepartment() {
		return department;
	}

	public void setDepartment(List<Department> department) {
		this.department = department;
	}

	public Department getDepartmentByName(String departmentName) {
		for(Department de:this.department) {
			if(departmentName.equals(de.getName())) {
				return de;
			}
		}
		return null;
	}
	public Department getDepartmentById(Long departmentId) {
		for(Department de:this.department) {
			if(de.getId() == departmentId) {
				return de;
			}
		}
		return null;
	}

	
	
}
