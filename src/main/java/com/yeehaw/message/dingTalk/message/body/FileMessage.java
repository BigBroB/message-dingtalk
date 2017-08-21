package com.yeehaw.message.dingTalk.message.body;

/** 
 * @ClassName: FileMessage 
 * @Description: 文件消息
 * @author bigbro_B
 * @date 2017年8月19日 上午10:38:51 
 *  
 */
public class FileMessage extends BaseMediaMessage {
	
	
	public FileMessage() {
	
	}
	
	/**
	 * 媒体文件 id，可以调用上传媒体文件接口获取。10MB
	 * @param media_id
	 */
	public FileMessage(String media_id) {
		setMedia_id(media_id);
	}
	
	
	
}
