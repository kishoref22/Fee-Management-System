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

// this servlet is to fetch data into delete_accountant.jsp page in tabular form
@WebServlet("/Delete_Accountant")
public class Delete_Accountant extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Delete_Accountant() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getAttribute("username") != "") {
			
			ArrayList<Accountant> acc = null;

			try {
				acc = (ArrayList<Accountant>) AccountantDAOimpl.viewAccountants();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (acc == null) {
				request.setAttribute("err", "failed");
				response.sendRedirect("WEB-INF/delete_accountant.jsp");
				return;
			} else {
				request.setAttribute("data", acc);
				RequestDispatcher rd1 = request.getRequestDispatcher("/WEB-INF/delete_accountant.jsp");
				rd1.forward(request, response);
			}

		} else {
			response.sendRedirect("/loginjsp.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
