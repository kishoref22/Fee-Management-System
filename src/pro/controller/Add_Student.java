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

import pro.pojo.Student;
import pro.dao.StudentDAOimpl;

/**
 * Servlet implementation class Add_Student
 */
@WebServlet("/Add_Student")
public class Add_Student extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Add_Student() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getAttribute("Accemail") != "") {
		String name = request.getParameter("name");
		String course = request.getParameter("course");
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		String phone_no = request.getParameter("phone_no");
		String date = request.getParameter("dob");
		java.util.Date udate = null;
		try {
			udate = new SimpleDateFormat("yyyyMMdd").parse(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date sdate = new Date(udate.getTime());
		String address = request.getParameter("address");
		int fee_paid = Integer.parseInt(request.getParameter("fee_paid"));
		int fee_due = Integer.parseInt(request.getParameter("fee_due"));

		Student student = new Student(name, course, email, id, phone_no, sdate, address, fee_paid, fee_due);
		try {
			if (StudentDAOimpl.addStudent(student)) {
				request.setAttribute("msg", "successfully added");
				getServletContext().getRequestDispatcher("/add_student.jsp").forward(request, response);
				return;
			} else {
				request.setAttribute("msg", "failed to add student");
				getServletContext().getRequestDispatcher("/add_student.jsp").forward(request, response);
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}else {
		response.sendRedirect("loginjsp.jsp");
	}
	
		
	}

}
