package br.com.zg.pokerhand.categories


import br.com.zg.pokerhand.interfaces.CategoryStrategy
import br.com.zg.pokerhand.models.Board
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player

class FullHouse implements CategoryStrategy {

	@Override
	Boolean isMatch(List<Card> cards) {
		Map mapCards = cards.groupBy { Card card -> card.value }

		if (mapCards.any { it.value.size() == 2 } && mapCards.any { it.value.size() == 3 }) {
			return true
		}
		if (mapCards.size() == 3) {
			return true
		}

		return false

	}

	@Override
	void calculateScoreToUnDraw(Player player, Board board) {
		List<Card> allCards = board.cards + player.cards
		Map mapCards = allCards.groupBy { Card card -> card.value.value }
		List<Card> threeCards = mapCards.findAll {it.value.size() == 3}.values() as List<Card>
		Card card1
		Card card2
		if (threeCards.size() > 3){
			threeCards.sort { it.value.value }
			card1 = threeCards.max{ it.value.value }
			card2 = threeCards.min{ it.value.value }

		}else{
			List<Card> twoCards = mapCards.findAll {it.value.size() == 2}.values() as List<Card>
			card1 = threeCards.first().first()
			card2 = twoCards.max{ it.value.value }.first()

		}
		Long score = card1.value.value * 14 + card2.value.value
		player.points = score
	}

}
