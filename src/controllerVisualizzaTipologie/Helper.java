package controllerVisualizzaTipologie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Risultato;
import model.TipologiaEsame;

public class Helper {
	public boolean validate(HttpServletRequest req, HttpServletResponse resp) {
		boolean correct = false;

		String medico = req.getParameter("codMedico");
	
	if(medico != null && !medico.equals("")){
			correct = true;
		}else
			req.setAttribute("erroreMedico", "mi hai passato un codice nullo o vuoto");
	return correct;
	}
}
