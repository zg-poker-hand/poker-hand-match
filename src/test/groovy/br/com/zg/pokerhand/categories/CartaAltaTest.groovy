package br.com.zg.pokerhand.categories

import br.com.zg.pokerhand.enums.CardSuit
import br.com.zg.pokerhand.enums.CardValue
import br.com.zg.pokerhand.models.Board
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class CartaAltaTest {

	List<Card> cards
	Player player1
	Player player2
	Board board

	@Before
	void carregarDados(){
		cards = new ArrayList<>()
		cards.add(new Card(CardValue.A, "as", CardSuit.C))
		cards.add(new Card(CardValue.K, "as", CardSuit.C))
		cards.add(new Card(CardValue.Q, "as", CardSuit.C))
		cards.add(new Card(CardValue.J, "as", CardSuit.C))
		cards.add(new Card(CardValue.T, "as", CardSuit.C))
		cards.add(new Card(CardValue.NOVE, "as", CardSuit.C))
		cards.add(new Card(CardValue.OITO, "as", CardSuit.C))
		cards.add(new Card(CardValue.SETE, "as", CardSuit.C))
		cards.add(new Card(CardValue.SEIS, "as", CardSuit.C))
		cards.add(new Card(CardValue.CINCO, "as", CardSuit.C))
		cards.add(new Card(CardValue.QUATRO, "as", CardSuit.C))
		cards.add(new Card(CardValue.TRES, "as", CardSuit.C))
		cards.add(new Card(CardValue.DOIS, "as", CardSuit.C))

		player1 = new Player()
		player2 = new Player()
		board = new Board()
	}

	@Test
	void calculateScoreTest(){
		CartaAlta cartaAlta = new CartaAlta()
		board.cards.add(cards.get(0))
		board.cards.add(cards.get(3))
		board.cards.add(cards.get(4))
		board.cards.add(cards.get(5))
		board.cards.add(cards.get(7))

		player1.cards.add(cards.get(2))
		player1.cards.add(cards.get(8))

		player2.cards.add(cards.get(1))
		player2.cards.add(cards.get(8))

		Long score1 = cartaAlta.calculateScoreToUnDraw(player1, board)
		Long score2 = cartaAlta.calculateScoreToUnDraw(player2, board)
		Assert.assertEquals(score1 < score2)
	}
}
