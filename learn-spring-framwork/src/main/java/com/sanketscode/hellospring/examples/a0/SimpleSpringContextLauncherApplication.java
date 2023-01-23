package com.sanketscode.hellospring.examples.a0;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component; 


//your business class
@Component
class YourBusinessClass {
	
	Dependency1 dependency1;
	Dependency2 dependency2;
	
	//AutoWiring in not important for constructor
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("Contructor Injection - YourBusinessClass");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

	public String toString() {
		return "Using "+ dependency1 + " and " + dependency2;
	}
	
	
//	@Autowired
//	public Dependency1 getDependency1() {
//		return dependency1;
//	}
//	@Autowired
//	public Dependency2 getDependency2() {
//		return dependency2;
//	}
//	
	
//	@Autowired
//	public void setDependency1(Dependency1 dependency1) {
//		System.out.println("Setter Injection - SetDependency1");
//		this.dependency1 = dependency1;
//	}
//	
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		System.out.println("Setter Injection - SetDependency2");
//		this.dependency2 = dependency2;
//	}
	
	
	
	
	
	
}

//dependency 1
@Component
class Dependency1{
	
}
// dependency 2
@Component
class Dependency2{
	
}

 
@Configuration
@ComponentScan
public class SimpleSpringContextLauncherApplication {
	
	
	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(SimpleSpringContextLauncherApplication.class)){
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean(YourBusinessClass.class));
			
			
		}catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
