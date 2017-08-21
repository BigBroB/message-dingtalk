package com.yeehaw.message.dingTalk.message.request;

import com.yeehaw.message.dingTalk.common.ecode.MessageType;
import com.yeehaw.message.dingTalk.common.ecode.RestMethod;
import com.yeehaw.message.dingTalk.message.body.VoiceMessage;

public class VoiceMessageRequest extends BaseMessageRequest {
	
	private VoiceMessage voice;

	
	public VoiceMessageRequest() {
		super();
		setMethod(RestMethod.Asyncsend.getMethod());
		setMsgtype(MessageType.VOICE.getType());
	}


	public VoiceMessageRequest(VoiceMessage voice) {
		super();
		this.voice = voice;
		setMethod(RestMethod.Asyncsend.getMethod());
		setMsgtype(MessageType.VOICE.getType());
	}


	public VoiceMessage getVoice() {
		return voice;
	}


	public void setVoice(VoiceMessage voice) {
		this.voice = voice;
	}
	
	
}
