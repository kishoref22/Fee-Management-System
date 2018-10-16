<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "htt p://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin panel</title>
<link type="text/css" rel="stylesheet" href="css/adminIndex.css"></link>
</head>
<body>
<c:if test = "${username == null }">
  <c:redirect url = "/loginjsp.jsp"></c:redirect>
  </c:if>	
   <c:if test = "${username != null }">
   <header>
   
    
	<div class="haad">
		<ul class="menu">

			<li class="home"><a href="#">Home</a></li>
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
	</c:if>

</body>
</html>