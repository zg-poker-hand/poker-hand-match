package br.com.zg.pokerhand.combinations

import br.com.zg.pokerhand.enums.CardSuit
import br.com.zg.pokerhand.enums.CardValue
import br.com.zg.pokerhand.models.Card
import spock.lang.Specification
import spock.lang.Unroll

class PairSpec extends Specification {

	void setup() {
	}

	@Unroll
	def "IsMatch - #expectedResult"() {
		given:
		Pair pair = new Pair()

		when:
		Boolean result = pair.isMatch(list)

		then:
		result == expectedResult

		where:
		list            | expectedResult
		createPair()    | true
		createNoPair1() | false
		createNoPair2() | false

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

	List<Card> createNoPair1() {
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

	List<Card> createNoPair2() {
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
