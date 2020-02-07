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
	void calculateScoreToUnDraw(Player player, Board board) {
		List<Card> allCards = board.cards + player.cards
		allCards.sort { Card card -> card.value.value }
		Map groupCards = allCards.groupBy { it.suit }
		List<Card> cardsInFlush = groupCards.findAll { it.value.size() >= 5 }.values().flatten() as List<Card>
		int sizeFlush = cardsInFlush.size()
		if (sizeFlush > 1) {
			List<Card> comparisonCards = cardsInFlush.subList(sizeFlush - 5, sizeFlush)
			Long score = 0
			int n = 0
			for (card in comparisonCards) {
				score += card.getValue().getValue() * (14**n)
				n++
			}
			player.points = score
		}
	}

}
