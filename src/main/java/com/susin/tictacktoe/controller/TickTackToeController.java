package com.susin.tictacktoe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.susin.tictacktoe.dto.MoveRequest;
import com.susin.tictacktoe.exception.TickTackToeException;
import com.susin.tictacktoe.model.Game;
import  com.susin.tictacktoe.service.TickTackToeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/tick-tack-toe")
@Tag(name = "TicTacToe API", description = "APIs to play TicTacToe game")
public class TickTackToeController {
	
	
	TickTackToeService tickTackToeService;

	public TickTackToeController(TickTackToeService tickTackToeService) {
		super();
		this.tickTackToeService = tickTackToeService;
	}
	
	@Operation(summary = "Get Current Game State", description = "Returns the current board, player turn, and status.")
	@GetMapping
	public Game getGame() {
	
		return tickTackToeService.getGame();
		
	}
	
	@Operation(summary = "Start New Game", description = "Resets the board and starts a new TicTacToe game.")
    @PostMapping("/start")
	public Game startNewGame() {
		return tickTackToeService.startNewGame();
		
	}
	
	@Operation(
	        summary = "Make a Move", 
	        description = "Makes a move at the specified row and column for the current player.")
	@PostMapping("/makeMove")
	public ResponseEntity<Object> makeMove(@RequestBody MoveRequest request ) {
		try {
		
		return new ResponseEntity<>(tickTackToeService.makeMove(request.getRow(), request.getCol()), HttpStatus.OK);
		}
		catch( Exception e) {
			getGame();
			throw new TickTackToeException(e.getMessage());
			
		}
	}
	
	

}
