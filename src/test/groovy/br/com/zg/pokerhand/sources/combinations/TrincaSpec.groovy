package br.com.zg.pokerhand.sources.combinations

import br.com.zg.pokerhand.combinations.Trinca
import br.com.zg.pokerhand.models.Card
import spock.lang.Specification

class TrincaSpec extends Specification {

	List<Card> cards
	Trinca trinca
	Boolean result

	void setup() {
		trinca = new Trinca()
		Card card1 = new Card(value: 3)
		Card card2 = new Card(value: 3)
		Card card3 = new Card(value: 3)
		Card card4 = new Card(value: 6)
		Card card5 = new Card(value: 7)
		Card card6 = new Card(value: 10)
		Card card7 = new Card(value: 11)
		cards = []
		cards.addAll([card1, card2, card3, card4, card5, card6, card7])
	}

	def "testTrinca"() {
		when:
		result = trinca.isMatch(cards)
		then:
		result

	}

	def "testNoTrinca"() {
		when:
		Card card1 = new Card(value: 3)
		Card card2 = new Card(value: 2)
		Card card3 = new Card(value: 4)
		Card card4 = new Card(value: 6)
		Card card5 = new Card(value: 7)
		Card card6 = new Card(value: 10)
		Card card7 = new Card(value: 11)
		cards.addAll([card1, card2, card3, card4, card5, card6, card7])
		result = trinca.isMatch(cards)
		then:
		!result

	}
}
