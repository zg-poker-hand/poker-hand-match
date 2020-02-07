package br.com.zg.pokerhand.combinations

import br.com.zg.pokerhand.interfaces.ICombination
import br.com.zg.pokerhand.models.Card

class Sequential implements ICombination {

	@Override
	Boolean isMatch(List<Card> cards) {
		return !sameNaipe(cards) && fiveInSequence(cards)
	}

	private static Boolean sameNaipe(List<Card> cards) {
		return cards?.every { it.suit == cards[0].suit }
	}

	private static Boolean fiveInSequence(List<Card> cards) {
		return cards?.eachWithIndex { card, index ->
			card.value == card[index + 1] + 1
		}
	}
}
