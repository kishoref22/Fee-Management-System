<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<c:if test="${not empty Accemail}">
<h2>${total_fee}</h2>
<h2>${fee_paid}</h2>
<h2>${fee_due}</h2>
<h2>${student.name}</h2>
</c:if>
<c:if test="${empty Accemail}">
<c:redirect url = "/loginjsp.jsp"></c:redirect>
</c:if>
</body>
</html>