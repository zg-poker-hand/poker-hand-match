package br.com.zg.pokerhand.categories


import br.com.zg.pokerhand.interfaces.CategoryStrategy
import br.com.zg.pokerhand.models.Board
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player

class Flush implements CategoryStrategy {

	@Override
	Boolean isMatch(List<Card> cards) {
		Map mapCards = cards.groupBy { Card card -> card.suit }
		if (mapCards.any { it.value.size() >= 5 }) {
			return true
		}
		return false
	}

	@Override
	void calculateScoreToUnDraw(Player players, Board board) {

	}

}
