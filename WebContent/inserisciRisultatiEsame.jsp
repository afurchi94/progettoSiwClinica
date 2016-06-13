<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="model.Esame" %>
    <%@ page import="model.Risultato" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci Risultati Esame</title>
</head>
<body>

	<h1>Esame : ${esameCorrente.codice}</h1>

			<ul >
				<li>Tipologia: ${esameCorrente.tipologia}</li>
				<li>Paziente: : ${paziente.cognome} ${paziente.nome}</li>
				<li>Codice Fiscale: ${paziente.codFiscale}</li>
				<li>Data Esame: ${esameCorrente.dataEsame}</li>
				<li>Data Prenotazione: ${esameCorrente.dataPrenotazione} ${esameCorrente.oraPrenotazione}</li>
				<li>Medico: ${medico.cognome} ${medico.nome}</li>
			</ul>
			
			<h2>Inserisci qui i Risultati dell`esame:</h2>
			
			
			<form action="controllerTipologiaEsame" method="get">
			
			<ul>
			
			
			
			<ul >
	<%Esame esame= (Esame)request.getAttribute("esame");
	List<String> lista=null;
	
	if(esame!=null){
	List<Risultato> risultati = esame.getRisultati();
	if(risultati.size() >0){ 
	for( int i=0; i< risultati.size(); i++){ %>	
		<p>${risultatoError}</p>
		<div class="form-group">
			<li>${risultati[i].nome} : 
			<input type="text" class="form-control"	placeholder="Valore Risultato" name='<% "risultato".concat(String.valueOf(i)); %>' value='<%request.getAttribute("risultato".concat(String.valueOf(i)));%>>'>
		</div>
			
		
		
	<% 	}}else{ %>
	<li>Esame Senza Risultati</li>
	<%} }else{%>
	<li>Esame Nullo</li>
	
	<%} %>
</ul>
			
			
			</ul>
<button type="button" onclick='alert(Sei sicuro di inserire questi dati? <button type="submit">Inserisci Risultati</button>) <button type="button" onclick>Annulla</button>'>

</form>
</body>

</html>
