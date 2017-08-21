package com.yeehaw.message.dingTalk.message.body;

/** 
 * @ClassName: MarkdownMessage 
 * @Description: Markdown消息
 * @author bigbro_B
 * @date 2017年8月19日 上午10:44:16 
 *  
 */
public class MarkdownMessage {

	/**
	 * 首屏会话透出的展示内容
	 */
	private String title;
	/**
	 * markdown 格式的消息
	 */
	private String text;

	public MarkdownMessage() {
	
	}

	public MarkdownMessage(String title, String text) {
		this.title = title;
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
	
}
