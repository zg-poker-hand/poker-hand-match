package br.com.zg.pokerhand.context

import br.com.zg.pokerhand.interfaces.CategoryStrategy
import br.com.zg.pokerhand.models.Board
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player

class Context {

	private CategoryStrategy strategy

	Context(CategoryStrategy strategy) {
		this.strategy = strategy
	}

	Boolean executeMatchStrategy(List<Card> cards) {
		return strategy.isMatch(cards)
	}

	executeCalculateScoreToUnDraw(Player player, Board board) {
		strategy.calculateScoreToUnDraw(player, board)
	}
}
