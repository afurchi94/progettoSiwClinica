package controllerPaziente;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Facade;

@WebServlet("/controllerPaziente")
public class ControllerPaziente extends HttpServlet {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String nextPage = "/registerPaziente.jsp";

		Helper helper = new Helper();
		Action action = new Action();

		if (helper.validate(req, resp)) {
			action.esegui(req);
		}

		if (helper.validate(req, resp)) {
			action.esegui(req);
			nextPage = "/paziente.jsp";
		}else
			req.setAttribute("erroreInserimento", "C'è stato un errore nell'inserimento del Paziente");

		
	
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(req, resp);

	}

}
