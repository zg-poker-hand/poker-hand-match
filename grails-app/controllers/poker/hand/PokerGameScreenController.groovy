package poker.hand

import br.com.zg.pokerhand.models.Game

class PokerGameScreenController {
	PokerGameScreenService pokerGameScreenService
    def index() {
		if(!pokerGameScreenService) pokerGameScreenService = new PokerGameScreenService()
	}

	def	buscarPartidas = {
		URL url = new URL("http://localhost:5002/buscargames")
		HttpURLConnection connection = (HttpURLConnection) url.openConnection()
		connection.setRequestMethod("GET")
		connection.connect()
		if (connection.responseCode == 200 || connection.responseCode == 201) {
			def returnMessage = connection.content
			println(returnMessage)
		} else {
			println('Erro na requisicao: Buscar Partidas')
		}

		List<Game> games = pokerGameScreenService.gameResults

		render(view: '/pokerGameScreen', model: [games: games])
	}

	def processarGames = {
		List<Game> games = pokerGameScreenService.gameResults

		render(view: '/pokerGameScreen', model: [games: games])
	}
}
