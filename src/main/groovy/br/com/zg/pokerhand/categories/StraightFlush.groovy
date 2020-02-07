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
		List<Card> allCards = board.cards + player.cards
		List<Card> cardsSequential = []
		List<Card> sortedCards = allCards?.sort { it.value }
		int sequentialRequired = 1
		Boolean sequenceFounded = false

		sortedCards.eachWithIndex { card, index ->
			if (index < allCards.size() - 1) {
				if (card.value.value + 1 == sortedCards[index + 1].value.value &&
						card.suit == sortedCards[index + 1].suit &&
						!sequenceFounded) {
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
		List<Card> sortedByValue = cards.sort { it.value }

		return checkValueAndNaipe(sortedByValue.subList(0, 5)) ||
				checkValueAndNaipe(sortedByValue.subList(1, 6)) ||
				checkValueAndNaipe(sortedByValue.subList(2, 7))
	}

}
