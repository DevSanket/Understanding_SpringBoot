package com.sanketscode.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//REST API 
@RestController
public class HelloWorldController {
	
	@RequestMapping(method=RequestMethod.GET,path="hello-world")
	public String helloWorld() {
		return "hello world";
	}

}
