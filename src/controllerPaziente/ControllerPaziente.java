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
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nextPage = "/registerPaziente.jsp";

		Helper helper = new Helper();
		Action action = new Action();

		if (helper.validate(req, resp)) {
			action.execute(req);
		}
		//serve il dispatcher!

	}

}
