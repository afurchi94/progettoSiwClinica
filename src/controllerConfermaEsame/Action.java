package controllerConfermaEsame;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.routines.DateValidator;

import model.*;

import java.util.*;
public class Action {
	private Facade facade;

	public void execute(HttpServletRequest req) {
		
		
		String tipologia= req.getParameter("tipologia");
		String dataEsame= req.getParameter("dataEsame");
		String codFiscale= req.getParameter("codFiscale");
		String codMedico= req.getParameter("codMedico");
		String pattern = "yyyy-MM-dd";
		DateValidator validator = new DateValidator();
		Date data = validator.validate(dataEsame, pattern);
		
		facade= new Facade();
		facade.inserisciDatiEsame(tipologia, codFiscale, data, codMedico);
	
				
				
	}

}
