<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookStore-Admin</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

	<div class="signup-header">
	 	<h2>Login - Administrador</h2>
	</div>

<form method="post" action="AdminController">
	 
	 <input type="hidden" name="page" value="admin-login-form">
	 
	 	<!-- Validations errors -->
	 	<font color="#F24638"><c:out value="${msg }"></c:out></font>
	 
	 	<div class="signup-group">
	 		<input type="text" name="username" placeholder="Seu nome de usuário" value="<c:out value="${username }"></c:out>">
	 	</div>
	 	<div class="signup-group">
	 		<input type="password" name="senha" placeholder="Sua senha de administrador">
	 	</div>
	 	<div class="signup-group">
	 		<button type="submit" name="login" class="signup-btn">Entrar</button>
	 	</div>
	 </form>
</body>
</html>