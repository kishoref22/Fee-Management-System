<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/add_accountant.css"></link>
<title>Add Accountant</title>
</head>
<body>
  <c:if test = "${username == null }">
  <c:redirect url = "/loginjsp.jsp"></c:redirect>
  </c:if>
   <c:if test = "${username != null }">
<header>
	
	<%
     String mes = (String) request.getAttribute("message");
    %>
	<div class="haad">
		<ul class="menu">

			<li class="home"><a href="adminpanel.jsp">Home</a></li>
			<li><a href="View_Accountant">View</a></li>
			<li><a href="Edit_Accountant">Edit</a></li>
			<li><a href="add_accountant.jsp">Add</a></li>
			<li><a href="Delete_Accountant">Delete</a></li>

		</ul>
		<ul class="log">
			<li><a href="Admin_logout">Logout</a></li>
		</ul>
	</div>
</header>
  <div class = "add_form">
   <form action="Add_Accountant" method = "post">

     <h1>Add Accountant form</h1>
     <br/>  
     <p>Accountant name</p>
     <input type = "text" name = "acc_name">
    <p>Password</p>
     <input type = "password" name = "acc_password">
     <p>Email</p>
     <input type = "text" name = "acc_email">
     <p>Address</p>
     <div class = "address">
     <input type = "text" name = "acc_Address">
     </div>
     <p>Contact</p>
     <input type = "text" name = "acc_contact">
     <br/>
     <input type = "submit" value = "Add">
     
    
     </form>
   </div>
   <% if(mes != null) { %>
   <h2><%=mes%></h2>
   <% } %>
   <br/>
   <br/>
  </c:if>
</body>
</html>