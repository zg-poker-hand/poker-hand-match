package br.com.zg.pokerhand.interfaces

import br.com.zg.pokerhand.models.Card

interface FiveInSequenceStrategy {

	Boolean theresFiveInSequence(List<Card> cards)

}
