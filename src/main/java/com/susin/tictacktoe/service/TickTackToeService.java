package com.susin.tictacktoe.service;

import org.springframework.stereotype.Service;

import com.susin.tictacktoe.enums.StatusEnum;
import com.susin.tictacktoe.exception.TickTackToeException;
import com.susin.tictacktoe.model.Game;

@Service
public class TickTackToeService {

	private Game game = new Game();
	
	public Game startNewGame() {
		game = new Game();
		return game;
		
	}
	public Game makeMove(int row, int col) {
		if(!game.getStatus().equals(StatusEnum.inProgress)){
			throw new TickTackToeException("Game is already over");
					
		}
		
		if(row<0 || row>2 || col<0 || col>2 || game.getBoard()[row][col] != "") {
			throw new TickTackToeException("Invalid Move");
		}
		
		game.getBoard()[row][col]= game.getCurrentPlayer();
		if(checkWin(game.getCurrentPlayer())) {
			if(game.getCurrentPlayer() == "X") {
				game.setStatus(StatusEnum.won_x );
				}
			else{
				game.setStatus(StatusEnum.won_o );
			}
			
		}
		else if(checkDraw()) {
			game.setStatus(StatusEnum.draw);
		}
		else {
			game.switchPlayer();
		}
		return game;
	}
	
	public boolean checkWin(String player) {
		String [][] board= game.getBoard();
		if((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
				(board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
			return true;
		}
		
		for(int i=0;i<3;i++) {
			if((board[i][0]== player && board[i][1]== player && board[i][2]== player)||
			(board[0][i]== player && board[1][i]== player && board[2][i]== player)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkDraw() {
		
		String[][] board= game.getBoard();
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(board[i][j] == "" ){
					return false;
				}
			}
			
		}
		return true;
	}
	
	public Game getGame() {
		return game;
	}
}
