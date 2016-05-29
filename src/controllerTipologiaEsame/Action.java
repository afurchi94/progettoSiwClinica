package controllerTipologiaEsame;

import model.TipologiaEsame;

import javax.servlet.http.HttpServletRequest;

import model.*;

public class Action {
	private Facade facade;

	public void execute(HttpServletRequest req) {
		facade = new Facade();
		facade.autenticazioneAmministrazione();
		facade.inserimentoTipologiaEsame((TipologiaEsame) req.getAttribute("tipologia"),
				(Long) req.getAttribute("codicePrerequisito"),(Risultato) req.getAttribute("risultato"));

	}

}
