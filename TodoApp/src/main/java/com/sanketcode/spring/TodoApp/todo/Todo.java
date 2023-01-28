package com.sanketcode.spring.TodoApp.todo;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;



public class Todo {
	
	private int id;
	private String username;
	
	@Size(min=10,message="Enter at least 10 characters")
	private String description;
	private LocalDate targetDate;
	private boolean Done;
	
	
	public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		Done = done;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDate getTargetDate() {
		return targetDate;
	}


	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}


	public boolean isDone() {
		return Done;
	}


	public void setDone(boolean done) {
		Done = done;
	}


	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", Done=" + Done + "]";
	}
	
	
	
	

}
