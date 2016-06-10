<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Paziente"%>
    <%@ page import="java.util.*"%>
    <%@ page import="model.Esame"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta Esami</title>
</head>
<body>


	<h1>Esami Sostenuti dal paziente ${pazienteLogin.nome} :</h1>
	
			clicca su di un esame per vederne i dettagli
			
			<%Paziente pazienteLogin= (Paziente)session.getAttribute("pazienteLogin");
			List<Esame> lista=pazienteLogin.getEsamiEffettuati(); 
			if(lista.size() > 0) {%>
				<ul >
				<%for(Esame e: lista){%>
					<li>Esame: ${e.codice} del ${e.dataEffettuazione} del Paziente ${e.paziente.cognome}</li>				
				<% }%>
				</ul>
			<% }else{%>
				
				<h4>Non hai Effettuato ancora nessun Esame</h4>

			<% }%>

</body>

</html>
