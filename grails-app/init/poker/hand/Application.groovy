package poker.hand

import br.com.zg.pokerhand.categories.RoyalFlush
import br.com.zg.pokerhand.context.Context
import br.com.zg.pokerhand.enums.CardSuit
import br.com.zg.pokerhand.enums.CardValue
import br.com.zg.pokerhand.enums.Category
import br.com.zg.pokerhand.models.Card
import br.com.zg.pokerhand.models.Game
import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration

import static br.com.zg.pokerhand.enums.Category.buildHierarchyOfCategories

class Application extends GrailsAutoConfiguration {
	static void main(String[] args) {
		GrailsApp.run(Application, args)

		Context context
		List<Category> categories = buildHierarchyOfCategories()

		//TODO jogo que será computado
		Game game

		Category category = categories.find {
			context = new Context(it.categoryStrategy)
			return context.executeStrategy([
					new Card(suit: CardSuit.C, value: CardValue.T),
					new Card(suit: CardSuit.C, value: CardValue.J),
					new Card(suit: CardSuit.C, value: CardValue.Q),
					new Card(suit: CardSuit.C, value: CardValue.K),
					new Card(suit: CardSuit.C, value: CardValue.NOVE),
					new Card(suit: CardSuit.S, value: CardValue.SEIS),
					new Card(suit: CardSuit.H, value: CardValue.SETE)
			])
		}
	}
}
