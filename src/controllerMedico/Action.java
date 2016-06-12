package controllerMedico;

import model.Medico;

import javax.servlet.http.HttpServletRequest;

import model.*;
import java.util.*;
public class Action {
	private Facade facade;

	public void execute(HttpServletRequest req) {
		facade = new Facade();
		Medico medico = facade.selezionaMedico(req.getParameter("codMedico"));		
		req.setAttribute("medico", medico);
	}

}
