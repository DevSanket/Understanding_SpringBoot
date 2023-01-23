package com.sanketscode.hellospring.game;

import org.springframework.stereotype.Component;

@Component
public class PacmanGame implements GamingConsole {
	
	public void up() {
		System.out.println("Packman Jump");
	}
	
	public void down() {
		System.out.println("Packman Back");
	}
	
	public void left() {
		System.out.println("Packpan Left");
	}
	
	public void right() {
		System.out.println("Packman Right");
	}
	

}
