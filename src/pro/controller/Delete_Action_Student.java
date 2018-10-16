package pro.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.dao.StudentDAOimpl;

/**
 * Servlet implementation class Delete_Action_Student
 */
@WebServlet("/Delete_Action_Student")
public class Delete_Action_Student extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Delete_Action_Student() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getAttribute("Accemail") != "") {
			String id = request.getParameter("delete");
			try {
				if (StudentDAOimpl.removeStudent(id)) {
					request.setAttribute("msg", "deleted successfully");
					getServletContext().getRequestDispatcher("/Delete_Student").forward(request, response);
				} else {
					request.setAttribute("msg", "failed to remove");
					getServletContext().getRequestDispatcher("/Delete_Student").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("/loginjsp.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
