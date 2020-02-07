package poker.hand

import br.com.zg.pokerhand.models.Game
import br.com.zg.pokerhand.sources.PokerGames

class PokerGameScreenService {

    List<Game> getGameResults(){
        List<File> files = findFiles().take(10)
        List<Game> games = getGames(files)
        return games
    }
    List<File> findFiles(){
        List<File> files = []
        File dir = new File(System.getProperty('user.dir')+'/src/main/resources/web-files')
        if (dir.exists()){
            dir.eachFile {file ->
                files << file
            }
        }
        return files
    }

    List<Game> getGames(List<File> files){
        List<Game> games = []

        for (File file : files){
            games << PokerGames.getGames(file.getPath())
        }

        return games
    }
}
