<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Paziente"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="controllerPaziente" method="post">
		<p>
			${erroreNome}
		</p>
		<p>
			Nome <input type="text" name="nome" placeholder="Nome"
				value='${param["nome"]}' />

		</p>
		<p>
		${erroreCognome}
		</p>
		<p>
			Cognome <input type="text" name="cognome" placeholder="Cognome"
				value='${param["cognome"]}' />

		</p>
		<p>${erroreCodiceFiscale}</p>
		<p>
		Codice Fiscale <input type="text" name="codiceFiscale" placeholder="Cod Fiscale"
				value='${param["codiceFiscale"]}' />
		</p>
		
			<p>
			${erroreFormatoData}
			${erroredataNascita}
			</p>
		<p>
			Data di Nascita: <input type="text" name="dataNascita" placeholder="yyyy-mm-dd"
				value='${param["dataNascita"]}' />

		</p>
		<input type="submit" name="submit" value="Registra Paziente" />
		</p>
		${erroreInserimento}
		
	</form>
</body>
</html>