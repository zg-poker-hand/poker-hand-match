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
			<a href="pokerGameScreen/buscarPartidas" class="btn btn-success" >Buscar Partidas</a>
		</div>
	</div>
	<br/>

	<div class="row">
		<div class="col-md-12">
			<textarea class="form-control" name="textPardidasConsole" id="textPardidasConsole" rows="10">

			</textarea>
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
				<tr>
					<td>
						Partida 1
					</td>
					<td>
						1A 2A 3A 4A 5A
					</td>
					<td>
						6A 7A
					</td>
					<td>
						Jogador 1
					</td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

</body>
</html>