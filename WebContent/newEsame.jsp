<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="java.util.*"%>
  <%@ page import="model.TipologiaEsame"%>
   <%@ page import="model.Facade"%>
   
   
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="style.css">
<title>Inserimento Esame</title>
</head>
<body>
<center>
<h1>Inserisci i dati del nuovo Esame</h1>
<div>

<form  class="form-inline" action="controllerEsame" method="get">
<!-- il Type Radio serve a mettere una spunta sulla nostra scelta della tipologia. Questa parte è meglio vista quando è finita con JS in cui aggiorniamo le nuove tipologie -->
					<div class="form-group">
						<p>${tipologiaError}</p>
						<label>Tipologia Esame</label>
						
						<select name="tipologia" >
							<% 
							List<TipologiaEsame> tipologie= new Facade().getTipologieEsame();//me la devo far passare dalla request o session dalla named query
							for(TipologiaEsame t: tipologie){ 
							request.setAttribute("t", t);%>
								<option class="form-control"  value="${t.nome}"> ${t.nome}</option><br>
							<% 	} %>
						</select>
					</div><br>
					
	<!-- L-inserimento della data ora è un po barbaro, ma dovrebbe funzionare... Se non funziona dobbiamo per forza usare quello del prof-->				
					<div class="form-group">
						<p>${dataError}</p>
						<p>${erroreFormatoData}</p>
						<label>Da svolgere in Data </label> <input type="data" class="form-control"
							placeholder="yyyy-mm-dd" name="dataEsame" value='${param["dataEsame"]}'>
					</div><br>
					
					<div class="form-group">
						<p>${codFiscaleError}</p>
						<label>Codice Fiscale Paziente</label><input type="text" class="form-control"
							placeholder="Codice Fiscale Paziente" name="codFiscale"
							value='${param["codFiscale"]}'>
					</div><br>
					
						<div class="form-group">
						<p>${codMedicoError}</p>
						<label>Codice Medico</label> <input type="text" class="form-control"
							placeholder="Codice Medico" name="codMedico"
							value='${param["codMedico"]}'>
					</div><br>
					<br><br><br>
					
					
				
					<button type="submit" class="btn btn-primary btn-lg" class="btn btn-default">Crea Esame</button>
				</form>
	


</div>
</center>












</body>

</html>
