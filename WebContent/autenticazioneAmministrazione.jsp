<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="style.css">
<title>Autenticazione Amministrazione</title>
</head>
<body>


	<div>
		<h2 align="center">Inserisci i Dati da Amministratore</h2>
		<div class="col-md-4 col-md-offset-4">

			<div class="form_container">
				<!-- controller Amministrazione da implementare-->
				<form action="controllerAutenticazioneAmministrazione" method="post">
					<div class="form-group">

						<!-- Messaggio di errore di login errato da implementare-->
						<p>${DatiError}</p>
						<p>${UsernameError}</p>
						<label>Username</label> <input type="text" class="form-control"
							placeholder="Username" name="username"
							value='${param["username"]}'>
					</div>

					<div class="form-group">
						<p>${PasswordError}</p>
						<label>Password</label> <input type="password"
							class="form-control" placeholder="Password" name="password">
					</div>
					<button type="submit" class="btn btn-warning">Accedi</button>
				</form>
			</div>
		</div>
	</div>

<br><br><br><br>
<center><a href="/progettoSiwClinica/homePage.jsp">	<button class="btn btn-primary"type="button">Torna alla HomePage</button></a></center>

</body>

</html>
