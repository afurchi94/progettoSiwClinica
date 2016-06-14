package controllerInserimentoRisultatiEsame;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class Helper {
	public boolean validate(HttpServletRequest req, HttpServletResponse resp) {
		boolean correct = true;


		List<String> risultati= new LinkedList<String>();
		for(int i=0; i<30; i++){
			String s= "risultato".concat(String.valueOf(i));
			if(s.equals("")||s==null){
				req.setAttribute("risultatoError","Assicurati di aver Riempito TUTTI i campi");
				correct=false;
				if(s==null)
					break;
			}
			String ris= (String) req.getAttribute(s);
			risultati.add(ris);
		}
		req.setAttribute("risultati", risultati);



		return correct;
	}
}
