package br.com.zg.pokerhand.categories

import br.com.zg.pokerhand.enums.CardSuit
import br.com.zg.pokerhand.enums.CardValue
import br.com.zg.pokerhand.models.Card
import spock.lang.Specification
import spock.lang.Unroll

class RoyalFlushTest extends Specification {

	@Unroll
	def "IsMatch"() {
		given:
		RoyalFlush royalFlush = new RoyalFlush()

		then:
		royalFlush.isMatch(list)

		where:
		result | list
		false  | createDifferentNumberCards()
		false  | createDifferentNaipeCards()
		true   | createMatchCards()
	}

	List<Card> createDifferentNumberCards() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
		]
	}

	List<Card> createDifferentNaipeCards() {
		return [
				new Card(suit: CardSuit.S, value: CardValue.T),
				new Card(suit: CardSuit.C, value: CardValue.J),
				new Card(suit: CardSuit.D, value: CardValue.Q),
				new Card(suit: CardSuit.H, value: CardValue.K),
				new Card(suit: CardSuit.D, value: CardValue.DOIS),
				new Card(suit: CardSuit.D, value: CardValue.SETE),
		]
	}

	List<Card> createMatchCards() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.T),
				new Card(suit: CardSuit.D, value: CardValue.J),
				new Card(suit: CardSuit.D, value: CardValue.Q),
				new Card(suit: CardSuit.D, value: CardValue.K),
				new Card(suit: CardSuit.D, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.SETE),
				new Card(suit: CardSuit.D, value: CardValue.A),
		]
	}
}
