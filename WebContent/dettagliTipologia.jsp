<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettagli Tipologia</title>
</head>
<body>
<h1>Dettagli Tipologia:</h1>
<ul>
<li>Nome: ${tipologiaCorrente.nome}</li>
<li>Descrizione: ${tipologiaCorrente.descrizione}</li>
<li>Costo: ${tipologiaCorrente.costo} Euro</li>
<li>Pre-Requisiti: ${tipologiaCorrente.preRequisiti}</li>
<li>Risultati Esame: ${tipologiaCorrente.risultati}</li>

</ul>


<br><br>
<a href="/homePage"><button type="button">Torna alla Home Page</button></a>
</body>
</html>