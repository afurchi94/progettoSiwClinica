<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.TipologiaEsame"%>
    <%@ page import="model.Prerequisito"%>
        <%@ page import="model.Risultato"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettagli Tipologia</title>
</head>
<body>
<h1>Dettagli Tipologia:</h1>
<ul>
<li>Nome: ${tipologia.nome}</li>
<li>Descrizione: ${tipologia.descrizione}</li>
<li>Costo: ${tipologia.costo} Euro</li>
<li>Pre-Requisiti:

<ul >
	<%TipologiaEsame tipologiaCorrente= (TipologiaEsame)request.getAttribute("tipologia");
	if(tipologiaCorrente!=null){
	if(tipologiaCorrente.getPrerequisiti().size() >0){
	for( Prerequisito p : tipologiaCorrente.getPrerequisiti()){ %>	
		<li>${p.nome}</li>
		<li>${p.descrizione}</li>			
	<% 	}}else{ %>
	<li>Tipologia Senza Prerequisiti</li>
	<%} %>
</ul>
<BR>
Risultati Esame: 

<ul >
	<%if(tipologiaCorrente.getRisultati().size() >0){ 
	for( Risultato r : tipologiaCorrente.getRisultati()){ %>	
		<li>${r.nome}</li>			
	<% 	}}else{ %>
	<li>Tipologia Senza Risultati</li>
	<%} }else{%>
	<li>Tipologia Corrente Nulla</li>
	
	<%} %>
</ul>


</ul>


<br><br>
<a href="/progettoSiwClinica/homePage.jsp"><button type="button">Torna alla Home Page</button></a>
</body>

</html>
