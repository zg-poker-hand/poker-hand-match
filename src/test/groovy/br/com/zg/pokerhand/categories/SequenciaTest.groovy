package br.com.zg.pokerhand.categories

import br.com.zg.pokerhand.enums.CardSuit
import br.com.zg.pokerhand.enums.CardValue
import br.com.zg.pokerhand.models.Card
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
		false  | createSameNaipeCards()
		true   | createMatchCards()
	}

	List<Card> createDifferentNumberCards() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
		]
	}

	List<Card> createSameNaipeCards() {
		return [
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
