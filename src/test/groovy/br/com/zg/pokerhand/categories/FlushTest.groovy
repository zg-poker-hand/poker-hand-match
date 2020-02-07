package br.com.zg.pokerhand.categories

import br.com.zg.pokerhand.enums.CardSuit
import br.com.zg.pokerhand.enums.CardValue
import br.com.zg.pokerhand.models.Board
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player
import spock.lang.Specification
import spock.lang.Unroll

class FlushTest extends Specification {
	void setup() {
	}

	@Unroll
	def "IsMatch - #expectedResult"() {
		given:
		Flush flush = new Flush()

		when:
		Boolean result = flush.isMatch(list)

		then:
		result == expectedResult

		where:
		list             | expectedResult
		createFlush()    | true
		createNoFlush1() | false
		createNoFlush2() | false

	}

	def "calculateScoreToUnDraw - #expectedResult"() {
		given:
		Flush flush = new Flush()
		Board board = new Board(cards: createBoard())
		Player player1 = new Player(cards: createCardsPlayer1())
		Player player2 = new Player(cards: createCardsPlayer2())

		when:
		flush.calculateScoreToUnDraw(player1, board)
		flush.calculateScoreToUnDraw(player2, board)

		then:
		player1.points > player2.points

	}

	List<Card> createCardsPlayer1() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.TRES),
				new Card(suit: CardSuit.H, value: CardValue.K)
		]
	}

	List<Card> createCardsPlayer2() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.TRES),
				new Card(suit: CardSuit.H, value: CardValue.J)
		]
	}

	List<Card> createBoard() {
		return [
				new Card(suit: CardSuit.H, value: CardValue.DOIS),
				new Card(suit: CardSuit.S, value: CardValue.TRES),
				new Card(suit: CardSuit.H, value: CardValue.TRES),
				new Card(suit: CardSuit.H, value: CardValue.CINCO),
				new Card(suit: CardSuit.H, value: CardValue.Q)
		]
	}
	

	List<Card> createFlush() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.TRES),
				new Card(suit: CardSuit.C, value: CardValue.NOVE),
				new Card(suit: CardSuit.C, value: CardValue.QUATRO),
				new Card(suit: CardSuit.H, value: CardValue.CINCO),
				new Card(suit: CardSuit.S, value: CardValue.SEIS)
		]
	}

	List<Card> createNoFlush1() {
		return [
				new Card(suit: CardSuit.D, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.T),
				new Card(suit: CardSuit.H, value: CardValue.QUATRO),
				new Card(suit: CardSuit.D, value: CardValue.CINCO),
				new Card(suit: CardSuit.C, value: CardValue.SEIS),
				new Card(suit: CardSuit.D, value: CardValue.SETE),
				new Card(suit: CardSuit.D, value: CardValue.NOVE)
		]
	}

	List<Card> createNoFlush2() {
		return [
				new Card(suit: CardSuit.D, value: CardValue.DOIS),
				new Card(suit: CardSuit.H, value: CardValue.QUATRO),
				new Card(suit: CardSuit.C, value: CardValue.A),
				new Card(suit: CardSuit.D, value: CardValue.CINCO),
				new Card(suit: CardSuit.C, value: CardValue.J),
				new Card(suit: CardSuit.C, value: CardValue.Q),
				new Card(suit: CardSuit.D, value: CardValue.T)
		]
	}
}
