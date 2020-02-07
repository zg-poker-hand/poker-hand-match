package br.com.zg.pokerhand.categories

import br.com.zg.pokerhand.interfaces.CategoryStrategy
import br.com.zg.pokerhand.interfaces.FiveInSequenceStrategy
import br.com.zg.pokerhand.models.Board
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player

class RoyalFlush implements CategoryStrategy, FiveInSequenceStrategy {

	@Override
	Boolean isMatch(List<Card> cards) {
		return fiveInSequence(cards)
	}

	@Override
	void calculateScoreToUnDraw(Player player, Board board) {

	}

	@Override
	Boolean fiveInSequence(List<Card> cards) {
		List<Card> sortedByValue = cards.sort { it.value }

		return sortedByValue.subList(0, 4) ||
				sortedByValue.subList(1, 5) ||
				sortedByValue.subList(2, 6)
	}

	static checkValueAndNaipe(List<Card> cards) {
		return true
	}

	static Boolean someWithDiffNaipe(List<Card> cards) {
		return cards?.any { it.suit != cards[0].suit }
	}

}
