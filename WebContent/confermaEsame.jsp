<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Conferma Creazione Esame</title>
</head>
<body>
<div>
			<h1> I Dati da te inseriti sono:</h1>
			<p>
			<ul >
				<li>Tipologia: ${esame.tipologiaEsame}</li>
				<li>Data Esame: ${esame.dataEsame}</li>
				<li>Codice Fiscale: ${esame.codFiscale}</li>
				<li>Codice Medico: ${esame.codMedico}</li>
			</ul>
			</p>
			<div align="center">
			<h1>Sei Sicuro di aver inserito correttamente i dati e desideri procedere con la creazione dell`Esame?</h1>
			<a href="/areaAmministrazione">	<button type="button"  onclick="alert('Esame Creato con Successo')">Conferma Creazione Esame</button></a>
			<a href="/newEsame">	<button type="button">Torna Indietro</button></a>
		</div>
		</div>

</body>
=======
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Conferma Creazione Esame</title>
</head>
<body>
<div>
			<h1> I Dati da te inseriti sono:</h1>
			<p>
			<ul >
				<li>Tipologia: ${esame.tipologiaEsame}</li>
				<li>Data Esame: ${esame.dataEsame}</li>
				<li>Codice Fiscale: ${esame.codFiscale}</li>
				<li>Codice Medico: ${esame.codMedico}</li>
			</ul>
			</p>
			<div align="center">
			<h1>Sei Sicuro di aver inserito correttamente i dati e desideri procedere con la creazione dell`Esame?</h1>
			<a href="/areaAmministrazione">	<button type="button"  onclick="alert('Esame Creato con Successo')">Conferma Creazione Esame</button></a>
			<a href="/newEsame">	<button type="button">Torna Indietro</button></a>
		</div>
		</div>

</body>
>>>>>>> refs/remotes/origin/master
</html>
