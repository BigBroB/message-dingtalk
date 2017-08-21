package com.yeehaw.message.dingTalk.message.body;

/** 
 * @ClassName: LinkMessage 
 * @Description: link消息 
 * @author bigbro_B
 * @date 2017年8月19日 上午10:41:19 
 *  
 */
public class LinkMessage {
	
	/**
	 * 消息点击链接地址
	 */
	private String messageUrl;
	/**
	 * 图片媒体文件 id，可以调用上传媒体文件接口获取
	 */
	private String picUrl;
	/**
	 * 消息标题
	 */
	private String title;
	/**
	 * 	消息描述
	 */
	private String text;

	public LinkMessage() {

	}

	public LinkMessage(String messageUrl, String picUrl, String title, String text) {
		super();
		this.messageUrl = messageUrl;
		this.picUrl = picUrl;
		this.title = title;
		this.text = text;
	}

	public String getMessageUrl() {
		return messageUrl;
	}

	public void setMessageUrl(String messageUrl) {
		this.messageUrl = messageUrl;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
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
