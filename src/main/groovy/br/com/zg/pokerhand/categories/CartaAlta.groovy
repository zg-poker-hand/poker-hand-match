package br.com.zg.pokerhand.categories

import br.com.zg.pokerhand.interfaces.CategoryStrategy
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player

class CartaAlta implements CategoryStrategy {

	@Override
	Boolean isMatch(List<Card> cards) {
		return true
	}

	@Override
	void getScoreToUnDraw(Player players) {

	}

}

