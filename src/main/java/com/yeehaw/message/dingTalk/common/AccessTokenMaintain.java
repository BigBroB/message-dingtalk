package com.yeehaw.message.dingTalk.common;

import java.util.Date;

import com.yeehaw.message.common.exception.OtherAPIException;
import com.yeehaw.message.common.util.CommonUtils;

public class AccessTokenMaintain {

	private static String accessToken;
	private static Date updateTime;

	public AccessTokenMaintain() {

	}

	public static String getAccessToken() throws OtherAPIException {
		if (CommonUtils.isEmpty(accessToken) 
				|| CommonUtils.isEmpty(updateTime)
				|| (System.currentTimeMillis() - updateTime.getTime()) > 6000) {
			accessToken = ConnectionDingtalk.getAccessToken();
		}
		return accessToken;
	}

	public static void setAccessToken(String accessToken) {
		AccessTokenMaintain.accessToken = accessToken;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public static void setUpdateTime(Date updateTime) {
		AccessTokenMaintain.updateTime = updateTime;
	}

}
