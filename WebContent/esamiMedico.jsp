<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Medico" %>
        <%@ page import="model.Esame" %>
        
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="style.css">
<title>Esami Medico</title>
</head>
<body>


<center><h1>Esami del medico: ${medico.cognome} ${medico.nome}</h1></center>


<ul >
	<%Medico medicoCorrente= (Medico)request.getAttribute("medico");
	if(medicoCorrente!=null){
	if(medicoCorrente.getEsami().size() >0){
	for( Esame e : medicoCorrente.getEsami()){ 
	request.setAttribute("e", e);%>	
	
	<form action="controllerVisualizzaEsami" method="get">
				<li>
				<button class="btn btn-success"type="submit" name="idEsame" value='${e.id}'>${e.id}</button>  <strong>Svolto in data:</strong> ${e.dataEffettuazione} - <strong>Tipologia:</strong> ${e.tipologia.nome} - <strong>Paziente:</strong> ${e.paziente.cognome} - <strong>Effettuato:</strong> ${e.effettuato} 
				</li>				
				</form>
	
			
	<% 	}}else{ %>
	<li>Medico senza Esami Svolti</li>
	<%} }%>
</ul>

<center>
<a class="btn btn-primary"href="/progettoSiwClinica/vediMedici.jsp">	<button type="button">Cerca altro Medico</button></a>
<a class="btn btn-primary"href="/progettoSiwClinica/homePage.jsp">	<button type="button">Torna alla HomePage</button></a>
</center>
</body>

</html>
