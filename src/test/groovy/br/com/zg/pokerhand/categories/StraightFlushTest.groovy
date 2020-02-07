package br.com.zg.pokerhand.categories

import br.com.zg.pokerhand.enums.CardSuit
import br.com.zg.pokerhand.enums.CardValue
import br.com.zg.pokerhand.models.Card
import spock.lang.Specification
import spock.lang.Unroll

class StraightFlushTest extends Specification {
	@Unroll
	def "IsMatch - #result"() {
		given:
		StraightFlush straightFlush = new StraightFlush()

		when:
		Boolean match = straightFlush.isMatch(list)

		then:
		match == result

		where:
		result | list
		true   | createDifferentNumberCards()
		false  | createDifferentNaipeCards()
		true   | createMatchCards()
	}

	List<Card> createDifferentNumberCards() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.S, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.TRES),
				new Card(suit: CardSuit.C, value: CardValue.QUATRO),
				new Card(suit: CardSuit.C, value: CardValue.CINCO),
				new Card(suit: CardSuit.C, value: CardValue.SEIS),
				new Card(suit: CardSuit.C, value: CardValue.SETE)
		]
	}

	List<Card> createDifferentNaipeCards() {
		return [
				new Card(suit: CardSuit.S, value: CardValue.T),
				new Card(suit: CardSuit.C, value: CardValue.J),
				new Card(suit: CardSuit.C, value: CardValue.Q),
				new Card(suit: CardSuit.C, value: CardValue.K),
				new Card(suit: CardSuit.C, value: CardValue.A),
				new Card(suit: CardSuit.C, value: CardValue.SEIS),
				new Card(suit: CardSuit.D, value: CardValue.SETE)
		]
	}

	List<Card> createMatchCards() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.T),
				new Card(suit: CardSuit.C, value: CardValue.J),
				new Card(suit: CardSuit.C, value: CardValue.Q),
				new Card(suit: CardSuit.C, value: CardValue.K),
				new Card(suit: CardSuit.C, value: CardValue.NOVE),
				new Card(suit: CardSuit.S, value: CardValue.SEIS),
				new Card(suit: CardSuit.H, value: CardValue.SETE)
		]
	}
}
