package br.com.zg.pokerhand.categories

import br.com.zg.pokerhand.interfaces.CategoryStrategy
import br.com.zg.pokerhand.interfaces.FiveInSequenceStrategy
import br.com.zg.pokerhand.models.Board
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player

import static br.com.zg.pokerhand.categories.RoyalFlush.checkValueAndNaipe

class StraightFlush implements CategoryStrategy, FiveInSequenceStrategy {

	@Override
	Boolean isMatch(List<Card> cards) {
		return theresFiveInSequence(cards)
	}

	@Override
	void calculateScoreToUnDraw(Player player, Board board) {

	}

	@Override
	Boolean theresFiveInSequence(List<Card> cards) {
		List<Card> sortedByValue = cards.sort { it.value }

		return checkValueAndNaipe(sortedByValue.subList(0, 5)) ||
				checkValueAndNaipe(sortedByValue.subList(1, 6)) ||
				checkValueAndNaipe(sortedByValue.subList(2, 7))
	}

}
