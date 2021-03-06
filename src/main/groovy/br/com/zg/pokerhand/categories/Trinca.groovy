package br.com.zg.pokerhand.categories


import br.com.zg.pokerhand.interfaces.CategoryStrategy
import br.com.zg.pokerhand.models.Board
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player

class Trinca implements CategoryStrategy {

	@Override
	Boolean isMatch(List<Card> cards) {
		Map mapCards = cards.groupBy { Card card -> card.value }
		if (mapCards.any { it.value.size() == 3 }) {
			return true
		}
		return false
	}

	@Override
	void calculateScoreToUnDraw(Player player, Board board) {
		List<Card> allCards = board.cards + player.cards
		allCards.sort { Card card -> card.getValue() }
		Map groupCards = allCards.groupBy { it.value.value }
		List<Card> cardsInPair = groupCards.findAll { it.value.size() == 3 }.values().flatten() as List<Card>
		allCards.removeAll(cardsInPair)
		List<Card> comparisonCards = allCards.subList(2, 4) + cardsInPair
		Long score = 0
		int n = 0
		for (card in comparisonCards) {
			score += card.getValue().getValue() * (14**n)
			n++
		}
		player.points = score
	}
}
