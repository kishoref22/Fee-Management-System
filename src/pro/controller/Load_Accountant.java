package pro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.pojo.Accountant;
import pro.dao.AccountantDAOimpl;

@WebServlet("/Load_Accountant")
public class Load_Accountant extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// we are fetching the data based on our primary key to fill the html form and
		// edit.
		String edit = request.getParameter("edit");
		if (edit != null) {
			Accountant acc = null;
			try {
				acc = (Accountant) AccountantDAOimpl.viewAccountant(edit);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("data", acc);
		}
		request.getRequestDispatcher("/WEB-INF/edit_accountant_form.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String save = request.getParameter("save");
		if (save != null) {
			Accountant acc = null;
			try {
				acc = (save.isEmpty()) ? new Accountant() : AccountantDAOimpl.viewAccountant(save);
			} catch (Exception e) {
				e.printStackTrace();
			}
			acc.setName(request.getParameter("name"));
			acc.setPassword(request.getParameter("password"));
			acc.setEmail(request.getParameter("email"));
			acc.setAddress(request.getParameter("address"));
			acc.setContact(request.getParameter("contact"));
			try {
				// here email is primary key
				AccountantDAOimpl.updateAccountant(acc);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		response.sendRedirect(request.getContextPath() + "/Edit_Accountant");
	}

}
