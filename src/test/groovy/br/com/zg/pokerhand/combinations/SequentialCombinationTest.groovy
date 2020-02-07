package br.com.zg.pokerhand.combinations

import br.com.zg.pokerhand.enums.CardSuit
import br.com.zg.pokerhand.enums.CardValue
import br.com.zg.pokerhand.models.Card
import spock.lang.Specification

class SequentialCombinationTest extends Specification {

	def "IsMatch - #result"() {
		given:
		SequentialCombination sequential = Mock(SequentialCombination)

		List<Card> differentNumberCards = createDifferentNumberCards()
		List<Card> sameNaipeCards = createSameNaipeCards()
		List<Card> matchCards = createMatchCards()

		when:
		Boolean match = sequential.isMatch(list)

		then:
		match == result

		where:
		result | list
		true   | matchCards
		false  | differentNumberCards
		false  | sameNaipeCards
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
				new Card(suit: CardSuit.D, value: CardValue.QUADRO),
				new Card(suit: CardSuit.D, value: CardValue.CINCO),
				new Card(suit: CardSuit.D, value: CardValue.SEIS),
				new Card(suit: CardSuit.D, value: CardValue.SETE),
		]
	}

	List<Card> createMatchCards() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.D, value: CardValue.TRES),
				new Card(suit: CardSuit.D, value: CardValue.QUADRO),
				new Card(suit: CardSuit.D, value: CardValue.CINCO),
				new Card(suit: CardSuit.D, value: CardValue.SEIS),
				new Card(suit: CardSuit.D, value: CardValue.SETE),
		]
	}
}
