package com.sanketscode.hellospring.examples.h1;

import java.util.Arrays;

import org.springframework.beans.BeansException;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sanketscode.hellospring.game.GameRunner;


@Configuration
@ComponentScan
public class XmlConfigrationContextLauncherApplication {
	
	
	public static void main(String[] args) {
		
		try(var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")){
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println(context.getBean("name"));
			
			context.getBean(GameRunner.class).run();
			
			
		}catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
