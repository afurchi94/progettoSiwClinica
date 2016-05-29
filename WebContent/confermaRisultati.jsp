<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci Risultati Esame</title>
</head>
<body>
<div>

<h1> I Risultati dell`esame che hai inserito sono:</h1>
Da implementare la stampa risultati
			<p>
			<ul >
				<li>Risultati0: ${esame.risultati}</li>
				<li>Risultati1 </li>
				<li>Risultati2... </li>
			</ul>
			</p>
			<div align="center">
			<h1>Confermi l`inserimento dei Risultati dell`Esame?</h1>
			<a href="/areaAmministrazione">	<button type="button"  onclick="alert('Risultati Esame inseriti con Successo')">Conferma Inserimento Risultati</button></a>
			<a href="/inserisciRisultati">	<button type="button">Torna Indietro</button></a>
		</div>
		</div>


</body>
</html>