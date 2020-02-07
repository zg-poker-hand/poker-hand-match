package br.com.zg.pokerhand.combinations

import br.com.zg.pokerhand.interfaces.ICombination
import br.com.zg.pokerhand.models.Card

class Trinca implements ICombination {

	@Override
	Boolean isMatch(List<Card> cards) {
		Map mapCards = cards.groupBy { Card card -> card.value }
		if (mapCards.any { it.value.size() == 3 }) {
			return true
		}
		return false
	}
}
