package controllerEsame;

import model.Esame;

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
	
		req.setAttribute("tipologia", tipologia);
		req.setAttribute("dataEsame", dataEsame );
		req.setAttribute("codFiscale", codFiscale );
		req.setAttribute("codMedico", codMedico);
				
	}

}
