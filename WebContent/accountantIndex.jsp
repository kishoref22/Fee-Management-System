<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accountant panel</title>
<link type="text/css" rel="stylesheet" href="css/adminIndex.css"></link>
</head>
<body>
<c:if test = "${Accemail == null }">
  <c:redirect url = "/loginjsp.jsp"></c:redirect>
  </c:if>	
   <c:if test = "${Accemail != null }">
   <header>
   
    
	<div class="haad">
		<ul class="menu">

			<li class="home"><a href="#">Home</a></li>
			<li><a href="View_Students">View Students</a></li>
			<li><a href="Edit_Students">Edit Student</a></li>
			<li><a href="add_student.jsp">Add Student</a></li>
			<li><a href="Delete_Student">Delete Student</a></li>

		</ul>
		<ul class="log">
			<li><a href="Accountant_Logout">Logout</a></li>
		</ul>
	</div>
	
	</header>
	<div id = "main">
	  <p >ACCOUNTANT HOMEPAGE</p>
	</div>
	</c:if>

</body>
</html>