<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="InserisciTipologia">

	<head>


		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
		<script type="text/javascript" src="app.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="style.css">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Inserisci Nuova Tipologia</title>

	</head>
	<body ng-controller="TipologiaController as tipologia">

		<center><h1>Inserisci i dati della nuova Tipologia di Esame</h1>
		

			<form class="form-inline" ng-submit="tipologia.sendDati()">
			
				<!-- Probabilmente da cambiare il nome degli attributi Error, per evitare errori con quelli di new esame e simili -->
				<br><br><div class="form-group">
					<label>Nome</label>
					<input type="text" class="form-control"	placeholder="Nome" ng-model="nome" required>
				</div><br><br>


				<div class="form-group">
					<label>Codice</label>
					<input type="text" class="form-control"	placeholder="Codice Tipologia Esame" ng-model="codice" required>
				</div><br><br>
	
				<div class="form-group">
					<label>Descrizione</label>
					<input type="text" class="form-control" placeholder="Descrizione Tipologia Esame" ng-model="descrizione" required>
				</div>		<br><br>

				<div class="form-group">
					<label>Costo</label>
					<input type="number" min="0" class="form-control" placeholder="Costo (in Euro)" ng-model="costo" required>
				</div><br><br><br>
				
		
						<!-- Qui devo metterci i preRequisiti -->
			
			
				<div class="form-group" ng-controller="RisultatiController as risControl">
				
					<label>Risultati della Tipologia</label><br>
					
					<ul ng-show="tipologia.risultati.length">
						<li ng-repeat="risultato in tipologia.risultati">{{risultato}}<li>
					</ul><br>
					<textarea ng-model="risControl.text" type="text" placeholder="Inserisci un Risultato"></textarea>
			
			
			
			
			
			<!-- VERO SCRIPT -->
			
				
					<br><button class="btn btn-info" ng-click="risControl.addRisultato(tipologia)">Aggiungi un altro Risultato</button>
				
				</div>
				
				
				<br><br><br>
				<input type="submit" class="btn btn-primary btn-lg" value="Crea Nuova Tipologia" />	
			
			<br>
			{{rispostaDalPost}}
			<br>
			{{dettagliErrore}}
		</form>
		</center>
	</body>

</html>
