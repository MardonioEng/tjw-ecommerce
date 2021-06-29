<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Produto</title>
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
				<li><a href="AdminController?page=index-admin">Home</a></li>
				<li><a href="AdminController?page=addproduct">Adicionar produto</a></li>
<!-- 				<li><a href="#">Settings</a></li> -->
<!-- 				<li><a href="#">Pages</a></li> -->
			</ul>
		</nav>
	</header>
	
	<div class="signup-header">
	 	<h2>Adicionar um Produto</h2>
	 </div>

	 <form method="post" action="AdminController">
	 
	 <input type="hidden" name="page" value="add_product">
     
	 	<div class="signup-group">
	 		<label>Nome</label>
	 		<input type="text" name="nome" placeholder="Nome do Produto"  required>
	 	</div>
	 	<div class="signup-group">
	 		<label>Valor</label>
	 		<input type="text" name="valor" placeholder="Valor do Produto" required>
	 	</div>

	 	<div class="signup-group">
	 		<label>Featured</label>
	 		<input type="text" name="featured" placeholder="yes/no" required>
	 	</div>
	 	<div class="signup-group">
	 		 <label for="fileupload">Nome da Imagem (ex: img/imagem.jpg)</label>
	 		<input type="text" name="imagem" placeholder="Nome da imagem do diretório img"><br>
	 	</div>
	 	<div class="signup-group">
			<input type="submit" value="Process">	 
		</div>
	 </form>
	
	 <footer style="position: absolute; left: 0; bottom: 0; width: 100%;">
		<div class="footer"> &copy; Mardonio Rodrigues</div>
	</footer>
</body>
</html>