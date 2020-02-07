package br.com.zg.pokerhand.enums

enum Category {
	CARTA_ALTA(0),
	UM_PAR(1),
	DOIS_PARES(2),
	TRINCA(3),
	SEQUENCIA(4),
	FLUSH(5),
	FULL_HOUSE(6),
	QUADRA(7),
	STRAIGHT_FLUSH(8),
	ROYAL_FLUSH(9)

	private Integer value

	Category(final Integer value) {
		this.value = value
	}

	Integer getValue() {
		return value
	}
}
