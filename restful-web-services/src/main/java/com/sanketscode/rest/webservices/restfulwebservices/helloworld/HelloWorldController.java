package com.sanketscode.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//REST API 
@RestController
public class HelloWorldController {
	
//	private MessageSource messagesource;
//	public HelloWorldController(MessageSource messagesource) {
//		this.messagesource = messagesource;
//	}
	
//	@RequestMapping(method=RequestMethod.GET,path="hello-world")
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "hello world";
	}
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	//path parameters
	// /users/{id}/todos/{id} => /users/1/todos/10
	
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean("Hello "+name);
	}
	
//	@GetMapping(path="/hello-world-internationalized")
//	public String helloWorldInternationalize() {
//		Locale locale =  LocaleContextHolder.getLocale();
//		return messagesource.getMessage("good.morning.message", null, locale);
////		return "hello world v2";
//	}
	

}
