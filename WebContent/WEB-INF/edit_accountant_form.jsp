<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type = "text/csss" rel = "stylesheet" href = "css/edit_accountant.css">
<title>Edit Accountant form</title>
</head>
<body>
  <c:if test="${empty username }">
  <c:redirect url = "/loginjsp.jsp"></c:redirect>
  </c:if>
  <c:if test="${not empty username}">
  <div id = form>
    <div class = "header">
      <h1>Edit Accountant </h1>
    </div>
    <div id = "content">
    	<form action = "Load_Accountant" method = "post">
    	          
    	<p>new Username</p>
    	<input type="text" name = "name" value = "${data.name}"/>
    	<br/>     
    	<p>new Password</p>
    	<input type = "text" name = "password" value = "${data.password}"/>
    	<br/>      
    	<p>new Address</p>
    	<input type = "text" name = "address" value = "${data.address}"/>
    	<br/>
    	<p>Contact</p>
    	<input type = "text" name = "contact" value = "${data.contact}"/>
    	<br/>
    	<input type = "hidden" name = "email" value = "${data.email}"/>
    	<br/>
    	  <div id = "submt">
    	   <button type = "submit" value = "${data.email}" name = "save">Save</button>
    	  </div>
    	</form>	
    	
    </div>
  </div>
  </c:if>
</body>
</html>