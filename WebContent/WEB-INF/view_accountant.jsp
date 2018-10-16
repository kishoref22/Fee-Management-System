<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Accountants</title>
<link type = "text/css" rel = "stylesheet" href = "css/ad_view.css"></link>
</head>
<body>
<c:if test = "${empty username }">
  <c:redirect url = "/loginjsp.jsp"></c:redirect>
  </c:if>
  <c:if test = "${not empty username }">
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
			<li><a href="Admin_logout">Logout</a></li>
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
              
              </tr>
              
          <c:forEach var = "tempAccountant" items = "${dataList}">  
              <tr>
              <td> ${tempAccountant.name} </td>
              <td> ${tempAccountant.password} </td>
              <td> ${tempAccountant.email} </td>
              <td> ${tempAccountant.address} </td>
              <td> ${tempAccountant.contact} </td>
              </tr>
           </c:forEach>
          </table>
       </c:if>
</body>
</html>