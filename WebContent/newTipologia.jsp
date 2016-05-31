<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci Nuova Tipologia</title>
</head>
<body>

	<h1>Inserisci i dati della nuova Tipologia di Esame</h1>
	<div>

		<form action="controllerTipologiaEsame" method="post">

			<!-- Probabilmente da cambiare il nome degli attributi Error, per evitare errori con quelli di new esame e simili -->
			<div class="form-group">
				<p>${nomeError}</p>
				<label>Nome</label><input type="text" class="form-control"
					placeholder="Nome" name="nome" value='${param["nome"]}'>
			</div>


			<div class="form-group">
				<p>${codiceError}</p>
				<label>Codice</label><input type="text" class="form-control"
					placeholder="Codice Tipologia Esame" name="codice"
					value='${param["codice"]}'>
			</div>

			<div class="form-group">
				<p>${descrizioneError}</p>
				<label>Descrizione</label><input type="text" class="form-control"
					placeholder="Descrizione Tipologia Esame" name="descrizione"
					value='${param["descrizione"]}'>
			</div>

			<div class="form-group">
				<p>${costoError}</p>
				<label>Costo</label> <input type="number" min="0"
					class="form-control" placeholder="Costo (in Euro)" name="costo"
					value='${param["costo"]}'>
			</div>
			
			<div class="form-group">
				<p>${codicePrerequisitoError}</p>
				<label>PreRequisiti</label> <br>
				<% for(int i=0; i<prerequisiti.size();i++){ %>
				<input type="checkbox" class="form-control" name="prerequisito" value='${prerequisiti[i]}'> ${prerequisiti[i]} <br>
				<% } %>
			</div>
						
			
			<div id="div_risultati">
			
				<div class="form-group">
					<p>${risultatoError}</p>
					<label>Risultati </label><br>
					<input type="text" id="input0" class="form-control" placeholder="Nome del Risultato" name="risultato" value='${risultati[0]}'> <br>
				</div>
			</div>
			
			<button type="button" id="button_add" > Aggiungi un altro Risultato</button> 
			<br><br><br>
			<button type="submit" id= "button_sub" class="btn btn-default">Crea Tipologia Esame</button>
			
			<script>
				var list= [];
				cont=0;
				document.getElementById("button_add").addEventListener("click", function(){
					cont=cont+1;
					document.getElementById("div_risultati").innerHTML = document.getElementById("div_risultati").innerHTML + "<input type='text' id='input"+cont+"' class='form-control' placeholder='Nome del Risultato' value='${risultati["+cont+"]}'> <br>";
				} );



				document.getElementById("button_sub").addEventListener("click", function(){
					
					for( i=0; i<=cont; i++){ 
						var inputText= document.getElementById("input"+i);
						list.push( inputText.value );
					}
					
					// QUI DEVO IMPLEMENTARE IL PASSAGGIO DI list AL CONTROLLER O CMQ QUALCOSA DEL GENERE
				});
			</script>
		</form>
</body>

</html>
