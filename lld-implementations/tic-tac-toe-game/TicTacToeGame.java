package com.practice.tic_tac_toe_game;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class TicTacToeGame {
	private static TicTacToeGame instance;
	private PlayBoard playBoard;
	private Deque<Player> players;

	private TicTacToeGame() {
		playBoard = new PlayBoard();
		players = new ArrayDeque<>();

		Player john = new Player("John", PlayPiece.O);
		Player marry = new Player("Marry", PlayPiece.X);

		players.add(john);
		players.add(marry);
	}

	public static TicTacToeGame getInstance() {
		if (instance != null) {
			return instance;
		}
		instance = new TicTacToeGame();
		return instance;
	}

	public void startGame() {
		boolean blnWin = false;
		Scanner scanner = new Scanner(System.in);
		while (!blnWin) {
			Player currentPlayer = players.pollFirst();
			System.out
					.println("Please enter the row and column to place the play piece " + currentPlayer.getPlayPiece());
			int row = scanner.nextInt();
			int column = scanner.nextInt();
			// Validate row and column value
			if (!playBoard.isCellValid(row, column)) {
				players.addFirst(currentPlayer);
				continue;
			}

			// Place the piece
			if (!playBoard.placePlayPiece(row, column, currentPlayer.getPlayPiece())) {
				players.addFirst(currentPlayer);
				continue;
			}

			// Check current player won the match or not
			blnWin = playBoard.isPlayerWon(row, column, currentPlayer.getPlayPiece());
			if (blnWin) {
				System.out.println(currentPlayer.getPlayerName() + " won the match!");
				playBoard.displayBoard(); // Show final board state
				break;
			}

			if (playBoard.isAllCellsFilled()) {
				break;
			}

			playBoard.displayBoard();
			players.addLast(currentPlayer);
		}
		if (!blnWin) {
			System.out.println("Game ended with a tie.");
			playBoard.displayBoard(); // Show final board state
		}
		scanner.close();
	}
}
