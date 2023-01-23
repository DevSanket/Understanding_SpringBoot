package com.sanketscode.hellospring.examples.c1;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component; 



 
@Configuration
@ComponentScan
public class RealWorldSpringContextLauncherApplication {
	
	
	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(RealWorldSpringContextLauncherApplication.class)){
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println(context.getBean(BusinessCalculationService.class).findMax());
			
			
		}catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
