package br.com.zg.pokerhand.interfaces

import br.com.zg.pokerhand.models.Card

interface FiveInSequenceStrategy {

	Boolean fiveInSequence(List<Card> cards)

}
