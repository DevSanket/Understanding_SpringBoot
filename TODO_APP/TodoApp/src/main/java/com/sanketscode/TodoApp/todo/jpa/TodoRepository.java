package com.sanketscode.TodoApp.todo.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanketscode.TodoApp.todo.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>{
	
	List<Todo> findByUsername(String username);
	

}
