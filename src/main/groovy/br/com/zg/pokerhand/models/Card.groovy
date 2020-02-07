package br.com.zg.pokerhand.models

import br.com.zg.pokerhand.enums.CardSuit
import br.com.zg.pokerhand.enums.CardValue

class Card {
	CardValue value
	String description
	CardSuit suit

	Card() {
	}

	Card(CardValue value, String description, CardSuit suit) {
		this.value = value
		this.description = description
		this.suit = suit
	}


}
