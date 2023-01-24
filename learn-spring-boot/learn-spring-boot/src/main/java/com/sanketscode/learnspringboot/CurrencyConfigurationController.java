package com.sanketscode.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CurrencyConfigurationController {
	
	@Autowired
	private CurrencyServiceConfigration configuration;
	
	@RequestMapping("/currency-configuration")
	public CurrencyServiceConfigration retriveAllCourses(){
		return configuration;
	}
	

}
