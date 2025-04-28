package com.susin.tictacktoe.model;

import java.util.Arrays;

import com.susin.tictacktoe.enums.StatusEnum;

public class Game {
	
	String[][] board;
	String  currentPlayer;
	StatusEnum status;
	public String[][] getBoard() {
		return board;
	}
	public void setBoard(String[][] board) {
		this.board = board;
	}
	public String getCurrentPlayer() {
		return currentPlayer;
	}
	public void setCurrentPlayer(String currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Game [board=" + Arrays.toString(board) + ", currentPlayer=" + currentPlayer + ", status=" + status
				+ "]";
	}
	public void switchPlayer(){
		this.currentPlayer = currentPlayer == "X"? "O":"X";
	}

	public Game() {
		board = new String[3][3];
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				board[i][j] = "";
			}
		}
		//Arrays.fill(board, "");
		this.currentPlayer = "X";
		status = StatusEnum.inProgress;
	}
}
