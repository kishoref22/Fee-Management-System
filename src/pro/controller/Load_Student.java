package pro.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.dao.StudentDAOimpl;
import pro.pojo.Student;

@WebServlet("/Load_Student")
public class Load_Student extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Load_Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getAttribute("email") != "") {
			Student student = null;          
			String edit = request.getParameter("edit");
			try {
				student = StudentDAOimpl.getStudent(edit);
				if (student != null) {
					request.setAttribute("data", student);
					request.getRequestDispatcher("/WEB-INF/edit_student_form.jsp").forward(request, response);
					return;
				}
				// request.setAttribute("msg", "fetching data failed");
				// request.getRequestDispatcher("/WEB-INF/edit_students.jsp").forward(request,
				// response);
				// return;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("/loginjsp.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getAttribute("Accemail") != "") {
			Student student = null;

			String idu = request.getParameter("save");

			String name = request.getParameter("name");
			String course = request.getParameter("course");
			String email = request.getParameter("email");
			String id = request.getParameter("id");
			String phone_no = request.getParameter("phone_no");
			String date = request.getParameter("dob");
			java.util.Date udate = null;
			try {
				udate = new SimpleDateFormat("yyyyMMdd").parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Date sdate = new Date(udate.getTime());
			String address = request.getParameter("address");
			int fee_paid = Integer.parseInt(request.getParameter("fee_paid"));
			int fee_due = Integer.parseInt(request.getParameter("fee_due"));
			student = new Student(name, course, email, id, phone_no, sdate, address, fee_paid, fee_due);

			try {
				if (StudentDAOimpl.updateStudent(student, idu)) {
					request.setAttribute("msg", "updated successfully");
					response.sendRedirect(request.getContextPath() + "/Edit_Students");
					return;
				} else {

					request.setAttribute("msg", "update failed");
					request.getRequestDispatcher("/WEB-INF/edit_student_form.jsp").forward(request, response);
					return;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			response.sendRedirect("/loginjsp.jsp");
		}

	}

}
