package br.com.zg.pokerhand.categories


import br.com.zg.pokerhand.interfaces.CategoryStrategy
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player

class DoisPares implements CategoryStrategy {

	@Override
	Boolean isMatch(List<Card> cards) {
		Map mapCards = cards.groupBy { Card card -> card.value }
		if (mapCards.size() == 5 && mapCards.any { it.value.size() == 2 }) {
			return true
		}
		return false
	}

	@Override
	void calculateScoreToUnDraw(Player players) {

	}

}
