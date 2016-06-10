package controllerPaziente;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.validator.routines.DateValidator;

import model.Facade;
import model.Paziente;

import java.util.*;

public class Action {

	public void esegui(HttpServletRequest req) {
		
	 Facade facade = new Facade();
	 Paziente paziente=(Paziente) req.getAttribute("paziente");
	 //Da Modificare, ma lo tengo solo perchè @GeneratedValue da problemi
	 paziente.setPassword("0");

		// metti le date con l'annotazione nella classe Paziente.
	 facade.inserisciPaziente(paziente);
	 facade.confermaInserimentoPaziente();
	 HttpSession session = req.getSession();
	 session.setAttribute("paziente", paziente);
	}
}