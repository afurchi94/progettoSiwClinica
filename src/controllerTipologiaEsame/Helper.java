package controllerTipologiaEsame;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Risultato;
import model.TipologiaEsame;

public class Helper {
	public boolean validate(HttpServletRequest req, HttpServletResponse resp) {
		boolean correct = true;

		String nome = req.getParameter("nome");
		String codice = req.getParameter("codice");
		String descrizione = req.getParameter("descrizione");
		Double costo = null;
		String nomeRisultato = req.getParameter("nomeRisultato");
		String risultato = req.getParameter("risultato");
		Long codicePrerequisito = Long.parseLong(req.getParameter("codicePrerequisito"));
		if (!req.getParameter("costo").equals(""))
			costo = Double.parseDouble(req.getParameter("costo"));

		if (nome.equals("")) {
			correct = false;
			req.setAttribute("nomeError", "Questo campo è obbligatorio");
		}

		if (codice.equals("")) {
			correct = false;
			req.setAttribute("codiceError", "Questo campo è obbligatorio");
		}

		if (descrizione.equals("")) {
			correct = false;
			req.setAttribute("descrizioneError", "Questo campo è obbligatorio");
		}

		if (costo == null) {
			correct = false;
			req.setAttribute("costoError", "Questo campo è obbligatorio");
		}

		if (nomeRisultato.equals("")) {
			correct = false;
			req.setAttribute("nomeRisultatoError", "Questo campo è obbligatorio");
		}
		if (risultato.equals("")) {
			correct = false;
			req.setAttribute("risultatoError", "Questo campo è obbligatorio");
		}

		if (codicePrerequisito==null) {
			correct = false;
			req.setAttribute("codicePrerequisitoError", "Questo campo è obbligatorio");
		}

		if (correct) {
			TipologiaEsame tipologia = new TipologiaEsame();
			tipologia.setCodice(codice);
			tipologia.setNome(nome);
			tipologia.setDescrizione(descrizione);
			tipologia.setCosto(costo);

			Risultato ris = new Risultato();
			ris.setNome(nomeRisultato);
			ris.setRisultato(risultato);

			req.setAttribute("risultato", ris);
			req.setAttribute("codicePrerequisito", codicePrerequisito);
			req.setAttribute("tipologia", tipologia);
		}

		return correct;
	}
}
