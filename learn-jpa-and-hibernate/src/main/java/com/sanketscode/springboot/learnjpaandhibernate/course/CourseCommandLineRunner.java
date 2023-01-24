package com.sanketscode.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sanketscode.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.sanketscode.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.sanketscode.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;


@Component
public class CourseCommandLineRunner implements CommandLineRunner {
	
//	@Autowired
//	private CourseJdbcRepository repository;
	
//	@Autowired
//	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		repository.insert(
//				new Course(1,"Learn AWS","in28minutes")
//				
//				);
//		
//		repository.insert(new Course(2,"Learn GCP","in28minutes"));
//		repository.insert(new Course(3,"Learn Azure","in28minutes"));
		
//		repository.delete(2);
		
//		System.out.println(repository.findById(2));
		
		repository.save(
				new Course(1,"Learn AWS","in28minutes")
				
				);
		
		repository.save(new Course(2,"Learn GCP","in28minutes"));
		repository.save(new Course(3,"Learn Azure","in28minutes"));
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		
//		System.out.println(repository.findByAuthor("in28minutes"));
		System.out.println(repository.findByName("Learn AWS"));
		
		
	}
	
	

}
