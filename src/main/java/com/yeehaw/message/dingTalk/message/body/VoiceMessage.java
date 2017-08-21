package com.yeehaw.message.dingTalk.message.body;

import com.yeehaw.message.common.exception.OtherAPIException;

/** 
 * @ClassName: VoiceMessage 
 * @Description: 声音消息
 * @author bigbro_B
 * @date 2017年8月19日 上午10:37:04 
 *  
 */
public class VoiceMessage extends BaseMediaMessage{
	/**
	 * 语音媒体文件 id，可以调用上传媒体文件接口获取。2MB，播放长度不超过 60s，AMR 格式
	 */
	/**
	 * 正整数，小于 60，表示音频时长
	 */
	private String duration;

	public VoiceMessage() {

	}

	public VoiceMessage(String media_id, Integer duration) throws OtherAPIException {
		setMedia_id(media_id);
		if (duration > 60) {
			throw new OtherAPIException("播放长度不超过 60s");
		}
		this.duration = duration.toString();
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

}
