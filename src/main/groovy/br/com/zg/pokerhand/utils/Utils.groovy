package br.com.zg.pokerhand.utils

import br.com.zg.pokerhand.enums.CardSuit
import br.com.zg.pokerhand.enums.CardValue
import br.com.zg.pokerhand.models.Card

class Utils {
	static List<Card> getCardsFromString(String cardsString){
		List<Card> cards = []
		ArrayList<String> tokkenizedCards = cardsString.tokenize(' ')

		for (String cardStr: tokkenizedCards){
			Card card = new Card()
			card.suit = Enum.valueOf(CardSuit, cardStr[cardStr.length()-1].toUpperCase())
			card.description = cardStr.substring(0, cardStr.length()-1)
			card.value = getCardValue(card.description)

			cards << card
		}

		return cards
	}

	static CardValue getCardValue(String description){
		if (isNumber(description)){
			CardValue.values().find {it.value == Integer.parseInt(description)}
		}else{
			CardValue.values().find {it.toString() == description.toUpperCase()}
		}
	}

	static boolean isNumber(String description){
		try {
			Integer.parseInt(description)
			return true
		} catch (NumberFormatException e) {
			return false
		}
	}
}
