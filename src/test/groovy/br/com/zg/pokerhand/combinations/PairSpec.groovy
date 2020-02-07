package br.com.zg.pokerhand.combinations

import br.com.zg.pokerhand.models.Card
import spock.lang.Specification

class PairSpec extends Specification {

	List<Card> cards
	Pair pair
	Boolean result

	void setup() {
		pair = new Pair()
		cards = []
		
	}

	def "testOnePair"() {
		when:
		Card card1 = new Card(value: 3)
		Card card2 = new Card(value: 3)
		Card card3 = new Card(value: 4)
		Card card4 = new Card(value: 6)
		Card card5 = new Card(value: 7)
		Card card6 = new Card(value: 10)
		Card card7 = new Card(value: 11)
		cards.addAll([card1, card2, card3, card4, card5, card6, card7])
		result = pair.isMatch(cards)
		then:
		result

	}

	def "testNoPair"() {
		when:
		Card card1 = new Card(value: 3)
		Card card2 = new Card(value: 2)
		Card card3 = new Card(value: 4)
		Card card4 = new Card(value: 6)
		Card card5 = new Card(value: 7)
		Card card6 = new Card(value: 10)
		Card card7 = new Card(value: 11)
		cards.addAll([card1, card2, card3, card4, card5, card6, card7])
		result = pair.isMatch(cards)
		then:
		!result

	}
}
