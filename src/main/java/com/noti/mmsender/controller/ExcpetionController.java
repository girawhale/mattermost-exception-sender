package com.noti.mmsender.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.noti.mmsender.mattermost.NotificationManager;

@ControllerAdvice
public class ExcpetionController {
	@Autowired
	private NotificationManager notificationManager;

	@ExceptionHandler(Exception.class)
	public ResponseEntity exceptionTest(Exception e, HttpServletRequest req) {
		e.printStackTrace();
		notificationManager.sendNotification(e, req.getRequestURI(), getParams(req));
		
		return null;
	}
	
	private String getParams(HttpServletRequest req) {
		StringBuilder params = new StringBuilder();
		Enumeration<String> keys = req.getParameterNames();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			params.append("- ").append(key).append(" : ").append(req.getParameter(key)).append('\n');
		}
		
		return params.toString();
	}
}
