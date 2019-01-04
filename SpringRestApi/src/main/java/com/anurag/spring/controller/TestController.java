package com.anurag.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.spring.dao.IdGeneratorDao;

@RestController
public class TestController {
	 
	
	@Autowired
	IdGeneratorDao idGeneratorDao;

	@RequestMapping("/")
	public String welcome() {//Welcome page, non-rest
		return "Welcome to RestTemplate Example.";
	}

	@RequestMapping("/doIncrement")
	public String doIncrement() {//Welcome page, non-rest
		return "Reslult :: "+idGeneratorDao.doIncrementWithLock();
	}

	
	
	 

	
}
