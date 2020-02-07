package br.com.zg.pokerhand.categories

import br.com.zg.pokerhand.enums.CardValue
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

		return sortedByValue.last().value == CardValue.A &&
				checkValueAndNaipe(sortedByValue.subList(2, 7))
	}

	static Boolean checkValueAndNaipe(List<Card> cards) {
		Boolean result = true
		cards.eachWithIndex { card, index ->
			if (cards.indexOf(card) + 1 != cards.size() && result) {
				result = card.value.value + 1 == cards[index + 1].value.value && card.suit == cards.last().suit
			}
		}

		return result
	}

}
