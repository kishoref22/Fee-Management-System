<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/login.css" rel="stylesheet" type="text/css" />
<title>Login page</title>
</head>
<body>
	<h1>Fee Management System</h1>
	<ul style="list-style-type: none">
		<li class=admin_login>
			<div>
				<form action="AdminLoginServlet" method="post">
				    <h2>Admin Login Form</h2>
					<h3 style="color: red">${err}</h3>
					<h4 style="color: #fff">Username</h4>
					<input type="text" name="adm_username" placeholder="username">
					<h4 style="color: #fff">Password</h4>
					<input type="password" name="adm_password" placeholder="password">
					<br> <br> <input type="submit" value="login">
				</form>
			</div>
		</li>
		<li class=accountant_login>
			<div>
				<form action="AccountantLoginServlet" method="post">
					<h2>Accountant login form</h2>
		            <h3 style="color: red">${msg}</h3>
					<h4 style="color: #fff">Email</h4>
					<input type="text" name="acc_email" placeholder="Email">
					<h4 style="color: #fff">Password</h4>
					<input type="password" name="acc_password" placeholder="password">
					<br> <br> <input type="submit" value="login">
				</form>
			</div>
		</li>
	</ul>
</body>
</html>
