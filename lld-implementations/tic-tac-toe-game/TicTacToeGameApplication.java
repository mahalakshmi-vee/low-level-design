package com.practice.tic_tac_toe_game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicTacToeGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicTacToeGameApplication.class, args);

		TicTacToeGame ticTacToeGame = TicTacToeGame.getInstance();
		ticTacToeGame.startGame();
	}

}
