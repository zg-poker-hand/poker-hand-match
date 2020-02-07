package br.com.zg.pokerhand.enums

enum CardValue {
	DOIS(2),
	TRES(3),
	QUATRO(4),
	CINCO(5),
	SEIS(6),
	SETE(7),
	OITO(8),
	NOVE(9),
	T(10),
	J(11),
	Q(12),
	K(13),
	A(14),

	private Integer value

	CardValue(final Integer value) {
		this.value = value
	}

	Integer getValue() {
		return value
	}
}
