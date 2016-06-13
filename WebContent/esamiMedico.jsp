<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Medico" %>
        <%@ page import="model.Esame" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Esami Medico</title>
</head>
<body>


<h1>Esami del medico: ${medico.cognome} ${medico.nome}</h1>

(da finire di implementare il link su ogni esame)
<ul >
	<%Medico medicoCorrente= (Medico)request.getAttribute("medico");
	if(medicoCorrente!=null){
	if(medicoCorrente.getEsami().size() >0){
	for( Esame e : medicoCorrente.getEsami()){ 
	request.setAttribute("e", e);%>	
	
	<form action="controllerVisualizzaEsami" method="get">
				<li>
				<button type="submit" name="idEsame" value='${e.id}'>${e.id}</button> - Svolto in data: ${e.dataEffettuazione}- Tipologia: ${e.tipologia}- Paziente: ${e.paziente.cognome}
				</li>				
				</form>
	
			
	<% 	}}else{ %>
	<li>Medico senza Esami Svolti</li>
	<%} }%>
</ul>


<a href="/progettoSiwClinica/vediMedici.jsp">	<button type="button">Cerca altro Medico</button></a>
<a href="/progettoSiwClinica/homePage.jsp">	<button type="button">Torna alla HomePage</button></a>
</body>

</html>
