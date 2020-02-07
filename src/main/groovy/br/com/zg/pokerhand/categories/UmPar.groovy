package br.com.zg.pokerhand.categories

import br.com.zg.pokerhand.combinations.PairCombination
import br.com.zg.pokerhand.interfaces.CategoryStrategy
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player

class UmPar implements CategoryStrategy {


	@Override
	Boolean isMatch(List<Card> cards) {
		return new PairCombination().isMatch(cards)
	}

	@Override
	List<Player> unDraw(List<Player> players) {

	}

}
