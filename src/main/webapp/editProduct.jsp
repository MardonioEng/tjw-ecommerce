<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Produto</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> 
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<header>
		<h1>
			Administrador
		</h1>
		<nav>
			<ul>
				<li><a href="AdminController?page=home-admin">Home</a></li>
				<li><a href="AdminController?page=addproduct">Adicionar Produto</a></li>
<!-- 				<li><a href="#">Settings</a></li> -->
<!-- 				<li><a href="#">Pages</a></li> -->
			</ul>
		</nav>
	</header>
	
	<div class="signup-header">
	 	<h2>Edite o Produto</h2>
	 </div>

	 <form method="post" action="AdminController">
	 
	 <input type="hidden" name="page" value="edit_product">
	 <input type="hidden" name="id" value="<c:out value="${p.getId() }"/>">
     
	 	<div class="signup-group">
	 		<label>Name</label>
	 		<input type="text" name="nome" value="<c:out value="${p.getNome() }"></c:out>" required>
	 	</div>
	 	<div class="signup-group">
	 		<label>Valor</label>
	 		<input type="text" name="valor" value="<c:out value="${p.getValor() }"></c:out>" required>
	 	</div>
	 	
	 	<div class="signup-group">
	 		<label>Featured</label>
	 		<input type="text" name="featured" value="<c:out value="${p.getFeatured() }"></c:out>" required>
	 	</div>
	 	<div class="signup-group">
	 		<label>Imagem</label>
	 		<input type="text" name="imagem" value="<c:out value="${p.getImagem() }"></c:out>" required>
<%-- 	 		<img style="height: 160px;width: 160px;" src="<c:out value="${p.getImagem() }"></c:out>"> --%>
	 	</div>
	 	<div class="signup-group">
			<input type="submit" value="Editar">	 
		</div>
	 </form>
	
	 <footer>
		<div class="footer"> &copy; Mardonio Rodrigues</div>
	</footer>
</body>
</html>