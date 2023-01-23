package com.sanketscode.hellospring.game;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifier")
public class SuperContraGame implements GamingConsole{
	
	public void up() {
		System.out.println("Jump");
	}
	
	public void down() {
		System.out.println("Sit Down");
	}
	
	public void left() {
		System.out.println("Go back");
	}
	
	public void right() {
		System.out.println("shoot bullet");
	}
	

}
