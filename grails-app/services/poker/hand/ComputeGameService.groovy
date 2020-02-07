package poker.hand

import br.com.zg.pokerhand.context.Context
import br.com.zg.pokerhand.enums.Category
import br.com.zg.pokerhand.models.Game
import br.com.zg.pokerhand.models.Player

import static br.com.zg.pokerhand.enums.Category.buildHierarchyOfCategories

class ComputeGameService {

	List<Category> categories
	Context context

	ComputeGameService() {
		categories = buildHierarchyOfCategories()
	}

	Player matchWinner(Game game) {
		setCategoriesIntoPlayers(game.players)
		List<Player> playersUnderDraw = extractsPlayersUnderDraw(game.players)

		if (playersUnderDraw.size() == 1) {
			return playersUnderDraw.first()
		}

		playersUnderDraw.each {
			context = new Context(playersUnderDraw.first().category?.categoryStrategy)
			context.executeCalculateScoreToUnDraw(it, game.board)
		}

		Player maxValue = playersUnderDraw.max { it.points }
		List<Player> players = playersUnderDraw.findAll { it.points == maxValue.points }

		if (players.size() > 1) {
			null
		} else {
			return playersUnderDraw.first()
		}
	}

	private setCategoriesIntoPlayers(List<Player> players) {
		players.each { player ->
			player.category = categories.find {
				context = new Context(it.categoryStrategy)
				return context.executeMatchStrategy(player.cards)
			}
		}

		return players
	}

	private static List<Player> extractsPlayersUnderDraw(List<Player> players) {
		Integer higherCategoryValue = Category.CARTA_ALTA.value
		return players.findAll {
			Integer currentValue = it.category.value
			if (currentValue >= higherCategoryValue) {
				higherCategoryValue = currentValue
				return it
			}
		}
	}
}
