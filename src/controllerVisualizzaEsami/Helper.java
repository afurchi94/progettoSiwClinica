package controllerVisualizzaEsami;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Esame;
public class Helper {
	public boolean validate(HttpServletRequest req, HttpServletResponse resp) {
		boolean correct = false;

		String id = req.getParameter("idEsame");
	
	if(id != null && !id.equals("")){
			correct = true;
		}else
			req.setAttribute("erroreId", "mi hai passato un codice nullo o vuoto");
	return correct;
	}
}
