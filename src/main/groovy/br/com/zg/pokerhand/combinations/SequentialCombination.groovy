package br.com.zg.pokerhand.combinations

import br.com.zg.pokerhand.interfaces.ICombination
import br.com.zg.pokerhand.models.Card

class SequentialCombination implements ICombination {

	private static MIN_SEQUENTIAL_REQUIRED = 5

	@Override
	Boolean isMatch(List<Card> cards) {
		return cards.size() >= MIN_SEQUENTIAL_REQUIRED && !someWithDiffNaipe(cards) && fiveInSequence(cards)
	}

	private static Boolean someWithDiffNaipe(List<Card> cards) {
		return cards?.any { it.suit == cards[0].suit }
	}

	private static Boolean fiveInSequence(List<Card> cards) {
		return cards?.eachWithIndex { card, index ->
			card.value == card[index + 1] + 1
		}
	}
}
