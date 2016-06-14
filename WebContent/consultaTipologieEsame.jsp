<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*"%>
    <%@ page import="model.Facade"%>
    <%@ page import="model.TipologiaEsame"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="style.css">
<title>Consulta Tipologie di Esame</title>
</head>
<body>
	<center><h1>Tipologie di Esame offerte dalla Clinica:</h1>
			clicca sul codice di una Tipologia per vederne i dettagli </center>
			<ul>
			
				<% Facade facade = new Facade();
				List<TipologiaEsame> tipologie = facade.getTipologieEsame();
				if(tipologie.size()>0){
				for(TipologiaEsame t : tipologie){ 
				request.setAttribute("t", t);%>
				<form action="controllerVisualizzaTipologie" method="get">
				<li>
				<button class="btn btn-success" type="submit" name="codTipologia" value='${t.codice}'>${t.codice}</button>  <strong>Nome:</strong> ${t.nome} - <strong>Costo</strong> ${t.costo} Euro - <strong>Descrizione:</strong> ${t.descrizione}
				</li>			
				</form>
			<% 	}}else{ %>
				<li><h4>Non Sono presenti Tipologie nel Sistema</h4></li>
			
			<%}%>
			
			</ul>
			${erroreTipo}
</body>

</html>
