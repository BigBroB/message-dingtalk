package com.yeehaw.message.dingTalk.message.body;

/** 
 * @ClassName: 图片信息 
 * @Description: TODO 
 * @author bigbro_B
 * @date 2017年8月19日 上午10:34:25 
 *  
 */
public class ImageMessage extends BaseMediaMessage{
	
	/**
	 * 图片媒体文件 id，可以调用上传媒体文件接口获取。建议宽 600 像素 x 400 像素，宽高比 3：2
	 */

	public ImageMessage() {
	
	}

	public ImageMessage(String media_id) {
		setMedia_id(media_id);
	}


}
