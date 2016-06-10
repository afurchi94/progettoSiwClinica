package controllerVisualizzaTipologie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Risultato;
import model.TipologiaEsame;

public class Helper {
	public boolean validate(HttpServletRequest req, HttpServletResponse resp) {
		boolean correct = true;

		String tipologia = req.getParameter("codTipologia");
	
	
		if (tipologia.equals("")) {
			correct = false;
		}


		return correct;
	}
}
