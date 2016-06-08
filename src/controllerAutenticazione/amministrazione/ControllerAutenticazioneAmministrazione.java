package controllerAutenticazione.amministrazione;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controllerAutenticazioneAmministrazione")
public class ControllerAutenticazioneAmministrazione extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Action action = new Action();
		// campi obbligatori e messaggio dopo che la password o l'username sono
		// errati.
		Helper helper = new Helper();
		String prossimaPagina = "/autenticazioneAmministrazione.jsp";

		if (helper.validate(req, resp)) {
			String esito = action.esegui(req);
			if (esito.equals("OK"))
				prossimaPagina = "/areaAmministrazione.jsp";
		}

		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(prossimaPagina);
		rd.forward(req, resp);
	}

}
