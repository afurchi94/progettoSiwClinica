package controllerAutenticazione.paziente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Paziente;
import model.Facade;

public class Action {
	public String esegui(HttpServletRequest req) {
		Facade facade = new Facade();
		String codiceFiscale = req.getParameter("codice");
		String password = req.getParameter("password");
		Paziente paziente = facade.loginPaziente(codiceFiscale, password);
		if (paziente != null) {
			HttpSession session = req.getSession();
			
			session.setAttribute("pazienteLogin", paziente);
			return "OK";
		} else{
			req.setAttribute("DatiError", "I dati inseriti non sono corretti!");
			return "KO";
		}
	}

}