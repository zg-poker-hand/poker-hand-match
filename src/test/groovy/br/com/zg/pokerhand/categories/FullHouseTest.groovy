package br.com.zg.pokerhand.categories

import br.com.zg.pokerhand.enums.CardSuit
import br.com.zg.pokerhand.enums.CardValue
import br.com.zg.pokerhand.models.Card
import spock.lang.Specification
import spock.lang.Unroll

class FullHouseTest extends Specification {
	void setup() {
	}

	@Unroll
	def "IsMatch - #expectedResult"() {
		given:
		FullHouse fullHouse = new FullHouse()

		when:
		Boolean result = fullHouse.isMatch(list)

		then:
		result == expectedResult

		where:
		list                 | expectedResult
		createFullHouse()    | true
		createNoFullHouse1() | false
		createNoFullHouse2() | false

	}

	List<Card> createFullHouse() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.QUATRO),
				new Card(suit: CardSuit.C, value: CardValue.QUATRO),
				new Card(suit: CardSuit.C, value: CardValue.CINCO),
				new Card(suit: CardSuit.C, value: CardValue.SEIS)
		]
	}

	List<Card> createNoFullHouse1() {
		return [
				new Card(suit: CardSuit.D, value: CardValue.DOIS),
				new Card(suit: CardSuit.D, value: CardValue.DOIS),
				new Card(suit: CardSuit.D, value: CardValue.TRES),
				new Card(suit: CardSuit.D, value: CardValue.TRES),
				new Card(suit: CardSuit.D, value: CardValue.SEIS),
				new Card(suit: CardSuit.D, value: CardValue.SETE),
				new Card(suit: CardSuit.D, value: CardValue.NOVE)
		]
	}

	List<Card> createNoFullHouse2() {
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
