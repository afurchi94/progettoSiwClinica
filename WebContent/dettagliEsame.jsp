<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettagli Esame</title>
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
				Risultati: 
				
				
				<a href="/consultaEsami">	<button type="button">Scegli Altro Esame</button></a>
				<a href="/homePage">	<button type="button">Torna alla HomePage</button></a>
</body>
>>>>>>> refs/remotes/origin/master
</html>
