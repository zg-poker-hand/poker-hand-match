<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<meta name="layout" content="main"/>
	<title>Poker Game Screen</title>
</head>

<body>
<div class="container" style="margin-top: 20px">
	<div class="row">
		<div class="col-md-12">
			<a href="/pokerGameScreen/buscarPartidas" class="btn btn-info" >Buscar por partidas do site e processar</a>
			<a href="/pokerGameScreen/processarGames" class="btn btn-success">Processar partidas armazenadas localmente</a>
		</div>
	</div>
	<br/>

	<div class="row">
		<div class="col-md-12">
			<table class="table table-striped">
				<thead>
				<tr>
					<th>Nome Partida</th>
					<th>Cartas na mesa</th>
					<th>Mão vencedora</th>
					<th>Jogador vencedor</th>
				</tr>
				</thead>
				<tbody>
				<g:each var="file" in="${games}">
					<g:each var="game" in="${file}">
						<tr>
							<td>${game.name}</td>
							<td>${game.board.cards.collect{it.description+it.suit}.join(' - ')}</td>
							<td></td>
							<td></td>
						</tr>
					</g:each>
				</g:each>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>