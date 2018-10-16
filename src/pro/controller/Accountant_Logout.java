package pro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Accountant_Logout
 */
@WebServlet("/Accountant_Logout")
public class Accountant_Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Accountant_Logout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     HttpSession session = request.getSession(false);
     session.removeAttribute("Accemail");
     session.invalidate();
     response.sendRedirect("loginjsp.jsp");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
