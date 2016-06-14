<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.TipologiaEsame"%>
    <%@ page import="model.Prerequisito"%>
        <%@ page import="model.Risultato"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="style.css">
<title>Dettagli Tipologia</title>
</head>
<body>
<center><h1>Dettagli Tipologia:</h1>
<ul>
<li><strong>Nome:</strong> ${tipologia.nome}</li>
<li><strong>Descrizione:</strong> ${tipologia.descrizione}</li>
<li><strong>Costo:</strong> ${tipologia.costo} Euro</li>
<li><strong>Pre-Requisiti:</strong>

<ul >
	<%TipologiaEsame tipologiaCorrente= (TipologiaEsame)request.getAttribute("tipologia");
	if(tipologiaCorrente!=null){
		if(tipologiaCorrente.getPrerequisiti().size() >0){
			for( Prerequisito p : tipologiaCorrente.getPrerequisiti()){ 
				request.setAttribute("p", p);
	%>	
				<li><strong>${p.nome}</strong> : ${p.descrizione}</li>
	<% 		}
		}else{ %>
			<li>Tipologia Senza Prerequisiti</li>
		<%} %>
</ul>
<BR>
		<strong>Tipologia di Risultati Esame:</strong> 

	<ul >
		<%if(tipologiaCorrente.getRisultati().size() >0){ 
			for( Risultato r : tipologiaCorrente.getRisultati()){ 
				request.setAttribute("r", r);%>	
				<li>${r.nome}</li>		
		<% 	}
		  }else{ %>
			<li>Tipologia Senza Risultati</li>
		<%} 
	}else{%>
		<li>Tipologia Corrente Nulla</li>
	<%} %>
</ul>


</ul>


<br><br>
<a href="/progettoSiwClinica/consultaTipologieEsame.jsp"><button class="btn btn-primary"type="button">Torna Indietro</button></a>
<a href="/progettoSiwClinica/homePage.jsp"><button class="btn btn-primary"type="button">Torna alla Home Page</button></a>

</center>
</body>

</html>
