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
		allCards.sort { Card card -> card.getValue() }
		allCards = allCards.subList(2, 7)
		Long score = 0
		int n = 0
		for (card in allCards){
			score += card.getValue().getValue() * (14 ** n)
			n++
		}
		player.points = score
	}

}
