package br.com.zg.pokerhand.categories

import br.com.zg.pokerhand.enums.CardSuit
import br.com.zg.pokerhand.enums.CardValue
import br.com.zg.pokerhand.models.Board
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player
import spock.lang.Specification
import spock.lang.Unroll

class SequenciaTest extends Specification {
	@Unroll
	def "IsMatch - #result"() {
		given:
		Sequencia sequential = new Sequencia()

		when:
		Boolean match = sequential.isMatch(list)

		then:
		match == result

		where:
		result | list
		false  | createDifferentNumberCards()
		true   | createSameNaipeCards()
		true   | createMatchCards()
	}

	def "calculateScoreToUnDraw - #expectedResult"() {
		given:
		Sequencia sequencia = new Sequencia()
		Board board = new Board(cards: createBoard())
		Player player1 = new Player(cards: createCardsPlayer1())
		Player player2 = new Player(cards: createCardsPlayer2())

		when:
		sequencia.calculateScoreToUnDraw(player1, board)
		sequencia.calculateScoreToUnDraw(player2, board)

		then:
		player1.points > player2.points

	}

	List<Card> createCardsPlayer1() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.Q),
				new Card(suit: CardSuit.C, value: CardValue.SETE)
		]
	}

	List<Card> createCardsPlayer2() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.Q),
				new Card(suit: CardSuit.C, value: CardValue.DOIS)
		]
	}

	List<Card> createBoard() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.J),
				new Card(suit: CardSuit.C, value: CardValue.TRES),
				new Card(suit: CardSuit.C, value: CardValue.QUATRO),
				new Card(suit: CardSuit.C, value: CardValue.CINCO),
				new Card(suit: CardSuit.C, value: CardValue.SEIS)
		]
	}

	List<Card> createDifferentNumberCards() {
		return [
				new Card(suit: CardSuit.D, value: CardValue.DOIS),
				new Card(suit: CardSuit.D, value: CardValue.T),
				new Card(suit: CardSuit.D, value: CardValue.TRES),
				new Card(suit: CardSuit.D, value: CardValue.QUATRO),
				new Card(suit: CardSuit.D, value: CardValue.CINCO),
				new Card(suit: CardSuit.D, value: CardValue.A),
				new Card(suit: CardSuit.D, value: CardValue.Q),
		]
	}

	List<Card> createSameNaipeCards() {
		return [
				new Card(suit: CardSuit.D, value: CardValue.DOIS),
				new Card(suit: CardSuit.D, value: CardValue.DOIS),
				new Card(suit: CardSuit.D, value: CardValue.TRES),
				new Card(suit: CardSuit.D, value: CardValue.QUATRO),
				new Card(suit: CardSuit.D, value: CardValue.CINCO),
				new Card(suit: CardSuit.D, value: CardValue.SEIS),
				new Card(suit: CardSuit.D, value: CardValue.SETE),
		]
	}

	List<Card> createMatchCards() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.SETE),
				new Card(suit: CardSuit.D, value: CardValue.TRES),
				new Card(suit: CardSuit.D, value: CardValue.QUATRO),
				new Card(suit: CardSuit.D, value: CardValue.CINCO),
				new Card(suit: CardSuit.D, value: CardValue.SEIS),
				new Card(suit: CardSuit.C, value: CardValue.SETE),
				new Card(suit: CardSuit.D, value: CardValue.DOIS),
		]
	}
}
