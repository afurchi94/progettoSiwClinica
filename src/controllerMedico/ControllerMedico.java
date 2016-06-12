package controllerMedico;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllerMedico.Action;
import controllerMedico.Helper;

@WebServlet("/controllerMedico")
public class ControllerMedico extends HttpServlet{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			String nextPage = "/vediMedici.jsp";
			Helper helper = new Helper();
			Action action = new Action();

			if (helper.validate(req, resp)){ 
				action.execute(req);
				nextPage = "/esamiMedico.jsp";
			}
			ServletContext application = req.getServletContext();
			RequestDispatcher dispatcher = application.getRequestDispatcher(nextPage);
			dispatcher.forward(req,resp);
		}
	}


