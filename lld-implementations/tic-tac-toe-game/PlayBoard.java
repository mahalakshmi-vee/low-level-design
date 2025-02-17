package com.practice.tic_tac_toe_game;

import lombok.Getter;

@Getter
public class PlayBoard {
	private PlayPiece[][] board;

	public PlayBoard() {
		board = new PlayPiece[3][3];
	}

	public boolean isValidCell(int row, int column) {
		if (!(row >= 0 && column >= 0 && row < board.length && column < board[0].length)) {
			System.out.println("Please input a valid row and column cell.");
			return false;
		}
		if (board[row][column] != null) {
			System.out.println("The chosen cell has already a playing piece. Please choose a different cell.");
			return false;
		}
		return true;
	}

	public boolean canPlaceThePiece(int row, int column, PlayPiece playPiece) {

		board[row][column] = playPiece;
		return true;
	}

	public boolean isPlayerWon(int row, int column, PlayPiece playPiece) {
		boolean isWon = true;
		// Horizontal check
		for (int c = 0; c < board[0].length; c++) {
			if (c == column)
				continue;
			if (board[row][c] != playPiece) {
				isWon = false;
				break;
			}
		}

		if (isWon)
			return isWon;

		// Vertical check
		for (int r = 0; r < board.length; r++) {
			if (r == row)
				continue;
			if (board[r][column] != playPiece) {
				isWon = false;
				break;
			}
		}

		if (isWon)
			return isWon;

		// Diagonal check (top-left to bottom-right)
		if (row == column) {
			for (int i = 0; i < board.length; i++) {
				if (board[i][i] != playPiece) {
					isWon = false;
					break;
				}
			}
		}

		// Diagonal check (top-right to bottom-left)
		if (row + column == board.length - 1) {
			for (int i = 0; i < board.length; i++) {
				if (board[i][board[0].length - 1 - i] != playPiece) {
					isWon = false;
					break;
				}
			}
		}

		return isWon;
	}

	public boolean isAllCellsFilled() {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] == null)
					return false;
			}
		}
		return true;
	}

	public void displayBoard() {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				System.out.print(board[row][col] == null ? " " : board[row][col]);
				if (col < board[row].length - 1)
					System.out.print("|");
			}
			System.out.println();
			if (row < board.length - 1) {
				System.out.println("---------");
			}
		}
	}
}
