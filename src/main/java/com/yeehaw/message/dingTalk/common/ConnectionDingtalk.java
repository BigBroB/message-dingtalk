package com.yeehaw.message.dingTalk.common;

import java.util.HashMap;
import java.util.Map;

import com.yeehaw.message.common.exception.OtherAPIException;
import com.yeehaw.message.common.httpClient.HttpsClient;
import com.yeehaw.message.common.util.CommonUtils;
import com.yeehaw.message.common.util.JsonUtils;
import com.yeehaw.message.dingTalk.common.ecode.DingtalkAPIUrl;
import com.yeehaw.message.dingTalk.common.properties.DingTalkConfiguration;

public class ConnectionDingtalk {
	
	
	public static String getAccessToken() throws OtherAPIException {
		Map<String,String> map = new HashMap<String,String>();
		map.put("corpid", DingTalkConfiguration.corpid);
		map.put("corpsecret", DingTalkConfiguration.corpsecret);
		String response = HttpsClient.doGet(DingtalkAPIUrl.AccessToken.getUrl(),map);
		Map<String,Object> maps = JsonUtils.toObjectMap(response);
		String accessToken = (String) maps.get("access_token");
		if(CommonUtils.isEmpty(accessToken)) {
			throw new OtherAPIException("获取access_token失败");
		}
		return accessToken;
	}

}
