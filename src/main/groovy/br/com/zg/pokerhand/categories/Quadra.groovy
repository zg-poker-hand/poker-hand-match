package br.com.zg.pokerhand.categories


import br.com.zg.pokerhand.interfaces.CategoryStrategy
import br.com.zg.pokerhand.models.Board
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
	void calculateScoreToUnDraw(Player player, Board board) {
		List<Card> allCards = board.cards + player.cards
		Map mapCards = allCards.groupBy { Card card -> card.value.value }
		List<Card> cards = mapCards.find {it.value.size() == 4}.value as List<Card>
		allCards.removeAll(cards)
		Card card = allCards.max {it.value.value}
		Long score = card.value.value
		score += cards.first().value.value * 14
		player.points = score
	}

}
