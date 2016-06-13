<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Paziente"%>
    <%@ page import="model.Esame"%>
    <%@ page import="model.Medico"%>
    <%@ page import ="model.Risultato" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettagli Esame</title>
</head>
<body>

	<h1>Esame : ${esame.id}</h1>

			<ul >
				<li>Tipologia: ${esame.tipologia}</li>
				<li>Paziente: : ${esame.paziente.cognome} ${esame.paziente.nome}</li>
				<li>Codice Fiscale: ${paziente.codFiscale}</li>
				<li>Data Esame: ${esame.dataEffettuazione}</li>
				<li>Data Prenotazione: ${esame.dataPrenotazione} alle: ${esame.oraPrenotazione}</li>
				<li>Medico: ${esame.medico.cognome} ${esame.medico.nome}</li>
			</ul>
	
<BR>
Risultati Esame: 

<ul >
	<%Esame esame= (Esame)request.getAttribute("esame");
	if(esame!=null){
	if(esame.getRisultati().size() >0){ 
	for( Risultato r : esame.getRisultati()){ %>	
		<li>${r.nome} : ${r.risultato}</li>			
	<% 	}}else{ %>
	<li>Esame Senza Risultati</li>
	<%} }else{%>
	<li>Tipologia Corrente Nulla</li>
	
	<%} %>
</ul>


</ul>
				
				
				<a href="/progettoSiwClinica/homePage.jsp">	<button type="button">Torna alla HomePage</button></a>
</body>

</html>
