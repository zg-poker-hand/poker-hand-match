package br.com.zg.pokerhand.models

class Game {
	Board board
	List<Player> players
	Player winner
	String name

	Game(){
		board = new Board()
		players = []
		name = ''
	}
}
