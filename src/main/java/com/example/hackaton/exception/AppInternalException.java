package com.example.hackaton.exception;

import org.springframework.http.HttpStatus;

public class AppInternalException extends Exception {
	
	private static final long serialVersionUID = 1L;

	private final HttpStatus statusCode;
	private final String messageUser;
	private final boolean messageKey;

	public AppInternalException(Throwable cause, HttpStatus statusCode, String messageUser, boolean messageKey) {
		super(cause);
		this.statusCode = statusCode;
		this.messageUser = messageUser;
		this.messageKey = messageKey;
	}

	public AppInternalException(HttpStatus statusCode, String messageUser, boolean messageKey) {
		super(messageUser);
		this.statusCode = statusCode;
		this.messageUser = messageUser;
		this.messageKey = messageKey;
	}

	public AppInternalException(Throwable cause, HttpStatus statusCode, String messageUser) {
		super(cause);
		this.statusCode = statusCode;
		this.messageUser = messageUser;
		this.messageKey = false;
	}

	public AppInternalException(HttpStatus statusCode, String messageUser) {
		super(messageUser);
		this.statusCode = statusCode;
		this.messageUser = messageUser;
		this.messageKey = false;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public boolean isMessageKey() {
		return messageKey;
	}

	public String getMessageUser() {
		return messageUser;
	}
}
