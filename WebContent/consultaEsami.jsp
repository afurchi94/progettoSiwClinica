<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Paziente"%>
    <%@ page import="java.util.*"%>
    <%@ page import="model.Esame"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="style.css">
<title>Consulta Esami</title>
</head>
<body>


	<center><h1>Esami del paziente ${pazienteLogin.cognome} ${pazienteLogin.nome} :</h1>
	
			clicca sul codice di un esame per vederne i dettagli</center>
			<form action="controllerVisualizzaEsami" method="get">
			<%Paziente pazienteLogin= (Paziente)session.getAttribute("pazienteLogin");
			if(pazienteLogin != null){
			List<Esame> lista=pazienteLogin.getEsamiPrenotati(); 
			if(lista.size() > 0 ) {%>
				<ul >
				<%for(Esame e: lista){
				request.setAttribute("e", e);%>
				
				<li>
				<button type="submit" class="btn btn-success" name="idEsame" value='${e.id}'>${e.id}</button>  <strong>Svolto in data:</strong> ${e.dataEffettuazione} - <strong>Tipologia:</strong> ${e.tipologia.nome} - <strong>Effettuato:</strong> ${e.effettuato} 
				</li>				
							
				<% }%>
				</ul>
				</form>	
			<% }}else{%>
				
				<h4>Non hai Effettuato ancora nessun Esame</h4>

			<% }%>

</body>

</html>
