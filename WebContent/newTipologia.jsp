<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="InserisciTipologia">

	<head>


		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
		<script type="text/javascript" src="app.js"></script>

		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Inserisci Nuova Tipologia</title>

	</head>
	<body ng-controller="TipologiaController as tipologia">

		<h1>Inserisci i dati della nuova Tipologia di Esame</h1>
		

			<form ng-submit="tipologia.sendDati()">

				<!-- Probabilmente da cambiare il nome degli attributi Error, per evitare errori con quelli di new esame e simili -->
				<div class="form-group">
					<label>Nome</label>
					<input type="text" class="form-control"	placeholder="Nome" ng-model="nome" required>
				</div>


				<div class="form-group">
					<label>Codice</label>
					<input type="text" class="form-control"	placeholder="Codice Tipologia Esame" ng-model="codice" required>
				</div>
	
				<div class="form-group">
					<label>Descrizione</label>
					<input type="text" class="form-control" placeholder="Descrizione Tipologia Esame" ng-model="descrizione" required>
				</div>		

				<div class="form-group">
					<label>Costo</label>
					<input type="number" min="0" class="form-control" placeholder="Costo (in Euro)" ng-model="costo" required>
				</div>
				
		
						<!-- Qui devo metterci i preRequisiti -->
			
				<div class="form-group" ng-controller="RisultatiController as risControl">
				
				
				
					<label>Risultati </label><br>
					
					<ul ng-show="tipologia.risultati.length">
						<li ng-repeat="risultato in tipologia.risultati">{{risultato}}<li>
					</ul><br>
					<textarea ng-model="risControl.text" type="text" placeholder="Inserisci un Risultato"></textarea>
			
			
			
			
			
			<!-- VERO SCRIPT -->
			
				
					<button ng-click="risControl.addRisultato(tipologia)">Aggiungi un altro Risultato</button>
				
				</div>
				
				
				<br><br>
				<input type="submit" value="Crea Nuova Tipologia" />	
			
			<br>
			{{rispostaDalPost}}
			<br>
			{{dettagliErrore}}
		</form>
	</body>

</html>
