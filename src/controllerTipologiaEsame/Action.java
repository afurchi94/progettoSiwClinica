package controllerTipologiaEsame;

import model.TipologiaEsame;

import javax.servlet.http.HttpServletRequest;

import model.*;

import java.util.*;
public class Action {
	private Facade facade;

	@SuppressWarnings("unchecked")
	public void execute(HttpServletRequest req) {
		facade = new Facade();
		
		
		facade.inserisciTipologiaEsame((TipologiaEsame) req.getAttribute("tipologia"),(List<String>)req.getAttribute("risultati") ,(List<String>) req.getAttribute("preRequisiti"));

	}

}
