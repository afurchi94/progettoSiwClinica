<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import ="javax.servlet.http.HttpSession"%>
      <%@page import = "model.Paziente" %>
<%HttpSession s = request.getSession();
   Paziente p = (Paziente)s.getAttribute("pazienteLogin");
   boolean autorizzato = true;
   if (p!=null)
	   autorizzato=true;
   else 
   	   autorizzato = false;
   if (!autorizzato) {
   	   out.clear();
	   RequestDispatcher rd = application.getRequestDispatcher("/autenticazionePaziente.jsp");
   	   rd.forward(request, response);
	   return;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area Paziente</title>
</head>
<body>
<%if(session.getAttribute("amministratoreLogin")!=null){ %>
<div align="center"> Sei Autenticato come: ${pazienteLogin.username} Ruolo: Paziente </div><br>
<div align="center"> <a href="/progettoSiwClinica/homePage.jsp"><button type="button" onclick='<% session.removeAttribute("pazienteLogin");%>'>LogOut</button></a> </div>
<%}%>


<center> <h1>Area Paziente</h1></center>
<br>
<center> <h2>Scegli l'operazione vuoi effettuare:</h2></center>
			<div >	<a href="/progettoSiwClinica/consultaEsami.jsp"><h1>Consulta gli Esami Sostenuti</h1></a>	</div>
<br><br><br>
<a href="/progettoSiwClinica/homePage.jsp">	<button type="button">Torna alla HomePage</button></a>
</body>

</html>
