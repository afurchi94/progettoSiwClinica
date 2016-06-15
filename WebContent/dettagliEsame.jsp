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
<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="style.css">
<title>Dettagli Esame</title>
</head>
<body>
<center>
	<h1>Esame : ${esame.id}</h1>

			<ul >
				<li><strong>Tipologia:</strong> ${esame.tipologia.nome}</li>
				<li><strong>Paziente:</strong>  ${esame.paziente.cognome} ${esame.paziente.nome}</li>
				<li><strong>Codice Fiscale:</strong> ${esame.paziente.codiceFiscale}</li>
				<li><strong>Data Esame:</strong> ${esame.dataEffettuazione}</li>
				<li><strong>Data Prenotazione:</strong> ${esame.dataPrenotazione} alle: ${esame.oraPrenotazione}</li>
				<li><strong>Medico:</strong> ${esame.medico.cognome} ${esame.medico.nome}</li>
			<li><strong>Effettuato:</strong> ${esame.effettuato}</li>
			</ul>
	
<BR>
<strong>Risultati Esame:<strong></strong> 

<ul >
	<%Esame esame= (Esame)request.getAttribute("esame");
	if(esame!=null){
	if(esame.getRisultati().size() >0){ 
	for( Risultato r : esame.getRisultati()){ 
	request.setAttribute("r", r);%>	
		<li>${r.nome} : ${r.risultato}</li>			
	<% 	}}else{ %>
	<li>Esame Senza Risultati</li>
	<%} }else{%>
	<li>Tipologia Corrente Nulla</li>
	
	<%} %>
</ul>


</ul>
				
				
				<a href="/progettoSiwClinica/homePage.jsp">	<button class="btn btn-primary" type="button">Torna alla HomePage</button></a>
</center>
</body>

</html>
