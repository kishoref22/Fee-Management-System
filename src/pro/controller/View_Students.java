package pro.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.dao.StudentDAOimpl;
import pro.pojo.Student;

@WebServlet("/View_Students")
public class View_Students extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public View_Students() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                            
		if (request.getAttribute("Accemail") != "") {
			ArrayList<Student> students = null;
			try {            
				students = (ArrayList<Student>) StudentDAOimpl.viewStudents();
				for(Student stu : students) {
					if(stu.getEmail()==null) {
						try {
							throw new Exception("gjh");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if (students != null) {
					request.setAttribute("students_data", students);
					getServletContext().getRequestDispatcher("/WEB-INF/view_students.jsp").forward(request, response);
					return;  
				} else {  
					request.setAttribute("message", "no data in students table");
					getServletContext().getRequestDispatcher("/WEB-INF/view_students.jsp").forward(request, response);
				    return;
				}           
			} catch (SQLException e) {
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
