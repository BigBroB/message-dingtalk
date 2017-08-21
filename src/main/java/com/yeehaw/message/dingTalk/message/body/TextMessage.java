package com.yeehaw.message.dingTalk.message.body;

public class TextMessage {
	
	/**
	 * 普通消息内容
	 */
	private String content;
	
	public TextMessage() {
		
	}
	
	public TextMessage(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	

	
}
