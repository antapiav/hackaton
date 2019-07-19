package com.example.hackaton.exception;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.hackaton.util.AppConstants;
import com.example.hackaton.util.AppMessages;

@ControllerAdvice
public class AdviceController {
	private static final Logger log = LoggerFactory.getLogger(AdviceController.class);

	private MessageSource messageSource;

	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(HttpServletRequest request, Exception e) {
		log.error(e.getMessage(), e);

		Map<String, Object> map = new HashMap<>();
		map.put(AppConstants.PARAM_RESPONSE_CODE, HttpStatus.INTERNAL_SERVER_ERROR.value());
		map.put(AppConstants.PARAM_RESPONSE_MESSAGE, getValueMessage(AppMessages.GENERIC_RESPONSE_ERROR));
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@ExceptionHandler(AppInternalException.class)
	public ResponseEntity<Object> handleAppInternalException(HttpServletRequest request, AppInternalException e) {
		log.error(e.getMessage(), e);
		Map<String, Object> map = new HashMap<>();
		map.put(AppConstants.PARAM_RESPONSE_CODE, e.getStatusCode().value());
		map.put(AppConstants.PARAM_RESPONSE_MESSAGE, e.isMessageKey() ? getValueMessage(e.getMessageUser()) : e.getMessageUser());
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	private String getValueMessage(String key) {
		return messageSource.getMessage(key, new Object[] {}, AppConstants.NOT_FOUND_KEY, Locale.getDefault());
	}
}
