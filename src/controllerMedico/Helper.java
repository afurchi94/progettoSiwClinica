package controllerMedico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Risultato;
import model.TipologiaEsame;

public class Helper {
	public boolean validate(HttpServletRequest req, HttpServletResponse resp) {
		boolean correct = false;

		String codice = req.getParameter("codMedico");
	
	if(codice != null && !codice.equals("")){
			correct = true;
		}else
			req.setAttribute("erroreMedico", "Codice Medico Obbligatorio!");
	return correct;
	}
}
