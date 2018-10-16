package pro.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.dao.AccountantDAOimpl;

/**
 * Servlet implementation class Delete_Action
 */
@WebServlet("/Delete_Action")
public class Delete_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Delete_Action() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getAttribute("username") != "") {
			String delete = request.getParameter("delete");
			if (delete != null) {
				try {
					// delete actually contains primary key of accountant table(i.,e contact)
					// so it will remove the data of that particular contact
					AccountantDAOimpl.removeAccountant(delete);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				response.sendRedirect(request.getContextPath() + "/Delete_Accountant");
			}
		} else {
			response.sendRedirect("/loginjsp.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
