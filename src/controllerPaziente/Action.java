package controllerPaziente;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.SecureRandom;
import java.math.BigInteger;

import model.Facade;
import model.Paziente;



public class Action {

	public void esegui(HttpServletRequest req) {
		
	 Facade facade = new Facade();
	 Paziente paziente=(Paziente) req.getAttribute("paziente");
	 //Da Modificare, ma lo tengo solo perchè @GeneratedValue da problemi
	 //Genera una Password RANDOM per ogni nuovo Paziente
	 SecureRandom random = new SecureRandom();
	 String password = new BigInteger(130, random).toString(32).substring(0, 8);
	 paziente.setPassword(password);

		
	 facade.inserisciPaziente(paziente);
	 HttpSession session = req.getSession();
	 session.setAttribute("paziente", paziente);
	}
}