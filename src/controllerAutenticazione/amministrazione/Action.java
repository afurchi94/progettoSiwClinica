package controllerAutenticazione.amministrazione;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Amministratore;
import model.Facade;

public class Action {
	public String esegui(HttpServletRequest req) {
		Facade facade = new Facade();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Amministratore amministratore = facade.loginAmministrazione(username, password);
		if (amministratore != null) {
			HttpSession session = req.getSession();
			session.setAttribute("amministratore", amministratore);
			return "OK";
		} else{
			req.setAttribute("DatiError", "I dati inseriti non sono corretti!");
			return "KO";
		}
	}

}
