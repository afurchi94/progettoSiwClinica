package controllerPaziente;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.routines.DateValidator;

import model.Facade;
import model.Paziente;
import java.util.*;

public class Action {
	private Facade facade;
	public void execute(HttpServletRequest req) {
		
		facade = new Facade();
		// metti le date con l'annotazione nella classe Paziente.
		facade.inserisciPaziente((Paziente) req.getAttribute("paziente"));
	}
}