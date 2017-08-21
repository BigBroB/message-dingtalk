package com.yeehaw.message.dingTalk.message.request;

import com.yeehaw.message.dingTalk.common.properties.DingTalkConfiguration;
import com.yeehaw.message.dingTalk.common.request.BaseRequest;

public class BaseMessageRequest extends BaseRequest{
	private String msgtype;
	private Integer agentid = DingTalkConfiguration.agentid;
	private String toparty ;
	private String touser;
	
	
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	public Integer getAgentid() {
		return agentid;
	}
	public void setAgentid(Integer agentid) {
		this.agentid = agentid;
	}
	public String getToparty() {
		return toparty;
	}
	public void setToparty(String toparty) {
		this.toparty = toparty;
	}
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	
	
	
}
