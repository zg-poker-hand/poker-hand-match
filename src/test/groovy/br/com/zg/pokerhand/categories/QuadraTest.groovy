package br.com.zg.pokerhand.categories

import br.com.zg.pokerhand.enums.CardSuit
import br.com.zg.pokerhand.enums.CardValue
import br.com.zg.pokerhand.models.Board
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player
import spock.lang.Specification
import spock.lang.Unroll

class QuadraTest extends Specification {
	void setup() {
	}

	@Unroll
	def "IsMatch - #expectedResult"() {
		given:
		Quadra quadra = new Quadra()

		when:
		Boolean result = quadra.isMatch(list)

		then:
		result == expectedResult

		where:
		list            | expectedResult
		createQuadra()    | true
		createNoQuadra1() | false
		createNoQuadra2() | false

	}

	def "calculateScoreToUnDraw - #expectedResult"() {
		given:
		Quadra quadra = new Quadra()
		Board board = new Board(cards: createBoard() )
		Player player1 = new Player(cards: createPair1())
		Player player2 = new Player(cards: createPair2())

		when:
		quadra.calculateScoreToUnDraw(player1, board)
		quadra.calculateScoreToUnDraw(player2, board)

		then:
		player1.points < player2.points

	}

	List<Card> createQuadra() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.QUATRO),
				new Card(suit: CardSuit.C, value: CardValue.CINCO),
				new Card(suit: CardSuit.C, value: CardValue.SETE),
		]
	}

	List<Card> createBoard() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.TRES),
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.CINCO),
		]
	}


	List<Card> createPair1() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.SETE)
		]
	}

	List<Card> createPair2() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.NOVE)
		]
	}

	List<Card> createNoQuadra1() {
		return [
				new Card(suit: CardSuit.D, value: CardValue.DOIS),
				new Card(suit: CardSuit.D, value: CardValue.T),
				new Card(suit: CardSuit.D, value: CardValue.QUATRO),
				new Card(suit: CardSuit.D, value: CardValue.CINCO),
				new Card(suit: CardSuit.D, value: CardValue.SEIS),
				new Card(suit: CardSuit.D, value: CardValue.SETE),
				new Card(suit: CardSuit.D, value: CardValue.NOVE)
		]
	}

	List<Card> createNoQuadra2() {
		return [
				new Card(suit: CardSuit.D, value: CardValue.DOIS),
				new Card(suit: CardSuit.D, value: CardValue.QUATRO),
				new Card(suit: CardSuit.D, value: CardValue.A),
				new Card(suit: CardSuit.D, value: CardValue.CINCO),
				new Card(suit: CardSuit.D, value: CardValue.J),
				new Card(suit: CardSuit.D, value: CardValue.Q),
				new Card(suit: CardSuit.D, value: CardValue.T)
		]
	}


}
