package br.com.zg.pokerhand.models

import br.com.zg.pokerhand.enums.Category

class Player {
	List<Card> cards
	Long points

	Category category

	Player(){
		cards = []
		points = 0
	}

	Player(List<Card> cards, Long points) {
		this.cards = cards
		this.points = points
	}
}
