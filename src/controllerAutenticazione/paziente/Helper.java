package controllerAutenticazione.paziente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Amministratore;
import model.Paziente;

public class Helper {
	public boolean validate(HttpServletRequest req, HttpServletResponse resp) {
		boolean correct = true;
		
		String codiceFiscale = req.getParameter("codice");
		String password = req.getParameter("password");
		
		
		
		
			if (codiceFiscale.equals("")) {
				correct = false;
				req.setAttribute("CodiceError", "Codice vuoto");
			}
			if (password.equals("")) {
				correct = false;
				req.setAttribute("PasswordError", "Password vuota");
			}

			if (correct) {
				Paziente paziente = new Paziente();
				
				
				paziente.setPassword(password);
				paziente.setCodiceFiscale(codiceFiscale);

				req.setAttribute("paziente", paziente);
			}

			return correct;
	
	}
}
