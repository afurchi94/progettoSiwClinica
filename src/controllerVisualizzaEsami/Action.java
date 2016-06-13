package controllerVisualizzaEsami;

import model.Esame;

import javax.servlet.http.HttpServletRequest;

import model.*;
import java.util.*;
public class Action {
	private Facade facade;

	public void execute(HttpServletRequest req) {
		facade = new Facade();
		String codId = req.getParameter("idEsame");
		Esame esame = facade.scegliEsame(codId);		
		req.setAttribute("esame", esame);
	}

}
