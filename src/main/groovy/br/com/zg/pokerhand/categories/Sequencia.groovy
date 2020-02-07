package br.com.zg.pokerhand.categories


import br.com.zg.pokerhand.interfaces.CategoryStrategy
import br.com.zg.pokerhand.models.Board
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player

class Sequencia implements CategoryStrategy {

	private static MIN_SEQUENTIAL_REQUIRED = 5

	@Override
	Boolean isMatch(List<Card> cards) {
		return cards.size() >= MIN_SEQUENTIAL_REQUIRED && someWithDiffNaipe(cards) && fiveInSequence(cards)
	}

	@Override
	void calculateScoreToUnDraw(Player players, Board board) {

	}

	private static Boolean someWithDiffNaipe(List<Card> cards) {
		return cards?.any { it.suit != cards[0].suit }
	}

	private static Boolean fiveInSequence(List<Card> cards) {
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
