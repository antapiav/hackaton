package com.example.hackaton.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.example.hackaton.util.AppConstants;

public abstract class AbstractController {
	
	protected MessageSource messageSource;

	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	protected String getValueMessage(String key) {
		return messageSource.getMessage(key, new Object[] {}, AppConstants.NOT_FOUND_KEY, Locale.getDefault());
	}
	
	protected String getValueMessage(String key, Object[] args) {
		return messageSource.getMessage(key, args, AppConstants.NOT_FOUND_KEY, Locale.getDefault());
	}
}
