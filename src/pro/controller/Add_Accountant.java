package pro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.pojo.Accountant;
import pro.dao.AccountantDAOimpl;

@WebServlet("/Add_Accountant")
public class Add_Accountant extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Add_Accountant() {
		super();
	}

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String msg;

		String Acc_name = request.getParameter("acc_name");
		String Acc_pass = request.getParameter("acc_password");
		String Acc_email = request.getParameter("acc_email");
		String Acc_address = request.getParameter("acc_Address");
		String Acc_contact = request.getParameter("acc_contact");

		Accountant accountant = new Accountant(Acc_name, Acc_pass, Acc_email, Acc_address, Acc_contact);
	 
		if(request.getAttribute("username") != "") {
      		try {
			if(AccountantDAOimpl.addAccountant(accountant).equals("failed")) {
			      msg = "Accountant failed to add";
			}else {
			msg = "Accountant successfully added";
			}request.setAttribute("message", msg);
			RequestDispatcher rd;
			rd = getServletContext().getRequestDispatcher("/add_accountant.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		  }
		}else {
			response.sendRedirect("/loginjsp.jsp");
		}

	}

}
