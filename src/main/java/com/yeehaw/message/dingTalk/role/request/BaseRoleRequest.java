package com.yeehaw.message.dingTalk.role.request;

import com.yeehaw.message.dingTalk.common.ecode.RestMethod;
import com.yeehaw.message.dingTalk.common.request.BaseRequest;

public class BaseRoleRequest extends BaseRequest{

	public BaseRoleRequest() {
		super();
		setMethod(RestMethod.RoleList.getMethod());
		//setFormat("xml");
	}
	
	
	
	
}
