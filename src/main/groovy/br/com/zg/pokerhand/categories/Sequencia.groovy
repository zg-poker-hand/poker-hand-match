package br.com.zg.pokerhand.categories

import br.com.zg.pokerhand.combinations.SequentialCombination
import br.com.zg.pokerhand.interfaces.CategoryStrategy
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player

class Sequencia implements CategoryStrategy {


	@Override
	Boolean isMatch(List<Card> cards) {
		return new SequentialCombination().isMatch(cards)
	}

	@Override
	List<Player> unDraw(List<Player> players) {

	}

}
