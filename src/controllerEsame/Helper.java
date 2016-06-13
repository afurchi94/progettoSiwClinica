package controllerEsame;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.routines.DateValidator;

import javax.servlet.http.HttpServletResponse;


public class Helper {
	public boolean validate(HttpServletRequest req, HttpServletResponse resp) {
		boolean correct = true;

		String tipologia=null;
		String dataEsame=null;
		String codFiscale=null;
		String codMedico=null;
		String pattern = "yyyy-MM-dd";
		DateValidator validator = new DateValidator();
		
		
		if(req.getParameter("tipologia")!= null)
		tipologia= req.getParameter("tipologia");
		if(req.getParameter("dataEsame")!=null)
		dataEsame= req.getParameter("dataEsame");
		if(req.getParameter("codFiscale")!=null)
		codFiscale= req.getParameter("codFiscale");
		if(req.getParameter("codMedico")!=null)
		codMedico= req.getParameter("codMedico");
		
		
		
		
		
		if(codMedico==null){
			correct = false;
			req.setAttribute("codMedicoError", "Campo Obbligatorio!");
		}
		
		if(codFiscale==null){
			correct = false;
			req.setAttribute("codFiscaleError", "Campo Obbligatorio!");
		}
			
		if(dataEsame==null ){
			correct = false;
			req.setAttribute("dataError", "Campo Obbligatorio!");
		}else if(!validator.isValid(dataEsame, pattern)) {
			correct = false;
			req.setAttribute("erroreFormatoData", "Il formato inserito è errato");
		}
			
		if(tipologia==null){
			correct = false;
			req.setAttribute("tipologiaError", "La tipologia inserita è vuota o Nulla");
		}		
		
		return correct;
	}
}
