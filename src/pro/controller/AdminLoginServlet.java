package pro.controller;

import java.io.IOException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         String ad_user = "Admin";
         String ad_pass = "12345";
        
         String adm_username = request.getParameter("adm_username");
		 String adm_password = request.getParameter("adm_password");
		 String url;
		 String err= "";
		 if(adm_username.equals("") || adm_password.equals("")) {
			 err += "enter your username and password";
		 }
		 if (!adm_username.equals(ad_user) && !adm_password.equals(ad_pass))
			 err = "enter corrrect username and password";
		 if(err.length()>0) {                     
			 request.setAttribute("err", err);    
		 }
		     
		 try {                                   
		  if (adm_username.equals(ad_user)  && adm_password.equals(ad_pass)) {
			  HttpSession session = request.getSession(true);
			  session.setAttribute("username",adm_username);
			  Cookie ad_login_cookie = new Cookie("ad_user",adm_username);
			  ad_login_cookie.setMaxAge(90*60);
			  response.addCookie(ad_login_cookie);
			  response.sendRedirect("adminpanel.jsp");
			  url = "/adminpanel.jsp";           
		  } else {
			  
		      url = "/loginjsp.jsp";
			  RequestDispatcher rd =  getServletContext().getRequestDispatcher(url);
			 rd.forward(request, response);
		  }
		
	}catch(Exception e) {
		e.printStackTrace();
		response.sendRedirect("/loginjsp.jsp");
	}

	}
}
