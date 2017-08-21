package com.yeehaw.message.common.exception;

@SuppressWarnings("serial")
public class OtherAPIException extends Exception {

	public OtherAPIException() {
		super();
	}

	public OtherAPIException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OtherAPIException(String message, Throwable cause) {
		super(message, cause);
	}

	public OtherAPIException(String message) {
		super(message);
	}

	public OtherAPIException(Throwable cause) {
		super(cause);
	}

	
}

