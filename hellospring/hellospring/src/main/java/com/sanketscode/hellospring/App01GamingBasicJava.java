package com.sanketscode.hellospring;

import com.sanketscode.hellospring.game.GameRunner;
import com.sanketscode.hellospring.game.PacmanGame;
import com.sanketscode.hellospring.game.MarioGame;
import com.sanketscode.hellospring.game.SuperContraGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		var marioGame = new  MarioGame();
//		var game = new SuperContraGame();
		var PacmanGame = new PacmanGame(); //object creation
		var gameRunner = new GameRunner(PacmanGame); // object creation + wiring of depedencies
		gameRunner.run();
		

	}

}

