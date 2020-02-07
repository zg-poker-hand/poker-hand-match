package br.com.zg.pokerhand.categories


import br.com.zg.pokerhand.interfaces.CategoryStrategy
import br.com.zg.pokerhand.models.Board
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player

class UmPar implements CategoryStrategy {

	@Override
	Boolean isMatch(List<Card> cards) {
		Map mapCards = cards.groupBy { Card card -> card.value }
		if (mapCards.size() == 6) {
			return true
		}
		return false
	}

	@Override
	void calculateScoreToUnDraw(Player player, Board board) {
		List<Card> allCards = board.cards + player.cards
		Map groupCards = allCards.groupBy { it.value.value }
		if (groupCards.find { it.value }) {
			List<Card> cardsInPair = groupCards.find { it.value.size() == 2 }?.value as List<Card>
			Long score = 0
			List<Card> comparisonCards = []
			if(cardsInPair){
				allCards.removeAll(cardsInPair)
				allCards.sort { Card card -> card.getValue() }
				comparisonCards = allCards.subList(2, 5) + cardsInPair
			}
			int n = 0
			for (card in comparisonCards) {
				score += card.getValue().getValue() * (14**n)
				n++
			}
			player.points = score
		}
	}

}
