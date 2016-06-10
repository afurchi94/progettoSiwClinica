package controllerVisualizzaTipologie;

import model.TipologiaEsame;

import javax.servlet.http.HttpServletRequest;

import model.*;
import java.util.*;
public class Action {
	private Facade facade;

	public void execute(HttpServletRequest req) {
		facade = new Facade();
		TipologiaEsame tipo = facade.scegliTipologiaEsame(req.getParameter("codTipologia"));		
		req.setAttribute("tipologia", tipo);
	}

}
