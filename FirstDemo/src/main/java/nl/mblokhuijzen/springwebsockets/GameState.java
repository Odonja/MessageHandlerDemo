package nl.mblokhuijzen.springwebsockets;

import java.io.Serializable;
import java.util.UUID;

public class GameState implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UUID gameUUID;
	private int[][] board = new int[2][2];
	private int whosTurn;
	private boolean gameOver;

	public GameState() {

	}

	public GameState(UUID gameUUID, int[][] board, int whosTurn, boolean gameOver) {
		this.gameUUID = gameUUID;
		this.board = board;
		this.whosTurn = whosTurn;
		this.gameOver = gameOver;
	}

	public UUID getGameUUID() {
		return gameUUID;
	}

	public void setGameUUID(UUID gameUUID) {
		this.gameUUID = gameUUID;
	}

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	public int getWhosTurn() {
		return whosTurn;
	}

	public void setWhosTurn(int whosTurn) {
		this.whosTurn = whosTurn;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	@Override
	public String toString() {
		return "GameState [gameUUID=" + gameUUID + ", board={{" + board[0][0] + ", " + board[0][1] + "},{" + board[1][0]
				+ ", " + board[1][1] + "}}" + ", whosTurn=" + whosTurn + ", gameOver=" + gameOver + "]";
	}

}
