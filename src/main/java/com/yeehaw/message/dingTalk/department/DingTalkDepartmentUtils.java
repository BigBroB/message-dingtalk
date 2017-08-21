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
import com.yeehaw.message.dingTalk.common.response.BaseResponse;
import com.yeehaw.message.dingTalk.department.response.CreateResponse;
import com.yeehaw.message.dingTalk.department.response.Department;
import com.yeehaw.message.dingTalk.department.response.DepartmentDetail;
import com.yeehaw.message.dingTalk.department.response.DepartmentDetailResponse;
import com.yeehaw.message.dingTalk.department.response.DepartmentResponse;

public class DingTalkDepartmentUtils {
	
	private static Logger logger = LoggerFactory.getLogger(DingTalkDepartmentUtils.class);


	/** 
	 * @Title: getDepartmentList 
	 * @Description: 获取部门列表 
	 * @param departmentId
	 * @throws OtherAPIException    
	 * @return List<Department>
	 */
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
	
	/** 
	 * @Title: getDepartmentDetail 
	 * @Description: 获取部门详情 
	 * @param departmentId
	 * @throws OtherAPIException    
	 * @return DepartmentDetailResponse
	 */
	public static DepartmentDetailResponse getDepartmentDetail(String departmentId) throws OtherAPIException {
		TypeToken<DepartmentDetailResponse> token = new TypeToken<DepartmentDetailResponse>() {};
		String uri = DingtalkAPIUrl.GetDepartmentDetail.getUrl();
		String url = uri+"?access_token="+AccessTokenMaintain.getAccessToken();
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", departmentId);
		String response = HttpsClient.doGet(url, map);
		DepartmentDetailResponse departmentDetailResponse = JsonUtils.gson.fromJson(response, token.getType());
		if(CommonUtils.isEmpty(departmentDetailResponse)) {
			logger.error("\r\n========获取部门失败");
			logger.error("\r\n========返回参数："+response);
			throw new OtherAPIException("获取部门失败");
		}
		logger.info("\r\n========返回参数："+response);
		logger.info("\r\n=====部门信息："+JsonUtils.to(departmentDetailResponse));
		return departmentDetailResponse;
	}
	
	public static void createDepartment(DepartmentDetail detail) throws OtherAPIException {
		TypeToken<CreateResponse> token = new TypeToken<CreateResponse>() {};
		String uri = DingtalkAPIUrl.CreateDepartment.getUrl();
		String url = uri+"?access_token="+AccessTokenMaintain.getAccessToken();
		
		String response = HttpsClient.doPost(url, JsonUtils.to(detail));
		CreateResponse createResponse = JsonUtils.gson.fromJson(response, token.getType());
		if(CommonUtils.isEmpty(createResponse.getId())) {
			logger.error("\r\n========创建部门失败");
			logger.error("\r\n========返回参数："+response);
			throw new OtherAPIException("创建部门失败");
		}
		logger.info("\r\n========返回参数："+response);
	}
	public static void updateDepartment(DepartmentDetail detail) throws OtherAPIException {
		TypeToken<CreateResponse> token = new TypeToken<CreateResponse>() {};
		String uri = DingtalkAPIUrl.UpdateDepartment.getUrl();
		String url = uri+"?access_token="+AccessTokenMaintain.getAccessToken();
		
		String response = HttpsClient.doPost(url, JsonUtils.to(detail));
		CreateResponse createResponse = JsonUtils.gson.fromJson(response, token.getType());
		if(CommonUtils.isEmpty(createResponse.getId())) {
			logger.error("\r\n========更新部门失败");
			logger.error("\r\n========返回参数："+response);
			throw new OtherAPIException("更新部门失败");
		}
		logger.info("\r\n========返回参数："+response);
	}
	
	public static void delete(String departmentId) throws OtherAPIException {
		TypeToken<BaseResponse> token = new TypeToken<BaseResponse>() {};
		
		String uri = DingtalkAPIUrl.DeleteDepartment.getUrl();
		String url = uri+"?access_token="+AccessTokenMaintain.getAccessToken();
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", departmentId);
		String response = HttpsClient.doGet(url, map);
		BaseResponse baseResponse = JsonUtils.gson.fromJson(response, token.getType());
		if( (baseResponse.getErrcode()) != 0) {
			logger.error("\r\n========删除部门失败");
			logger.error("\r\n========返回参数："+response);
			throw new OtherAPIException("删除部门失败");
		}
		logger.info("\r\n========返回参数："+response);
	}
	
	
	
}
