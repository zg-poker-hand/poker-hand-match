package br.com.zg.pokerhand.interfaces

import br.com.zg.pokerhand.models.Card

interface FiveInSequenceStrategy {

	List<Card> fiveInSequence(List<Card> cards)

}
