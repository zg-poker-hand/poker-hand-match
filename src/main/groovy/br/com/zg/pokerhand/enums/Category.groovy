package br.com.zg.pokerhand.enums

import br.com.zg.pokerhand.categories.CartaAlta
import br.com.zg.pokerhand.categories.DoisPares
import br.com.zg.pokerhand.categories.Flush
import br.com.zg.pokerhand.categories.FullHouse
import br.com.zg.pokerhand.categories.Quadra
import br.com.zg.pokerhand.categories.RoyalFlush
import br.com.zg.pokerhand.categories.Sequencia
import br.com.zg.pokerhand.categories.StraightFlush
import br.com.zg.pokerhand.categories.Trinca
import br.com.zg.pokerhand.categories.UmPar
import br.com.zg.pokerhand.interfaces.CategoryStrategy

enum Category {
	CARTA_ALTA(0, new CartaAlta()),
	UM_PAR(1, new UmPar()),
	DOIS_PARES(2, new DoisPares()),
	TRINCA(3, new Trinca()),
	SEQUENCIA(4, new Sequencia()),
	FLUSH(5, new Flush()),
	FULL_HOUSE(6, new FullHouse()),
	QUADRA(7, new Quadra()),
	STRAIGHT_FLUSH(8, new StraightFlush()),
	ROYAL_FLUSH(9, new RoyalFlush())

	private Integer value
	private CategoryStrategy categoryStrategy

	Category(final Integer value, final CategoryStrategy categoryStrategy) {
		this.value = value
		this.categoryStrategy = categoryStrategy
	}

	Integer getValue() {
		return value
	}

	CategoryStrategy getCategoryStrategy() {
		return categoryStrategy
	}

	static List<Category> buildHierarchyOfCategories() {
		return [
				ROYAL_FLUSH,
				STRAIGHT_FLUSH,
				QUADRA,
				FULL_HOUSE,
				FLUSH,
				SEQUENCIA,
				TRINCA,
				DOIS_PARES,
				UM_PAR,
				CARTA_ALTA,
		]
	}
}
