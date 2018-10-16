package pro.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.dao.AccountantDAOimpl;
import pro.pojo.Accountant;

@WebServlet("/View_Accountant")
public class View_Accountant extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public View_Accountant() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Accountant> acc = null;
		if (request.getAttribute("username") != "") {
			try {
				acc = (ArrayList<Accountant>) AccountantDAOimpl.viewAccountants();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (acc == null) {
				request.setAttribute("err", "failed");
				response.sendRedirect("/WEB-INF/view_accountant.jsp");
				return;
			} else {
				request.setAttribute("dataList", acc);
				RequestDispatcher rd2 = request.getRequestDispatcher("/WEB-INF/view_accountant.jsp");
				
				rd2.forward(request, response);
				return;
			}
		} else {
			response.sendRedirect("/loginjsp.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
