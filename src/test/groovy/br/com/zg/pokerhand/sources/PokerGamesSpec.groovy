package br.com.zg.pokerhand.sources

import br.com.zg.pokerhand.models.Game
import spock.lang.Specification

class PokerGamesSpec extends Specification{
	void "testa leitura de games"(){
		given:
		String filePath = System.getProperty('user.dir')+'/src/test/resources/arquivo.xml'
		List<Game> games = []

		when:
		games = PokerGames.getGames(filePath)

		then:
		games.size() == 4
	}
}
