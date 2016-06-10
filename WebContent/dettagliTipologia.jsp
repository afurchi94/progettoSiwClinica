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
<li>Pre-Requisiti:

<ul >
	<% for( int i=0; i<=tipologiaCorrente.prerequisiti.size(); i++){ %>	
		<li>${tipologiaCorrente.prerequisiti[i]}</li>			
	<% 	} %>
</ul>
</li>
<li>Risultati Esame: 

<ul >
	<% for( int i=0; i<=tipologiaCorrente.risultati.size(); i++){ %>	
		<li>${tipologiaCorrente.risultati[i]}</li>			
	<% 	} %>
</ul>
</li>

</ul>


<br><br>
<a href="/progettoSiwClinica/homePage"><button type="button">Torna alla Home Page</button></a>
</body>

</html>
