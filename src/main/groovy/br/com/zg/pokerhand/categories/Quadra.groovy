package br.com.zg.pokerhand.categories


import br.com.zg.pokerhand.interfaces.CategoryStrategy
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player

class Quadra implements CategoryStrategy {


	@Override
	Boolean isMatch(List<Card> cards) {
		Map mapCards = cards.groupBy { Card card -> card.value }
		if (mapCards.any { it.value.size() == 4 }) {
			return true
		}
		return false
	}

	@Override
	List<Player> unDraw(List<Player> players) {

	}

}
