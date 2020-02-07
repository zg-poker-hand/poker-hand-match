package br.com.zg.pokerhand.categories

import br.com.zg.pokerhand.models.Board
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player

class RoyalFlush extends Sequencia {

	@Override
	Boolean isMatch(List<Card> cards) {
		return someWithDiffNaipe(cards) && fiveInSequence(cards)
	}

	@Override
	void calculateScoreToUnDraw(Player player, Board board) {

	}

}
