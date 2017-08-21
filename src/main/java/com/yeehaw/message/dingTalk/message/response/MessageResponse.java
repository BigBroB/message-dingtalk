package com.yeehaw.message.dingTalk.message.response;

import com.yeehaw.message.dingTalk.common.response.BaseResponse;

public class MessageResponse extends BaseResponse{
	
	/**
	 * 无效的 userid
	 */
	private String invaliduser;
	
	/**
	 * 无效的部门 id
	 */
	private String invalidparty;
	
	/**
	 * 因发送消息过于频繁或超量而被流控过滤后实际未发送的 userid。
	 * 未被限流的接收者仍会被成功发送。
	 * 限流规则包括：1、给同一用户发相同内容消息一天仅允许一次；
	 * 2、如果是 ISV 接入方式，给同一用户发消息一天不得超过 50 次；
	 * 如果是企业接入方式，此上限为 500。
	 */
	private String forbiddenUserId;
	
	/**
	 * 标识企业消息的 id，字符串，最长 128 个字符
	 */
	private String messageId;

	public MessageResponse() {
		super();
	
	}

	public MessageResponse(String invaliduser, String invalidparty, String forbiddenUserId, String messageId) {
		super();
		this.invaliduser = invaliduser;
		this.invalidparty = invalidparty;
		this.forbiddenUserId = forbiddenUserId;
		this.messageId = messageId;
	}

	public String getInvaliduser() {
		return invaliduser;
	}

	public void setInvaliduser(String invaliduser) {
		this.invaliduser = invaliduser;
	}

	public String getInvalidparty() {
		return invalidparty;
	}

	public void setInvalidparty(String invalidparty) {
		this.invalidparty = invalidparty;
	}

	public String getForbiddenUserId() {
		return forbiddenUserId;
	}

	public void setForbiddenUserId(String forbiddenUserId) {
		this.forbiddenUserId = forbiddenUserId;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	
	
	
	
}
