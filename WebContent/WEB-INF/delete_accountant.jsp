<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Accountants</title>
<link type = "text/css" rel = "stylesheet" href = "css/delete_accountant.css"></link>

</head>
<body>

  <c:if test = "${username == null }">
  <c:redirect url = "/loginjsp.jsp"></c:redirect>
  </c:if>
  <c:if test = "${username != null }">
  <header>
    <div class = "head">
      <ul class = "menu">
            <li><a href="adminpanel.jsp">Home</a></li>
			<li><a href="View_Accountant">View</a></li>
			<li><a href="Edit_Accountant">Edit</a></li>
			<li><a href="add_accountant.jsp">Add</a></li>
			<li><a href="Delete_Accountant">Delete</a></li>
      </ul>
      <ul class="log">
			<li><a href="Accountant_Logout">Logout</a></li>
	  </ul>
    
    </div>
  </header>
       <ul class = "accountants">
          <li>Accountants List</li> 
       </ul>
           
           <table id = table> 
              
              <tr>
              <th>Accountant Name</th>
              <th>Password</th>
              <th>Email</th>
              <th>Address</th>
              <th>Contact</th>
              <th>Delete</th>
              
              </tr>
              
          <c:forEach var = "tempAccountant" items = "${data}">    
              <tr>
              <td> ${tempAccountant.name} </td>
              <td> ${tempAccountant.password} </td>
              <td> ${tempAccountant.email} </td>
              <td> ${tempAccountant.address} </td>
              <td> ${tempAccountant.contact} </td>
              <td><a href = "${pageContext.request.contextPath}/Delete_Action?delete=${tempAccountant.email}">Delete</a></td>
              </tr>
           </c:forEach>
          </table>
   </c:if>
</body>
</html>