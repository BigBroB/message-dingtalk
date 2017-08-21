package com.yeehaw.message.dingTalk.message.request;

import com.yeehaw.message.dingTalk.common.ecode.MessageType;
import com.yeehaw.message.dingTalk.common.ecode.RestMethod;
import com.yeehaw.message.dingTalk.message.body.LinkMessage;

public class LinkMessageRequest extends BaseMessageRequest{
	
	private LinkMessage link;

	public LinkMessageRequest() {
		super();
		setMethod(RestMethod.Asyncsend.getMethod());
		setMsgtype(MessageType.LINK.getType());
	}

	public LinkMessageRequest(LinkMessage link) {
		super();
		this.link = link;
		setMethod(RestMethod.Asyncsend.getMethod());
		setMsgtype(MessageType.LINK.getType());
	}

	public LinkMessage getLink() {
		return link;
	}

	public void setLink(LinkMessage link) {
		this.link = link;
	}
	
	
	
	
	
}
