package br.com.zg.pokerhand.combinations

import br.com.zg.pokerhand.interfaces.ICombination
import br.com.zg.pokerhand.models.Card

class FlushCombination implements ICombination {

	@Override
	Boolean isMatch(List<Card> cards) {
		Map mapCards = cards.groupBy { Card card -> card.suit }
		if (mapCards.any { it.value.size() >= 5 }) {
			return true
		}
		return false
	}
}