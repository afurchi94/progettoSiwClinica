package controllerRisultatiEsame;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllerRisultatiEsame.Action;
import controllerRisultatiEsame.Helper;

@WebServlet("/controllerRisultatiEsame")
public class ControllerRisultatiEsame extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nextPage = "/scegliEsame.jsp";
		Helper helper = new Helper();
		Action action = new Action();

		if (helper.validate(req, resp)) {
			action.execute(req);
			nextPage="/inserisciRisultatiEsame.jsp";
		}

		ServletContext application = req.getServletContext();
		RequestDispatcher dispatcher = application.getRequestDispatcher(nextPage);
		dispatcher.forward(req,resp);
	}
}
