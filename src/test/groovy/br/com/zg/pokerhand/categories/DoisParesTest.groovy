package br.com.zg.pokerhand.combinations

import br.com.zg.pokerhand.categories.DoisPares
import br.com.zg.pokerhand.enums.CardSuit
import br.com.zg.pokerhand.enums.CardValue
import br.com.zg.pokerhand.models.Card
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
