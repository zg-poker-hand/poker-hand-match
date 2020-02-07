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
		return cards.size() >= MIN_SEQUENTIAL_REQUIRED && theresFiveInSequence(cards)
	}

	@Override
	void calculateScoreToUnDraw(Player player, Board board) {
		List<Card> allCards = board.cards + player.cards
		List<Card> cardsSequential = []
		List<Card> sortedCards = allCards?.sort { it.value }
		int sequentialRequired = 1
		Boolean sequenceFounded = false

		sortedCards.eachWithIndex { card, index ->
			if (index < allCards.size() - 1) {
				if (card.value.value + 1 == sortedCards[index + 1].value.value && !sequenceFounded) {
					cardsSequential.add(card)
					sequentialRequired++

					if (sequentialRequired == MIN_SEQUENTIAL_REQUIRED) {
						cardsSequential.add(sortedCards[index + 1])
						sequenceFounded = true
					}
				} else if (!sequenceFounded) {
					sequentialRequired = 1
					cardsSequential = []
				}
			}
		}

		int sizeFlush = cardsSequential.size()
		List<Card> comparisonCards = cardsSequential.subList(sizeFlush - 5, sizeFlush)
		Long score = 0
		int n = 0
		for (card in comparisonCards) {
			score += card.getValue().getValue() * (14**n)
			n++
		}
		player.points = score

	}

	@Override
	Boolean theresFiveInSequence(List<Card> cards) {
		int sequentialRequired = 1
		Boolean sequenceFounded = false
		List<Card> sortedCards = cards.sort { it.value }


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
