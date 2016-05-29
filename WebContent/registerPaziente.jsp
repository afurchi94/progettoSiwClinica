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
			<%
				if (request.getAttribute("erroreNome") != null)
					out.print(request.getAttribute("erroreNome"));
			%>
		</p>
		<p>
			Nome <input type="text" name="nome" placeholder="Nome"
				value="<%if (request.getParameter("nome") != null)
				out.print(request.getParameter("nome"));%>" />

		</p>
		<p>
			<%
				if (request.getAttribute("erroreCognome") != null)
					out.print(request.getAttribute("erroreCognome"));
			%>
		</p>
		<p>
			Cognome <input type="text" name="cognome" placeholder="Cognome"
				value="<%if (request.getParameter("cognome") != null)
				out.print(request.getParameter("cognome"));%>" />

		</p>
		<p>
			<%
				if (request.getAttribute("erroreDataNascita") != null)
					out.print(request.getAttribute("erroreDataNascita"));
			if (request.getAttribute("erroreFormatoData") != null)
				out.print(request.getAttribute("erroreFormatoData"));
			%>
		</p>
		<p>
			Data di Nascita: <input type="text" name="dataNascita" placeholder="yyyy-mm-dd"
				value="<%if (request.getParameter("dataNascita") != null)
				out.print(request.getParameter("dataNascita"));%>" />

		</p>
		<input type="submit" name="submit" value="invia" />
		</p>
	</form>
</body>
</html>