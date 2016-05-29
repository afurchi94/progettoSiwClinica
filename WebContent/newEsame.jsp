<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserimento Esame</title>
</head>
<body>
<h1>Inserisci i dati del nuovo Esame</h1>
<div>

<form action="controllerEsame" method="get">
<!-- il Type Radio serve a mettere una spunta sulla nostra scelta della tipologia. Questa parte è meglio vista quando è finita con JS in cui aggiorniamo le nuove tipologie -->
					<div class="form-group">
						<p>${tipologiaError}</p>
						<label>Tipologia Esame</label> <input type="radio" class="form-control"  name="tipologiaEsame1"
								value='${param["tipologiaEsame"]}'> Tipologia Esame 1 <br>
					</div>
					
	<!-- L-inserimento della data ora è un po barbaro, ma dovrebbe funzionare... Se non funziona dobbiamo per forza usare quello del prof-->				
					<div class="form-group">
						<p>${dataError}</p>
						<label>Data</label> <input type="data" class="form-control"
							placeholder="Data Esame" name="dataEsame" value='${param["dataEsame"]}'>
					</div>
					
					<div class="form-group">
						<p>${codFiscaleError}</p>
						<label>Codice Fiscale Paziente</label><input type="text" class="form-control"
							placeholder="Codice Fiscale Paziente" name="codFiscale"
							value='${param["codFiscale"]}'>
					</div>
					
						<div class="form-group">
						<p>${codMedicoError}</p>
						<label>Codice Medico</label> <input type="text" class="form-control"
							placeholder="Codice Medico" name="codMedico"
							value='${param["codMedico"]}'>
					</div>
					
					
					
				
					<button type="submit" class="btn btn-default">Crea Esame</button>
				</form>
	


</div>













</body>
</html>