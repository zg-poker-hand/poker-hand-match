package br.com.zg.pokerhand.context

import br.com.zg.pokerhand.interfaces.CategoryStrategy
import br.com.zg.pokerhand.models.Card

class Context {

	private CategoryStrategy strategy

	Context(CategoryStrategy strategy) {
		this.strategy = strategy
	}

	Boolean executeStrategy(List<Card> cards) {
		return strategy.isMatch(cards)
	}
}
