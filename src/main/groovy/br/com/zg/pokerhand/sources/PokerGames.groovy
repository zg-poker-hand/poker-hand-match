package br.com.zg.pokerhand.sources

import br.com.zg.pokerhand.models.Board
import br.com.zg.pokerhand.models.Game
import br.com.zg.pokerhand.models.Player
import br.com.zg.pokerhand.utils.Utils
import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.databind.node.TextNode
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import poker.hand.ComputeGameService

class PokerGames {

	ComputeGameService computeGameService = new ComputeGameService()

	static List<Game> getGames(String pathGame){
		List<Game> games = []
		File file = new File(pathGame)
		XmlMapper mapper = new XmlMapper()
		String nameOfFile = file.getName().tokenize('.xml')?.first()

		ObjectNode nodes
		try {
			nodes = (ObjectNode)mapper.readTree(file)
		}catch(JsonParseException error){
			println('Erro na leitura do arquivo!')
			return null
		}

		nodes._children.eachWithIndex{ Map.Entry<String, JsonNode> entry, int i ->
			Game actualGame = new Game()
			Board actualBoard = new Board()
			actualGame.name = nameOfFile + ' game < ' + entry.key + ' >'

			String boardCards = entry.value._children.board._value.toString()
			actualBoard.cards = Utils.getCardsFromString(boardCards)

			Map<String, TextNode> playersCards = entry.value._children.findAll{it.key != 'board'}
			List<Player> actualPlayers = []
			playersCards.each {
				Player player = new Player()

				String playerCardsStr = it.value._value.toString()
				player.cards = Utils.getCardsFromString(playerCardsStr)

				actualPlayers << player
			}

			actualGame.board = actualBoard
			actualGame.players = actualPlayers
			actualGame.winner = computeGameService.matchWinner(actualGame)

			games << actualGame
		}
		return games
	}

}
