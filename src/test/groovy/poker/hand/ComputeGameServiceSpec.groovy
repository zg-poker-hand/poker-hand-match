package poker.hand

import br.com.zg.pokerhand.enums.CardSuit
import br.com.zg.pokerhand.enums.CardValue
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Game
import br.com.zg.pokerhand.models.Player
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class ComputeGameServiceSpec extends Specification implements ServiceUnitTest<ComputeGameService> {

	ComputeGameService computeGameService

	void "MatchWinner - Sem empate"() {
		given:
		computeGameService = new ComputeGameService()

		Game game = new Game()
		game.players = [
				buildRoyalFlush(),
				buildFlush(),
		]

		when:
		Player winner = computeGameService.matchWinner(game)

		then:
		winner == game.players.first()
	}

	void "MatchWinner - Com empate"() {
		given:
		computeGameService = new ComputeGameService()

		Game game = new Game()
		game.players = [
				buildFlush(),
				buildFlush(),
		]

		when:
		Player winner = computeGameService.matchWinner(game)

		//TODO por enquanto até desempatar
		then:
		winner.category == new Player().category
	}

	Player buildRoyalFlush() {
		Player player = new Player()

		player.cards = [
				new Card(suit: CardSuit.C, value: CardValue.T),
				new Card(suit: CardSuit.C, value: CardValue.J),
				new Card(suit: CardSuit.C, value: CardValue.Q),
				new Card(suit: CardSuit.C, value: CardValue.K),
				new Card(suit: CardSuit.C, value: CardValue.A),
				new Card(suit: CardSuit.S, value: CardValue.SEIS),
				new Card(suit: CardSuit.H, value: CardValue.SETE)
		]

		return player
	}

	Player buildFlush() {
		Player player = new Player()

		player.cards = [
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.DOIS),
				new Card(suit: CardSuit.C, value: CardValue.TRES),
				new Card(suit: CardSuit.C, value: CardValue.NOVE),
				new Card(suit: CardSuit.C, value: CardValue.QUATRO),
				new Card(suit: CardSuit.H, value: CardValue.CINCO),
				new Card(suit: CardSuit.S, value: CardValue.SEIS)
		]

		return player
	}
}
