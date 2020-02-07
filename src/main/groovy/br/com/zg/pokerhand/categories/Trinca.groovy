package br.com.zg.pokerhand.categories

import br.com.zg.pokerhand.combinations.TrincaCombination
import br.com.zg.pokerhand.interfaces.CategoryStrategy
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player

class Trinca implements CategoryStrategy {


	@Override
	Boolean isMatch(List<Card> cards) {
		return new TrincaCombination().isMatch(cards)
	}

	@Override
	List<Player> unDraw(List<Player> players) {

	}

}
