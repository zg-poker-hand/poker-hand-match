package br.com.zg.pokerhand.interfaces

import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player

interface CategoryStrategy {

	Boolean isMatch(List<Card> cards)

	List<Player> getScoreToUnDraw(List<Player> players)

}
