package controllerEsame;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllerEsame.Action;
import controllerEsame.Helper;

@WebServlet("/controllerEsame")
public class ControllerEsame extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nextPage = "/newEsame.jsp";
		Helper helper = new Helper();
		Action action = new Action();

		if (helper.validate(req, resp)){ 
			action.execute(req);
			nextPage="/confermaEsame.jsp";
		}
		ServletContext application = req.getServletContext();
		RequestDispatcher dispatcher = application.getRequestDispatcher(nextPage);
		dispatcher.forward(req,resp);
	}

}
