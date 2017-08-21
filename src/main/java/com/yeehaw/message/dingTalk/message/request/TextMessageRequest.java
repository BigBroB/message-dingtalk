package com.yeehaw.message.dingTalk.message.request;

import com.yeehaw.message.dingTalk.common.ecode.MessageType;
import com.yeehaw.message.dingTalk.common.ecode.RestMethod;
import com.yeehaw.message.dingTalk.message.body.TextMessage;

public class TextMessageRequest extends BaseMessageRequest {
	

	private TextMessage text;

	public TextMessageRequest() {
		super();
		setMethod(RestMethod.Asyncsend.getMethod());
		setMsgtype(MessageType.TEXT.getType());
	}
	
	public TextMessageRequest(TextMessage text) {
		super();
		this.text = text;
		setMethod(RestMethod.Asyncsend.getMethod());
		setMsgtype(MessageType.TEXT.getType());
	}


	public TextMessage getText() {
		return text;
	}

	public void setText(TextMessage text) {
		this.text = text;
	}
	
	


	
}
