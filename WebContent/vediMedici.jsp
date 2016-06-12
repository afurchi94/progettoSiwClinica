<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ page import="java.util.*"%>
    <%@ page import="model.Facade"%>
    <%@ page import="model.Medico"%>
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
						<p>${erroreMedico}</p>
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
	
				<% Facade facade = new Facade();
				List<Medico> medici = facade.getMedici();
				if(medici.size()>0){
				for(Medico m : medici){ 
				request.setAttribute("m", m);%>	
		<li>${m.codice} - ${m.cognome} - ${m.nome} - ${m.specializzazione} </li>			
		<%}}else{ %>
			<li>Non ci sono medici nella clinica</li>
		<% 	} %>
</ul>

</div>


</body>

</html>
