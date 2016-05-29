<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci Risultati Esame</title>
</head>
<body>

	<h1>Esame : ${esameCorrente.codice}</h1>

			<ul >
				<li>Tipologia: ${esameCorrente.tipologia}</li>
				<li>Paziente: : ${paziente.cognome} ${paziente.nome}</li>
				<li>Codice Fiscale: ${paziente.codFiscale}</li>
				<li>Data Esame: ${esameCorrente.dataEsame}</li>
				<li>Data Prenotazione: ${esameCorrente.dataPrenotazione} ${esameCorrente.oraPrenotazione}</li>
				<li>Medico: ${medico.cognome} ${medico.nome}</li>
			</ul>
			
			<h2>Inserisci qui i Risultati dell`esame:</h2>
			
			
			<form action="controllerTipologiaEsame" method="get">
			
			<ul>
			
			<li>
			<div class="form-group">
						<p>${risultatiError}</p>
						<label>TipoRisultato_1</label><input type="text" class="form-control"
							placeholder="TipoRisultato_1" name="risultati_1"
							value='${param["risultati_1"]}'>
					</div>
			</li>
			<li>
			<div class="form-group">
						<p>${risultatiError}</p>
						<label>TipoRisultato_2</label><input type="text" class="form-control"
							placeholder="TipoRisultato_2" name="risultati_2"
							value='${param["risultati_2"]}'>
					</div>
			</li>
			
			</ul>
<button type="submit">Inserisci Risultati</button>

</form>
</body>
>>>>>>> refs/remotes/origin/master
</html>
