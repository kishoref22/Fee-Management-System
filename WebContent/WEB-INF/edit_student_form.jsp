<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Student form</title>
</head>
<body>
<c:if test="${ empty Accemail}">
   <c:redirect url = "/loginjsp.jsp"></c:redirect>
</c:if>
<c:if test="${not empty Accemail}">
  <div id  = "feedback">
    <h2>${msg}</h2>
    </div>
  <div id = form>
    <div class = "header">
      <h1>Edit Student </h1>
      <h2>msg</h2>
    </div>
    <div id = "content">
    	<form action = "Load_Student" method = "post">
    	
    	<p class = "p" >new name</p>
    	<input type="text" name = "name" value = "${data.name}"/>
    	<p>Edit Course</p>
    	<input type = "text" name = "course" value = "${data.course}"/>
    	<p>new Email</p>
    	<input type = "text" name = "email" value = "${data.email}"/>
    	<p>New Id</p>
    	<input type = "hidden" name = "id" value = "${data.id}"/>
    	<p>Phone No</p>
    	<input type = "text" name = "phone_no" value = "${data.phone_no}"/>
    	<p>DOB</p>
    	<input type = "text" name = "dob" value = "${data.dob}"/>
    	<p>Address</p>
    	<textarea rows="3" cols="45" name = "address" >${data.address}</textarea>
    	<p>Fee Paid</p>
        <input type  = "number" name = "fee_paid" value = "${data.fee_paid}" />
        <p>Fee Due</p>
        <input type = "text" name = "fee_due" value = "${data.fee_due}" />
    	<p>
    	  <div id = "submt">
    	   <button type = "submit" value = "${data.id}" name = "save">Save</button>
    	  </div>
    	</form>	
    	
    </div>
  </div>
  </c:if>
</body>
</html>