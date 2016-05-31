package controllerAutenticazione.amministrazione;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.routines.DateValidator;

import model.Amministratore;

public class Helper {
	public boolean validate(HttpServletRequest req,HttpServletResponse resp) {
		boolean correct = true;

		String username = req.getParameter("username");
		String password = req.getParameter("password");
	
		if (username.equals("")) {
			correct = false;
			req.setAttribute("UsernameError", "Username vuoto");
		}
		if (password.equals("")) {
			correct = false;
			req.setAttribute("PasswordError", "Password vuota");
		}
		

		if (correct) {
			Amministratore amministratore = new Amministratore();
			amministratore.setPassoword(password);
			amministratore.setUsername(username);

			req.setAttribute("amministratore", amministratore);
		}

		return correct;
	}
}
