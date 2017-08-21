package com.yeehaw.message.dingTalk.common.ecode;

public enum MessageType {
	TEXT("text"),
	IMAGE("image"),
	VOICE("voice"),
	FILE("file"),
	LINK("link"),
	OA("oa"),
	MARKDOWN("markdown"),
	;
	String type;

	MessageType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
