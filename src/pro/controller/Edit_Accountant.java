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

/**
 * Servlet implementation class Edit_Accountant
 */
@WebServlet("/Edit_Accountant")
public class Edit_Accountant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  if(request.getAttribute("username") != "") {
		ArrayList<Accountant> acc = null;
	    
	    try {
			acc = (ArrayList<Accountant>) AccountantDAOimpl.viewAccountants();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    if(acc == null) {
	    	request.setAttribute("err", "failed");
	    	response.sendRedirect("/WEB-INF/edit_accountant.jsp");
	    	return;
	    } else {
	    	request.setAttribute("dataList", acc);
	    	RequestDispatcher rd1 = request.getRequestDispatcher("/WEB-INF/edit_accountant.jsp");
	    	rd1.forward(request, response);
	    	return;
	    }
	  }else {
		  response.sendRedirect("/loginjsp.jsp");
	  }
	    
	
	}

 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
