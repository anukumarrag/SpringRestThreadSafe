package com.anurag.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.spring.service.IdGeneratorService;

@RestController
public class TestController {
	 
	@Autowired
	IdGeneratorService idGeneratorService;
	
	@RequestMapping("/")
	public String welcome() {//Welcome page, non-rest
		return "Hello click <a href='doIncrement'> Here </a>";
	}

	@RequestMapping("/doIncrement")
	public String doIncrement() {//Welcome page, non-rest
		return "Reslult :: "+idGeneratorService.increaseNumberForID();
	}

	
	
	 

	
}
