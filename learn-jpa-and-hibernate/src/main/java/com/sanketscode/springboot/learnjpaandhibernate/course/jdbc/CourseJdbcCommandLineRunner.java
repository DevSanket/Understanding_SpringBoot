package com.sanketscode.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sanketscode.springboot.learnjpaandhibernate.course.Course;


@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private CourseJdbcRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.insert(
				new Course(1,"Learn AWS","in28minutes")
				
				);
		
		repository.insert(new Course(2,"Learn GCP","in28minutes"));
		repository.insert(new Course(3,"Learn Azure","in28minutes"));
		
//		repository.delete(2);
		
		System.out.println(repository.findById(2));
	}
	
	

}
