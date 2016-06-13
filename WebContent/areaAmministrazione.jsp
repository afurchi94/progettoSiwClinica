<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="javax.servlet.http.HttpSession"%>
  <%@ page import ="model.Amministratore" %>
<% Amministratore a = (Amministratore)session.getAttribute("amministratoreLogin");
   boolean autorizzato = true;
   if (a!=null)
	   autorizzato=true;
   else 
   	   autorizzato = false;
   if (!autorizzato) {
   	   out.clear();
	   RequestDispatcher rd = application.getRequestDispatcher("/autenticazioneAmministrazione.jsp");
   	   rd.forward(request, response);
	   return;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area Amministrazione</title>
</head>
<body>

<%if(session.getAttribute("amministratoreLogin")!=null){ %>
<div align="center"> Sei Autenticato come: ${amministratoreLogin.username} Ruolo: Amministratore </div><br>
<div align="center"> <a href="/progettoSiwClinica/homePage.jsp"><button type="button" onclick='<% session.setAttribute("amministratoreLogin",null);%>'>LogOut</button></a> </div>
<%}%>

<center> <h1>Area Amministrazione</h1></center>
<br>
<center> <h2>Scegli l'operazione vuoi effettuare</h2></center>
			<div >	<a href="/progettoSiwClinica/newEsame.jsp"><h1>Crea Nuovo Esame</h1></a>	</div>
			<br>
			<div >	<a href="/progettoSiwClinica/newTipologia.jsp"><h1>Crea Nuova Tipologia di Esame</h1></a></div>
			<br>
			<div  >	<a href="/progettoSiwClinica/vediMedici.jsp"><h1>Visualizza Esami dei Medici</h1></a></div>
			<br>
			<div>	<a href="/progettoSiwClinica/scegliEsame.jsp"><h1>Inserisci Risultati di un Esame</h1></a>	</div>
			<br>
			<div>	<a href="/progettoSiwClinica/registerPaziente.jsp"><h1>Registra Nuovo Paziente</h1></a>	</div>

<br><br>
<a href="/progettoSiwClinica/homePage.jsp">	<button type="button">Torna alla HomePage</button></a>
</body>

</html>
