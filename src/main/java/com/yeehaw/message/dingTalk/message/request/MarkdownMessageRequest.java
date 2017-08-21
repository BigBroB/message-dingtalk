package com.yeehaw.message.dingTalk.message.request;

import com.yeehaw.message.dingTalk.common.ecode.MessageType;
import com.yeehaw.message.dingTalk.common.ecode.RestMethod;
import com.yeehaw.message.dingTalk.message.body.MarkdownMessage;

public class MarkdownMessageRequest extends BaseMessageRequest{
	
	private MarkdownMessage markdown;

	public MarkdownMessageRequest() {
		super();
		setMethod(RestMethod.Asyncsend.getMethod());
		setMsgtype(MessageType.MARKDOWN.getType());
	}

	public MarkdownMessageRequest(MarkdownMessage markdown) {
		super();
		this.markdown = markdown;
		setMethod(RestMethod.Asyncsend.getMethod());
		setMsgtype(MessageType.MARKDOWN.getType());
	}

	public MarkdownMessage getMarkdown() {
		return markdown;
	}

	public void setMarkdown(MarkdownMessage markdown) {
		this.markdown = markdown;
	}
	
	
	
	
}
