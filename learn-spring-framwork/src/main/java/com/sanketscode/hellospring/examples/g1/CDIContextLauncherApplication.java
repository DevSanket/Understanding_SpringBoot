package com.sanketscode.hellospring.examples.g1;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named; 


//@Component
@Named
class BusinessService {
	
	private DataService dataservice;
	
	
//	@Autowired
	@Inject
	public void setDataservice(DataService dataservice) {
		System.out.println("Setter  Injection Perform");
		this.dataservice = dataservice;
	}
	 public DataService getDataservice() {
		
		return dataservice;
	}

}

//@Component
@Named
class DataService{
	
}

@Configuration
@ComponentScan
public class CDIContextLauncherApplication {
	
	
	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(CDIContextLauncherApplication.class)){
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		
			System.out.println(
					context.getBean(BusinessService.class)
					);
			
			
			
		}catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
