<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hai Inserito un nuovo Paziente con questi dati:</h1>
	<p>Nome: ${paziente.nome}</p>
	<p>Cognome: ${paziente.cognome}</p>
	<strong>
	<p>Username: ${paziente.username}</p>
	<p>Password: ${paziente.password}</p>
	</strong>
	<p>Cod. Fiscale: ${paziente.codFiscale}</p>
	<p>Data di Nascita: ${paziente.dataNascita}</p>
</body>
</html>