package br.com.zg.pokerhand.models

class Game {
	Board board
	List<Player> players
	Player winner

	Game(){
		board = new Board()
		players = []
	}
}
