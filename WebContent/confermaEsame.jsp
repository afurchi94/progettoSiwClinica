<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="java.util.*"%>
  <%@ page import="model.TipologiaEsame"%>
   <%@ page import="model.Facade"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Conferma Creazione Esame</title>
</head>
<body>
<div>
	 	<form action="controllerConfermaEsame" method="get">  
			<center><h1> Vuoi modificare i dati da te inseriti prima di andare avanti?:</h1></center>
			<p>
			<ul>
				<p>${tipologiaError}</p>
				<li>Tipologia: <select name="tipologia" >
							<% 
							List<TipologiaEsame> tipologie= new Facade().getTipologieEsame();//me la devo far passare dalla request o session dalla named query
							for(TipologiaEsame t: tipologie){ 
							request.setAttribute("t", t);%>
								<option class="form-control"  value="${t.nome}"> ${t.nome}</option><br>
							<% 	} %>
						</select></li>
				<p>${dataError}</p><p>${erroreFormatoData}</p>
				<li>Data Esame: <div class="form-group">
						 <input type="data" class="form-control"
							placeholder="yyyy-mm-dd" name="dataEsame" value='${param["dataEsame"]}'>
					</div></li>
				<p>${codFiscaleError}</p>
				<li>Codice Fiscale: <div class="form-group">
						
						<input type="text" class="form-control"
							placeholder="Codice Fiscale Paziente" name="codFiscale"
							value='${param["codFiscale"]}'>
					</div></li>
				<p>${codMedicoError}</p>
				<li>Codice Medico: <div class="form-group">
						 <input type="text" class="form-control"
							placeholder="Codice Medico" name="codMedico"
							value='${param["codMedico"]}'>
					</div></li>
			</ul>
			</p>
			<div align="center">
			<h1>Desideri procedere con la creazione dell`Esame?</h1>
			<button type="submit"  onclick="alert('Esame Creato con Successo')">Conferma Creazione Esame</button>
			<a href="/progettoSiwClinica/newEsame.jsp">	<button type="button">Torna Indietro</button></a>
	 	</form> 
		</div>
		</div>

</body>

</html>
