package com.yeehaw.message.dingTalk.role;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.CorpRoleListRequest;
import com.dingtalk.api.request.CorpRoleSimplelistRequest;
import com.dingtalk.api.response.CorpRoleListResponse;
import com.dingtalk.api.response.CorpRoleSimplelistResponse;
import com.google.gson.reflect.TypeToken;
import com.taobao.api.ApiException;
import com.yeehaw.message.common.exception.OtherAPIException;
import com.yeehaw.message.common.util.JsonUtils;
import com.yeehaw.message.dingTalk.common.AccessTokenMaintain;
import com.yeehaw.message.dingTalk.common.ecode.DingtalkAPIUrl;
import com.yeehaw.message.dingTalk.role.response.emp.RoleSimplelistResponse;
import com.yeehaw.message.dingTalk.role.response.role.RoleListResponse;

public class DingTalkRoleUtils {

	private static Logger logger = LoggerFactory.getLogger(DingTalkRoleUtils.class);

	/**
	 * @Title: getRoleList
	 * @Description: 获取角色列表
	 * @throws OtherAPIException
	 * @throws ApiException
	 * @return RoleListResponse
	 */
	public static RoleListResponse getRoleList() throws OtherAPIException, ApiException {
		DingTalkClient client = new DefaultDingTalkClient(DingtalkAPIUrl.RestAPI.getUrl());
		CorpRoleListRequest req = new CorpRoleListRequest();
		req.setSize(20L);
		req.setOffset(0L);
		CorpRoleListResponse rsp = client.execute(req, AccessTokenMaintain.getAccessToken());
		TypeToken<RoleListResponse> type = new TypeToken<RoleListResponse>() {
		};
		RoleListResponse response = JsonUtils.gsonDate.fromJson(rsp.getBody(), type.getType());
		logger.info("获取参数：" + JsonUtils.to(response));
		return response;
	}

	/**
	 * @Title: getUserListByRoleIdByPage
	 * @Description: 获取员工列表
	 * @param id
	 * @param off
	 * @param size
	 * @throws ApiException
	 * @throws OtherAPIException
	 * @return RoleSimplelistResponse
	 */
	public static RoleSimplelistResponse getUserListByRoleIdByPage(Long id, Long off, Long size)
			throws ApiException, OtherAPIException {
		DingTalkClient client = new DefaultDingTalkClient(DingtalkAPIUrl.RestAPI.getUrl());
		CorpRoleSimplelistRequest req = new CorpRoleSimplelistRequest();
		req.setRoleId(id);
		req.setSize(off);
		req.setOffset(size);
		CorpRoleSimplelistResponse rsp = client.execute(req, AccessTokenMaintain.getAccessToken());
		TypeToken<RoleSimplelistResponse> type = new TypeToken<RoleSimplelistResponse>() {
		};
		RoleSimplelistResponse response = JsonUtils.gsonDate.fromJson(rsp.getBody(), type.getType());
		logger.info("获取参数：" + JsonUtils.to(response));
		return response;
	}

	/**
	 * @Title: getUserListByRoleIdDefault
	 * @Description: 默认查询员工列表，第一页，一页20条
	 * @param id
	 * @throws ApiException
	 * @throws OtherAPIException
	 * @return RoleSimplelistResponse
	 */
	public static RoleSimplelistResponse getUserListByRoleIdDefault(Long id) throws ApiException, OtherAPIException {
		return getUserListByRoleIdByPage(id, 20L, 0L);
	}

}
