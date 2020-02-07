package br.com.zg.pokerhand.interfaces

import br.com.zg.pokerhand.models.Card

interface ICombination {

	Boolean isMatch(List<Card> cards)

}
