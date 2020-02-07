package br.com.zg.pokerhand.context

import br.com.zg.pokerhand.enums.CardSuit
import br.com.zg.pokerhand.enums.CardValue
import br.com.zg.pokerhand.enums.Category
import br.com.zg.pokerhand.models.Card
import spock.lang.Specification
import spock.lang.Unroll

import static br.com.zg.pokerhand.enums.Category.CARTA_ALTA
import static br.com.zg.pokerhand.enums.Category.DOIS_PARES
import static br.com.zg.pokerhand.enums.Category.FLUSH
import static br.com.zg.pokerhand.enums.Category.FULL_HOUSE
import static br.com.zg.pokerhand.enums.Category.QUADRA
import static br.com.zg.pokerhand.enums.Category.ROYAL_FLUSH
import static br.com.zg.pokerhand.enums.Category.SEQUENCIA
import static br.com.zg.pokerhand.enums.Category.STRAIGHT_FLUSH
import static br.com.zg.pokerhand.enums.Category.TRINCA
import static br.com.zg.pokerhand.enums.Category.UM_PAR
import static br.com.zg.pokerhand.enums.Category.buildHierarchyOfCategories

class ContextTest extends Specification {

	@Unroll
	def "ExecuteStrategy - #strategy"() {
		given:
		Context context

		List<Category> categories = buildHierarchyOfCategories()

		when:
		Category category = categories.find {
			context = new Context(it.categoryStrategy)
			return context.executeStrategy(cards)
		}

		then:
		category == strategy

		where:
		strategy       | cards
		STRAIGHT_FLUSH | buildSTRAIGHT_FLUSH()
		ROYAL_FLUSH    | buildROYAL_FLUSH()
		QUADRA         | buildQUADRA()
		FULL_HOUSE     | buildFULL_HOUSE()
		FLUSH          | buildFLUSH()
		SEQUENCIA      | buildSEQUENCIA()
		TRINCA         | buildTRINCA()
		DOIS_PARES     | buildDOIS_PARES()
		UM_PAR         | buildUM_PAR()
		CARTA_ALTA     | buildCARTA_ALTA()

	}

	List<Card> buildSTRAIGHT_FLUSH() {
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

	List<Card> buildROYAL_FLUSH() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.T),
				new Card(suit: CardSuit.C, value: CardValue.J),
				new Card(suit: CardSuit.C, value: CardValue.Q),
				new Card(suit: CardSuit.C, value: CardValue.K),
				new Card(suit: CardSuit.C, value: CardValue.A),
				new Card(suit: CardSuit.S, value: CardValue.SEIS),
				new Card(suit: CardSuit.H, value: CardValue.SETE)
		]
	}

	List<Card> buildQUADRA() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.QUATRO),
				new Card(suit: CardSuit.C, value: CardValue.CINCO),
				new Card(suit: CardSuit.C, value: CardValue.SEIS)
		]
	}

	List<Card> buildFULL_HOUSE() {
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

	List<Card> buildFLUSH() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.TRES),
				new Card(suit: CardSuit.C, value: CardValue.NOVE),
				new Card(suit: CardSuit.C, value: CardValue.QUATRO),
				new Card(suit: CardSuit.H, value: CardValue.CINCO),
				new Card(suit: CardSuit.S, value: CardValue.SEIS)
		]
	}

	List<Card> buildSEQUENCIA() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.SETE),
				new Card(suit: CardSuit.D, value: CardValue.TRES),
				new Card(suit: CardSuit.H, value: CardValue.QUATRO),
				new Card(suit: CardSuit.D, value: CardValue.CINCO),
				new Card(suit: CardSuit.D, value: CardValue.SEIS),
				new Card(suit: CardSuit.C, value: CardValue.SETE),
				new Card(suit: CardSuit.D, value: CardValue.DOIS),
		]
	}

	List<Card> buildTRINCA() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.D, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.D, value: CardValue.NOVE),
				new Card(suit: CardSuit.C, value: CardValue.A),
				new Card(suit: CardSuit.C, value: CardValue.SETE),
				new Card(suit: CardSuit.H, value: CardValue.SEIS)
		]
	}

	List<Card> buildDOIS_PARES() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.D, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.TRES),
				new Card(suit: CardSuit.D, value: CardValue.TRES),
				new Card(suit: CardSuit.H, value: CardValue.A),
				new Card(suit: CardSuit.C, value: CardValue.CINCO),
				new Card(suit: CardSuit.C, value: CardValue.SETE)
		]
	}

	List<Card> buildUM_PAR() {
		return [
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.D, value: CardValue.DOIS),
				new Card(suit: CardSuit.H, value: CardValue.TRES),
				new Card(suit: CardSuit.C, value: CardValue.A),
				new Card(suit: CardSuit.D, value: CardValue.QUATRO),
				new Card(suit: CardSuit.C, value: CardValue.CINCO),
				new Card(suit: CardSuit.C, value: CardValue.SETE)
		]
	}

	List<Card> buildCARTA_ALTA() {
		return [
				new Card(CardValue.DOIS, "as", CardSuit.C),
				new Card(CardValue.K, "as", CardSuit.C),
				new Card(CardValue.Q, "as", CardSuit.D),
				new Card(CardValue.TRES, "as", CardSuit.C),
				new Card(CardValue.T, "as", CardSuit.D),
				new Card(CardValue.CINCO, "as", CardSuit.D),
				new Card(CardValue.OITO, "as", CardSuit.C),
		]
	}
}
