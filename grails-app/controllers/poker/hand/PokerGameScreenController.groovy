package poker.hand

class PokerGameScreenController {
    def index() { }

	def	buscarPartidas ={
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

		redirect(uri: "/")
	}
}
