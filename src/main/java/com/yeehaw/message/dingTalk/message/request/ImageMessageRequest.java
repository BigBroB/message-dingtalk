package com.yeehaw.message.dingTalk.message.request;

import com.yeehaw.message.dingTalk.common.ecode.MessageType;
import com.yeehaw.message.dingTalk.common.ecode.RestMethod;
import com.yeehaw.message.dingTalk.message.body.ImageMessage;

public class ImageMessageRequest extends BaseMessageRequest{
	
	
	private ImageMessage image;

	public ImageMessageRequest(ImageMessage image) {
		super();
		this.image = image;
		setMethod(RestMethod.Asyncsend.getMethod());
		setMsgtype(MessageType.IMAGE.getType());
	}

	public ImageMessageRequest() {
		setMethod(RestMethod.Asyncsend.getMethod());
		setMsgtype(MessageType.IMAGE.getType());
	}

	public ImageMessage getImage() {
		return image;
	}

	public void setImage(ImageMessage image) {
		this.image = image;
	}
	
	
	
	
}
