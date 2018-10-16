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

/**
 * Servlet implementation class Delete_Student
 */
@WebServlet("/Delete_Student")
public class Delete_Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Delete_Student() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getAttribute("Accemail") != "") {
			ArrayList<Student> students = null;
			try {            
				students = (ArrayList<Student>) StudentDAOimpl.viewStudents();
				if (students != null) {
					request.setAttribute("students_data", students);
					getServletContext().getRequestDispatcher("/WEB-INF/delete_student.jsp").forward(request, response);
					return;  
				} else {  
					request.setAttribute("message", "no data in students table");
					getServletContext().getRequestDispatcher("/WEB-INF/delete_student.jsp").forward(request, response);
				}           
			} catch (SQLException e) {
				e.printStackTrace();
			}             
		} else {            
			response.sendRedirect("/loginjsp.jsp");
		}
     
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
