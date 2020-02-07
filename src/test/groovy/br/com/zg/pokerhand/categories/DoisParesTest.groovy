package br.com.zg.pokerhand.combinations

import br.com.zg.pokerhand.categories.DoisPares
import br.com.zg.pokerhand.enums.CardSuit
import br.com.zg.pokerhand.enums.CardValue
import br.com.zg.pokerhand.models.Board
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Player
import spock.lang.Specification
import spock.lang.Unroll

class DoisParesTest extends Specification {

	void setup() {
	}

	@Unroll
	def "IsMatch - #expectedResult"() {
		given:
		DoisPares doisPares = new DoisPares()

		when:
		Boolean result = doisPares.isMatch(list)

		then:
		result == expectedResult

		where:
		list                  | expectedResult
		createDoublePair()    | true
		createNoDoublePair1() | false
		createNoDoublePair2() | false

	}


	def "calculateScoreToUnDraw - #expectedResult"() {
		given:
		DoisPares doisPares = new DoisPares()
		Board board = new Board(cards: createBoard())
		Player player1 = new Player(cards: createCardsPlayer1())
		Player player2 = new Player(cards: createCardsPlayer2())

		when:
		doisPares.calculateScoreToUnDraw(player1, board)
		doisPares.calculateScoreToUnDraw(player2, board)

		then:
		player1.points < player2.points

	}

	List<Card> createCardsPlayer1() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.Q),
				new Card(suit: CardSuit.C, value: CardValue.DOIS)
		]
	}

	List<Card> createCardsPlayer2() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.Q),
				new Card(suit: CardSuit.C, value: CardValue.CINCO)
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

	List<Card> createDoublePair() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.TRES),
				new Card(suit: CardSuit.C, value: CardValue.TRES),
				new Card(suit: CardSuit.C, value: CardValue.QUATRO),
				new Card(suit: CardSuit.C, value: CardValue.CINCO),
				new Card(suit: CardSuit.C, value: CardValue.SEIS)
		]
	}

	List<Card> createNoDoublePair1() {
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

	List<Card> createNoDoublePair2() {
		return [
				new Card(suit: CardSuit.D, value: CardValue.DOIS),
				new Card(suit: CardSuit.D, value: CardValue.QUATRO),
				new Card(suit: CardSuit.D, value: CardValue.QUATRO),
				new Card(suit: CardSuit.D, value: CardValue.CINCO),
				new Card(suit: CardSuit.D, value: CardValue.CINCO),
				new Card(suit: CardSuit.D, value: CardValue.CINCO),
				new Card(suit: CardSuit.D, value: CardValue.T)
		]
	}

}
