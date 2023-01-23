package com.sanketscode.hellospring.examples.a1;

import java.util.Arrays;

import org.springframework.beans.BeansException;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration; 


 
@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {
	
	
	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)){
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

		}catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
