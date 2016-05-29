<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Clinica"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Visualizza Medici</title>
</head>
<body>
<h2>Quale Medico vuoi controllare?</h2>
<div>
	<form action="controllerMedico" method="get">

					<div class="form-group">
						<p>${codMedicoError}</p>
						<label>Codice Medico</label><input type="text" class="form-control"
							placeholder="Codice Medico" name="codMedico"
							value='${param["codMedico"]}'>
					</div>

					<button type="submit">Cerca</button>
  </form>
</div>
<br><br>
<div>
<h1>Elenco Medici della Clinica</h1>

<!-- Probabilmente questo lo sostituisco con una Tabella -->

<ul >
	<% for( int i=0; i<=medici.size(); i++){ %>	
		<li>${medici[i].codice} - ${medici[i].cognome} - ${medici[i].nome} - ${medici[i].specializzazione} - </li>			
	<% 	} %>
</ul>

</div>


</body>

</html>
