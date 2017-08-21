package com.yeehaw.message.dingTalk.department;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.reflect.TypeToken;
import com.yeehaw.message.common.exception.OtherAPIException;
import com.yeehaw.message.common.httpClient.HttpsClient;
import com.yeehaw.message.common.util.CommonUtils;
import com.yeehaw.message.common.util.JsonUtils;
import com.yeehaw.message.dingTalk.common.AccessTokenMaintain;
import com.yeehaw.message.dingTalk.common.ecode.DingtalkAPIUrl;
import com.yeehaw.message.dingTalk.department.response.Department;
import com.yeehaw.message.dingTalk.department.response.DepartmentResponse;

public class DingTalkDepartmentUtils {
	
	private static Logger logger = LoggerFactory.getLogger(DingTalkDepartmentUtils.class);

	public static List<Department> getDepartmentList(String departmentId) throws OtherAPIException {
		TypeToken<DepartmentResponse> token = new TypeToken<DepartmentResponse>() {};
		String uri = DingtalkAPIUrl.GetDepartment.getUrl();
		String url = uri+"?access_token="+AccessTokenMaintain.getAccessToken();
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", departmentId);
		String response = HttpsClient.doGet(url, map);
		DepartmentResponse departmentResponse = JsonUtils.gson.fromJson(response, token.getType());
		if(CommonUtils.isEmpty(departmentResponse.getDepartment())) {
			logger.error("\r\n========获取部门列表失败");
			logger.error("\r\n========返回参数："+response);
			throw new OtherAPIException("获取部门列表失败");
		}
		logger.info("\r\n========返回参数："+response);
		logger.info("\r\n=====部门列表信息："+JsonUtils.to(departmentResponse.getDepartment()));
		return departmentResponse.getDepartment();
	}
	
	
}
