package br.com.zg.pokerhand.categories

import br.com.zg.pokerhand.combinations.DoublePairCombination
import br.com.zg.pokerhand.interfaces.CategoryStrategy
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player

class DoisPares implements CategoryStrategy {


	@Override
	Boolean isMatch(List<Card> cards) {
		return new DoublePairCombination().isMatch(cards)
	}

	@Override
	List<Player> unDraw(List<Player> players) {
		
	}

}
