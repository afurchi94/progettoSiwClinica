package controllerVisualizzaTipologie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Helper {
	public boolean validate(HttpServletRequest req, HttpServletResponse resp) {
		boolean correct = false;

		String codice = req.getParameter("codTipologia");
	
	if(codice != null && !codice.equals("")){
			correct = true;
		}else
			req.setAttribute("erroreTipo", "mi hai passato un codice nullo o vuoto");
	return correct;
	}
}
