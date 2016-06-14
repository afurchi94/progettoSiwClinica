package controllerRisultatiEsame;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Helper {
	public boolean validate(HttpServletRequest req, HttpServletResponse resp) {
		boolean correct = true;

		
		
	
		String idEsame = req.getParameter("idEsame");
		
		if (idEsame.equals("")) {
			correct = false;
			req.setAttribute("vuotoIdEsame", "Questo campo è obbligatorio");
		}
		//if (id==null) {
		//	correct = false;
		//	req.setAttribute("erroreIdEsame", "Questo campo è obbligatorio");
		//}

	
		return correct;
	}
}
