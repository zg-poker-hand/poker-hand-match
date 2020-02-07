package br.com.zg.pokerhand.models

class Player {
	List<Card> cards
	Long points

	Player(){
		cards = []
		points = 0
	}

	Player(List<Card> cards, Long points) {
		this.cards = cards
		this.points = points
	}
}
