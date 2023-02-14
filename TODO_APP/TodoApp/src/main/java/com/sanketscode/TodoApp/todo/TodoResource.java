package com.sanketscode.TodoApp.todo;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanketscode.TodoApp.todo.jpa.TodoRepository;

@RestController
public class TodoResource {
	

	private TodoRepository todoRepository;
	
	public TodoResource(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
		
	@GetMapping("/users/{username}/todos")
	public List<Todo> retriveTodos(@PathVariable String username) {
		return todoRepository.findByUsername(username);
	}
	@GetMapping("/users/{username}/todos/{id}")
	public Optional<Todo> retriveTodo(@PathVariable String username,@PathVariable int id) {
		return todoRepository.findById(id);
	}
	
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username,@PathVariable int id){
		todoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping("/users/{username}/todos/{id}")
	public Todo updateTodo(@PathVariable String username,@PathVariable int id,@RequestBody Todo todo){
		todoRepository.save(todo);
		return todo;
		
	}
	
	@PostMapping("/users/{username}/todos")
	public Todo createTodo(@PathVariable String username,@RequestBody Todo todo){
		todo.setUsername(username);
		todo.setId(null);
//		Todo createdTodo =  todoRepository.addTodo(username,todo.getDescription(),todo.getTargetDate(),todo.isDone());
		return todoRepository.save(todo);
		
	}
	
	
}
