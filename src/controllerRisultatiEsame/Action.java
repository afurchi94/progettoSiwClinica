package controllerRisultatiEsame;

import model.TipologiaEsame;

import javax.servlet.http.HttpServletRequest;

import model.*;

import java.util.*;
public class Action {
	private Facade facade;

	public void execute(HttpServletRequest req) {
		facade = new Facade();
		
	
		Esame esame = facade.scegliEsame(req.getParameter("idEsame"));
		req.setAttribute("esame", esame);
	}

}
