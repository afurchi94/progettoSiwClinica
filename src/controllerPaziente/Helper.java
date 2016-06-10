package controllerPaziente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.routines.DateValidator;

import model.Paziente;
import java.util.*;

public class Helper {
	public boolean validate(HttpServletRequest req, HttpServletResponse resp) {
		boolean correct = true;

		String nome = req.getParameter("nome");
		String cognome = req.getParameter("cognome");
		String codiceFiscale= req.getParameter("codiceFiscale");
		String pattern = "yyyy-MM-dd";
		DateValidator validator = new DateValidator();
		String dataNascita = req.getParameter("dataNascita");
		if (codiceFiscale.equals("")) {
			correct = false;
			req.setAttribute("erroreCodiceFiscale", "Questo campo � obbligatorio");
		}
		if (nome.equals("")) {
			correct = false;
			req.setAttribute("erroreNome", "Questo campo � obbligatorio");
		}
		if (cognome.equals("")) {
			correct = false;
			req.setAttribute("erroreCognome", "Questo campo � obbligatorio");
		}
		if (dataNascita.equals("") || dataNascita == null) {
			correct = false;
			req.setAttribute("erroreDataNascita", "Questo campo � obbligatorio");

		} else if (!validator.isValid(dataNascita, pattern)) {
			correct = false;
			req.setAttribute("erroreFormatoData", "Il formato inserito � errato");
		}

		if (correct) {
			Paziente paziente = new Paziente();
			paziente.setCognome(cognome);
			paziente.setNome(nome);
			paziente.setCodiceFiscale(codiceFiscale);
			// il metodo validate converte la string in una data di quel
			// formato.
			paziente.setDataNascita(validator.validate(dataNascita, pattern));

			req.setAttribute("paziente", paziente);
		}

		return correct;
	}
}
