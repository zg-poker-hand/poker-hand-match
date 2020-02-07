package br.com.zg.pokerhand.categories


import br.com.zg.pokerhand.interfaces.CategoryStrategy
import br.com.zg.pokerhand.interfaces.FiveInSequenceStrategy
import br.com.zg.pokerhand.models.Board
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player

class Sequencia implements CategoryStrategy, FiveInSequenceStrategy {

	private static MIN_SEQUENTIAL_REQUIRED = 5

	@Override
	Boolean isMatch(List<Card> cards) {
		return cards.size() >= MIN_SEQUENTIAL_REQUIRED && someWithDiffNaipe(cards) && fiveInSequence(cards)
	}

	@Override
	void calculateScoreToUnDraw(Player player, Board board) {

	}

	static Boolean someWithDiffNaipe(List<Card> cards) {
		return cards?.any { it.suit != cards[0].suit }
	}

	@Override
	List<Card> fiveInSequence(List<Card> cards) {
		int sequentialRequired = 1
		Boolean sequenceFounded = false
		List<Card> sortedCards = cards?.sort { it.value }


		sortedCards.eachWithIndex { card, index ->
			if (index < cards.size() - 1) {
				if (card.value.value + 1 == sortedCards[index + 1].value.value) {
					sequentialRequired++

					if (sequentialRequired == MIN_SEQUENTIAL_REQUIRED) {
						sequenceFounded = true
					}
				} else {
					sequentialRequired = 1
				}
			}
		}

		return sequenceFounded
	}


}
