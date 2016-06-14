<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="model.Esame" %>
    <%@ page import="model.Risultato" %>
   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="style.css">
<title>Inserisci Risultati Esame</title>
</head>
<body>

	<h2>Esame : ${esame.id}</h2>

			<ul >
				<li>Tipologia: ${esame.tipologia.nome}</li>
				<li>Paziente: : ${esame.paziente.cognome} ${esame.paziente.nome}</li>
				<li>Codice Fiscale: ${esame.paziente.codiceFiscale}</li>
				<li>Data Esame: ${esame.dataEffettuazione}</li>
				<li>Data Prenotazione: ${esame.dataPrenotazione} alle  ${esame.oraPrenotazione}</li>
				<li>Medico: ${esame.medico.cognome} ${esame.medico.nome}</li>
			</ul>
			
			<h2>Inserisci qui i Risultati dell`esame:</h2>
			
			
			<form action="controllerInserimentoRisultati" method="get">
			
			<ul>
			
			
			
			
			<p>${risultatoError}</p>
	<%Esame esame= (Esame)request.getAttribute("esame");
	List<String> lista=null;
	
	if(esame!=null){
	List<Risultato> risultati = esame.getRisultati();
	if(risultati.size() >0){ 
		int i=0;
	for( Risultato r: risultati){ 
	request.setAttribute("r", r);%>	
		
		<div class="form-group">
			<li>${r.nome} : 
			<input type="text" class="form-control"	placeholder="Valore Risultato" name='<%= "risultato".concat(String.valueOf(i)) %>' value='<%=request.getAttribute("risultato".concat(String.valueOf(i)))%>'>
		</div>
		
		
	<% i++;
	}}else{ %>
	<li>Esame Senza Risultati</li>
	<%} }else{%>
	<li>Esame Nullo</li>
	
	<%} %>
</ul>
			
			
			
<button type="submit" class="btn btn-primary btn-lg btn-block">Conferma Effettuazione Esame</button>'>

</form>
</body>

</html>
