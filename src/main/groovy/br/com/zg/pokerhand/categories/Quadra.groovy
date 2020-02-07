package br.com.zg.pokerhand.categories

import br.com.zg.pokerhand.combinations.QuadraCombination
import br.com.zg.pokerhand.interfaces.CategoryStrategy
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player

class Quadra implements CategoryStrategy {


	@Override
	Boolean isMatch(List<Card> cards) {
		return new QuadraCombination().isMatch(cards)
	}

	@Override
	List<Player> unDraw(List<Player> players) {

	}

}
