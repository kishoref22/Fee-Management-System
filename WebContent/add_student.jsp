<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/add_accountant.css"></link>
<title>Add Accountant</title>
</head>
<body>
  <c:if test = "${Accemail == null }">
  <c:redirect url = "/loginjsp.jsp"></c:redirect>
  </c:if>
   <c:if test = "${Accemail != null }">
<header>
	<div class="haad">
		<ul class="menu">

			<li class="home"><a href="accountantIndex.jsp">Home</a></li>
			<li><a href="View_Students">View Students</a></li>
			<li><a href="Edit_Students">Edit Students</a></li>
			<li><a href="add_student.jsp">Add Student</a></li>
			<li><a href="Delete_Student">Delete Student</a></li>

		</ul>
		<ul class="log">
			<li><a href="Accountant_Logout">Logout</a></li>
		</ul>
	</div>
</header>
  <div class = "add_form">
   <form action="Add_Student" method = "post">

     <h1>Add Student form</h1>
     <br/>  
     <p>Student name</p>
     <input type = "text" name = "name">
     <p>Course</p>
     <input type = "text" name = "course">
     <br/>
     <p>Email</p>
     <input type = "text" name = "email">
     <br/>
     <p>Unique</p>
     <input type = "text" name = "id">
     <br/>     
     <p>Phone_no</p>
     <input type = "text" name = "phone_no">
     <br/>     
     <p>DOB</p>
     <input type = "text" name = "dob" placeholder = "YYYYMMDD">
     <br/>
     <p>Address</p>
     <textarea rows = "3" cols = "45" name = "address"></textarea>
     <br/>
     <p>Fee_Paid</p>
     <input type ="number" name = "fee_paid">
     <br/>
     <p>Fee_due</p>
     <input type ="number" name = "fee_due">
     <br/>
     <input type = "submit" value = "Add">
     
    
     </form>
   </div>
   <c:if test = "${mes != null}" >
   <h2>${mes}</h2>
   </c:if>
   <br/>
   <br/>
  </c:if>
</body>
</html>