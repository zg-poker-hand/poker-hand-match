package br.com.zg.pokerhand.categories


import br.com.zg.pokerhand.interfaces.CategoryStrategy
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player

class FullHouse implements CategoryStrategy {

	@Override
	Boolean isMatch(List<Card> cards) {
		Map mapCards = cards.groupBy { Card card -> card.value }
		if (mapCards.any { it.value.size() == 2 } && mapCards.any { it.value.size() == 3 }) {
			return true
		}
		return false

	}

	@Override
	List<Player> unDraw(List<Player> players) {

	}

}
