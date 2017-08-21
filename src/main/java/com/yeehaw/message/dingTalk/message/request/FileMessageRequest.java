package com.yeehaw.message.dingTalk.message.request;

import com.yeehaw.message.dingTalk.common.ecode.MessageType;
import com.yeehaw.message.dingTalk.common.ecode.RestMethod;
import com.yeehaw.message.dingTalk.message.body.FileMessage;

public class FileMessageRequest extends BaseMessageRequest{
	
	private FileMessage file;

	public FileMessageRequest() {
		super();
		setMethod(RestMethod.Asyncsend.getMethod());
		setMsgtype(MessageType.FILE.getType());
	}

	public FileMessageRequest(FileMessage file) {
		super();
		this.file = file;
		setMethod(RestMethod.Asyncsend.getMethod());
		setMsgtype(MessageType.FILE.getType());
	}

	public FileMessage getFile() {
		return file;
	}

	public void setFile(FileMessage file) {
		this.file = file;
	}
	
	
}
