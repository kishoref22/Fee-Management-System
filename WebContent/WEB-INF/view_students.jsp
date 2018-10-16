<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Students</title>
<link type = "text/css" rel = "stylesheet" href = "css/ad_view.css"></link>
</head>
<body>
<c:if test = "${Accemail == null }">
  <c:redirect url = "/loginjsp.jsp"></c:redirect>
  </c:if>
  <c:if test = "${Accemail != null }">
  <header>
    <div class = "head">
      <ul class = "menu">
            <li><a href="accountantIndex.jsp">Home</a></li>
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
       <div class = accountants>
          <h2>Students List</h2> 
       </div>
           
           <table id = table> 
              
             <tr>
              <th>Name</th>
              <th>Course</th>
              <th>Email</th>
              <th>ID</th>
              <th>Phone no</th>
              <th>DOB</th>
              <th>Address</th>
              <th>Fee_Paid</th>
              <th>Fee_Due</th>
              <th>Details</th>
             </tr>
              
          <c:forEach var = "tempStudent" items = "${students_data}">    
              <tr>
              <td> ${tempStudent.name} </td>
              <td> ${tempStudent.course} </td>
              <td> ${tempStudent.email} </td>
              <td> ${tempStudent.id} </td>
              <td> ${tempStudent.phone_no} </td>
              <td> ${tempStudent.dob}</td>
              <td> ${tempStudent.address}</td>
              <td> ${tempStudent.fee_paid}</td>
              <td> ${tempStudent.fee_due}</td>
              <td> <a href = "${pageContext.request.contextPath}/Student_Details?details=${tempStudent.id}">View</a> 
              </tr>
           </c:forEach>
          </table>
       </c:if>
</body>
</html>