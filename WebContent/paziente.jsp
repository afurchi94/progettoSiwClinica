<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="model.Paziente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% session.getAttribute("paziente"); %>
<h1>Hai Inserito un nuovo Paziente con questi dati:</h1>
	<p>Nome: ${paziente.nome}</p>
	<p>Cognome: ${paziente.cognome}</p>
	<p>Cod. Fiscale: ${paziente.codiceFiscale}</p>
	<strong>
	<p>Password per accedere all'area Paziente: ${paziente.password}</p>
	</strong>
	<p>Data di Nascita: ${paziente.dataNascita}</p>
	<br><BR>
	<a href="/progettoSiwClinica/homePage.jsp">	<button type="button">Torna alla HomePage</button></a>
</body>
</html>