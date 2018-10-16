package pro.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.dao.StudentDAOimpl;
import pro.pojo.Student;

/**
 * Servlet implementation class Student_Details
 */
@WebServlet("/Student_Details")
public class Student_Details extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Student_Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getAttribute("Accemail") != "") {

			Student student = null;
			String details = request.getParameter("details");
			if (details != "") {
				final int total_fee = 9000;
				try {
					student = StudentDAOimpl.getStudent(details);
					int fee_paid = student.getFee_paid();
					request.setAttribute("fee_paid", fee_paid);
					int fee_due = student.getFee_due();
					request.setAttribute("fee_due", fee_due);
					request.setAttribute("total_fee", total_fee);
					request.setAttribute("student", student);
					getServletContext().getRequestDispatcher("/WEB-INF/student_details.jsp").forward(request, response);

				} catch (SQLException e) {

					e.printStackTrace();
					request.setAttribute("msg", "failed to retrieve");
					getServletContext().getRequestDispatcher("/WEB-INF/view_students.jsp").forward(request, response);
				}

			} else {
				response.sendRedirect("/WEB-INF/view_students.jsp");
			}

		} else {

			response.sendRedirect("/loginjsp.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
	}

}
