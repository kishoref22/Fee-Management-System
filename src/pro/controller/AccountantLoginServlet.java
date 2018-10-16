package pro.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pro.dao.AccountantDAOimpl;
import pro.pojo.Accountant;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/AccountantLoginServlet")
public class AccountantLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AccountantLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url;
		String Accemail = null;
		String password = null;
		Accountant acc;
		String error = "";
		Accemail = request.getParameter("acc_email");
		password = request.getParameter("acc_password");
		if (Accemail != "" && password != "") {
			try {
				acc = AccountantDAOimpl.viewAccountant(Accemail);
				if (acc != null) {
					if (acc.getPassword().equals(password)) {
						HttpSession session = request.getSession(true);
						session.setAttribute("Accemail", Accemail);
						Cookie acc_login_cookie = new Cookie("A_email", Accemail);
						acc_login_cookie.setMaxAge(90 * 60);
						response.addCookie(acc_login_cookie);
						response.sendRedirect("accountantIndex.jsp");
					} else {
						error += "enter correct password";
						request.setAttribute("msg", error);
						url = "/loginjsp.jsp";
						RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
						rd.forward(request, response);
					}
				} else {
					String error1 = "enter correct mail";
					request.setAttribute("msg", error1);
					url = "/loginjsp.jsp";
					RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
					rd.forward(request, response);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			String error2 = "enter correct details";
			request.setAttribute("msg", error2);
			request.setAttribute("msg", "enter your details");
			url = "/loginjsp.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		}
	}

}
