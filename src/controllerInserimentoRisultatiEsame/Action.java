package controllerInserimentoRisultatiEsame;



import javax.servlet.http.HttpServletRequest;

import model.*;

import java.util.*;
public class Action {
	private Facade facade;

	public void execute(HttpServletRequest req) {
		facade = new Facade();
		Esame e= new Esame();
		e= (Esame) req.getAttribute("esame");
		List<String> lista= (List<String>) req.getAttribute("risultati");
		int i=0;
		for(String r: lista){
			facade.inserisciRisultatoEsame(e, r, i);
			i++;
		}
	}

}
