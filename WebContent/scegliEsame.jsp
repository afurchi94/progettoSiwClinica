<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci Risultati Esame</title>
</head>
<body>


<div align="center">
<h1>Inserisci Qui il Codice dell`Esame che vuoi Aggiornare con i Risultati:</h1>

<form action="controllerEsame" method="get">
						<div>
						<p>${CodiceError}</p>
						<label>Codice</label> <input type="text" class="form-control"
							placeholder="Codice Esame" name="codice"
							value='${param["codice"]}'>
					</div>
						<button type="submit" class="btn btn-default">Cerca</button>
</form>
</div>
</body>
>>>>>>> refs/remotes/origin/master
</html>
