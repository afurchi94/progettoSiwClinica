<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*"%>
    <%@ page import="model.Facade"%>
    <%@ page import="model.TipologiaEsame"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta Tipologie di Esame</title>
</head>
<body>
	<h1>Tipologie di Esame offerte dalla Clinica:</h1>
			clicca su una tipologia per vederne i dettagli(piu avanti implemento anche il link su ogni tipologia stampata)
			<ul >
			<form action="controllerVisualizzaTipologie" >
			<% Facade facade = new Facade();
			List<TipologiaEsame> tipologie = facade.getTipologieEsame();
			if(tipologie.size()>0){
			for(TipologiaEsame t : tipologie){ %>
				
				<li><button type="submit" name="codTipologia" value="${t.codice}">${t.nome}</button> - ${t.codice} - ${t.costo} - ${t.descrizione}</li>			
				
			<% 	}}else{ %>
				<li><h4>Non Sono presenti Tipologie nel Sistema</h4></li>
			
			<%}%>
			</ul>
			</form>
</body>

</html>
