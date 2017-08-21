package com.yeehaw.message.dingTalk.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.reflect.TypeToken;
import com.yeehaw.message.common.exception.OtherAPIException;
import com.yeehaw.message.common.httpClient.HttpsClient;
import com.yeehaw.message.common.util.CommonUtils;
import com.yeehaw.message.common.util.JsonUtils;
import com.yeehaw.message.dingTalk.common.AccessTokenMaintain;
import com.yeehaw.message.dingTalk.common.ecode.DingtalkAPIUrl;
import com.yeehaw.message.dingTalk.message.request.BaseMessageRequest;
import com.yeehaw.message.dingTalk.message.response.MessageResponse;

public class DingTalkMessageUtils {
	private static Logger logger = LoggerFactory.getLogger(DingTalkMessageUtils.class);
	
	/** 
	 * @Title: sendSynMessage 
	 * @Description: 发送企业同步消息 
	 * @param request
	 * @throws OtherAPIException    
	 * @return MessageResponse
	 */
	public static MessageResponse sendCompanySynMessage(BaseMessageRequest request) throws OtherAPIException {
		String uri = DingtalkAPIUrl.SendCompanyMessage.getUrl();
		String url = uri + "?access_token=" + AccessTokenMaintain.getAccessToken();
		String response = HttpsClient.doPost(url, JsonUtils.to(request));
		TypeToken<MessageResponse> token = new TypeToken<MessageResponse>() {};
		MessageResponse messageRes = JsonUtils.gsonDate.fromJson(response, token.getType());
		
		if(CommonUtils.isEmpty(messageRes.getMessageId())) {
			logger.error("发送同步消息失败"+JsonUtils.to(request));
			logger.error("\r\n----------"+response);
			throw new OtherAPIException("发送同步消息失败");
		}
		logger.info("发送同步消息成功"+JsonUtils.to(messageRes));
		return messageRes;
	}

	/** 
	 * @Title: sendAsyMessage 
	 * @Description: 发送企业异步消息
	 * @param request
	 * @throws OtherAPIException    
	 * @return MessageResponse
	 */
	@Deprecated
	public static MessageResponse sendCompanyAsyMessage(BaseMessageRequest request) throws OtherAPIException {

		String uri = DingtalkAPIUrl.RestAPI.getUrl();
		String url = uri + "?access_token=" + AccessTokenMaintain.getAccessToken();
//		TextMessageRequest text = new TextMessageRequest();
//		text.setToparty(id);
//		text.setMethod("dingtalk.corp.message.corpconversation.asyncsend");
//		text.setSession("ba134b0217863d8f82bc4ca5336a986a");
//		text.setTimestamp(JsonUtils.to(new Date()));
//		TextMessage message = new TextMessage();
//		message.setContent("不知道这样行不行123");
//		text.setText(message);
		request.setSession(AccessTokenMaintain.getAccessToken());
		String response = HttpsClient.doPost(url, JsonUtils.to(request));
		TypeToken<MessageResponse> token = new TypeToken<MessageResponse>() {};
		MessageResponse messageRes = JsonUtils.gsonDate.fromJson(response, token.getType());
		if(CommonUtils.isEmpty(messageRes.getMessageId())) {
			logger.error("发送异步消息失败"+JsonUtils.to(request));
			logger.error("\r\n----------"+response);
			throw new OtherAPIException("发送异步消息失败");
		}
		logger.info("发送异步消息成功"+JsonUtils.to(messageRes));
		return messageRes;
	}

}
