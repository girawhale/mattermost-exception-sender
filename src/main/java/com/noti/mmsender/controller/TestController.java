package com.noti.mmsender.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("/test")
	public String test(String userId) {
		Long id = Long.valueOf(userId);
		
		return "hi";
	}
}
