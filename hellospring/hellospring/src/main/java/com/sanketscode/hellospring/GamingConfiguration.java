package com.sanketscode.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sanketscode.hellospring.game.GameRunner;
import com.sanketscode.hellospring.game.GamingConsole;
import com.sanketscode.hellospring.game.PacmanGame;
@Configuration
public class GamingConfiguration {
	
	@Bean
	public GamingConsole game() {
		return new PacmanGame();
	}
	
	@Bean
	public GameRunner gameRunner(GamingConsole game) {
		
		var gameRunner = new GameRunner(game());
		return gameRunner;
		
	}

}
