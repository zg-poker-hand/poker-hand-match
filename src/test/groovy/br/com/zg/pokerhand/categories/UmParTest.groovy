package br.com.zg.pokerhand.categories

import br.com.zg.pokerhand.enums.CardSuit
import br.com.zg.pokerhand.enums.CardValue
import br.com.zg.pokerhand.models.Board
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player
import spock.lang.Specification
import spock.lang.Unroll

class UmParTest extends Specification {
	void setup() {
	}

	@Unroll
	def "IsMatch - #expectedResult"() {
		given:
		UmPar umPar = new UmPar()

		when:
		Boolean result = umPar.isMatch(list)

		then:
		result == expectedResult

		where:
		list            | expectedResult
		createPair()    | true
		createNoPair1() | false
		createNoPair2() | false

	}


	def "calculateScoreToUnDraw - #expectedResult"() {
		given:
		UmPar umPar = new UmPar()
		Board board = new Board(cards: createBoard())
		Player player1 = new Player(cards: createPair1())
		Player player2 = new Player(cards: createPair2())

		when:
		umPar.calculateScoreToUnDraw(player1, board)
		umPar.calculateScoreToUnDraw(player2, board)

		then:
		player1.points < player2.points

	}

	List<Card> createPair() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.TRES),
				new Card(suit: CardSuit.C, value: CardValue.NOVE),
				new Card(suit: CardSuit.C, value: CardValue.QUATRO),
				new Card(suit: CardSuit.C, value: CardValue.CINCO),
				new Card(suit: CardSuit.C, value: CardValue.SEIS)
		]
	}

	List<Card> createPair1() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.SETE),
				new Card(suit: CardSuit.C, value: CardValue.NOVE)
		]
	}

	List<Card> createPair2() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.Q),
				new Card(suit: CardSuit.C, value: CardValue.NOVE)
		]
	}


	List<Card> createBoard() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.TRES),
				new Card(suit: CardSuit.C, value: CardValue.NOVE),
				new Card(suit: CardSuit.C, value: CardValue.CINCO),
				new Card(suit: CardSuit.C, value: CardValue.Q)
		]
	}

	List<Card> createNoPair1() {
		return [
				new Card(suit: CardSuit.D, value: CardValue.DOIS),
				new Card(suit: CardSuit.D, value: CardValue.DOIS),
				new Card(suit: CardSuit.D, value: CardValue.QUATRO),
				new Card(suit: CardSuit.D, value: CardValue.CINCO),
				new Card(suit: CardSuit.D, value: CardValue.SEIS),
				new Card(suit: CardSuit.D, value: CardValue.SETE),
				new Card(suit: CardSuit.D, value: CardValue.NOVE)
		]
	}

	List<Card> createNoPair2() {
		return [
				new Card(suit: CardSuit.D, value: CardValue.DOIS),
				new Card(suit: CardSuit.D, value: CardValue.TRES),
				new Card(suit: CardSuit.D, value: CardValue.TRES),
				new Card(suit: CardSuit.D, value: CardValue.CINCO),
				new Card(suit: CardSuit.D, value: CardValue.J),
				new Card(suit: CardSuit.D, value: CardValue.Q),
				new Card(suit: CardSuit.D, value: CardValue.T)
		]
	}
}
