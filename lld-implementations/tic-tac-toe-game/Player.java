package com.practice.tic_tac_toe_game;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
	private String playerName;
	private PlayPiece playPiece;
}
