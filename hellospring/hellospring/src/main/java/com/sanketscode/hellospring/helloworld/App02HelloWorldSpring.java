package com.sanketscode.hellospring.helloworld;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		// Launch a spring Context
		
		// Configure the things that we want spring to manage - @Configuration	
	try (var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
		//Retrieving Beans managed by Spring
//	System.out.println(context.getBean("name"));
//	System.out.println(context.getBean("age"));
//	System.out.println(context.getBean("person"));
//	System.out.println(context.getBean("person2MethodCall"));
//	System.out.println(context.getBean("person3Parameters"));
//	System.out.println(context.getBean("address2"));
		// give an exception make the bean primary
		System.out.println(context.getBean(Address.class));
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
	
	
	} catch (BeansException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	//HelloWorldConfigurationClass - @Configuration
	//name - @Bean
 
	
//	System.out.println(context.getBean("person4Parameters"));
	
	

	
	
	}

}
