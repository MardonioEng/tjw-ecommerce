<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

	<c:set var="x" value="0"></c:set>
	<c:forEach items="${listaCarrinho }" var="i">
		<c:set var="x" value="${x+1 }"></c:set>
	</c:forEach>

	<header>
		<!-- 
		<h1>
			BooksStore
		</h1>
		 -->
		<nav>
			<ul>
				<li><a href="Controller?page=index">Home</a></li>
				<c:choose>
					<c:when test="${session == null}">
						<li><a href="Controller?page=login">Login</a></li>
						<li><a href="Controller?page=sign-up">Cadastre-se</a></li>
					</c:when>
					<c:when test="${session != null}">
						<li><a href="#">Olá, <c:out value="${username }"></c:out></a></li>
						<li><a href="Controller?page=logout" style="color: #F24638;">Sair</a></li>
					</c:when>
				</c:choose>
				<li><a href="Controller?page=showcart">Carrinho (<c:out
							value="${x}" />)
				</a></li>
			</ul>
		</nav>
	</header>

	<div class="container container-carrinho">

		<c:choose>
			<c:when test="${x == 1}">
				<h4 style="margin-top: 40px;">
					Meu carrinho (
					<c:out value="${x}" />
					item)
				</h4>
			</c:when>
			<c:when test="${x > 1}">
				<h4 style="margin-top: 40px;">
					Meu carrinho (
					<c:out value="${x}" />
					items)
				</h4>
			</c:when>
			<c:otherwise>
				<h4 style="margin-top: 40px;">Carrinho vazio!</h4>
			</c:otherwise>

		</c:choose>
		<table style="table-layout: fixed; width: 100%; border:none;">
			<tr>
				<th style="width: 100px; text-align: center;">Item</th>
				<th style="width: 50px; text-align: center;">Valor</th>
				<th style="width: 100px; text-align: center;">Remover Item</th>
			</tr>
		</table>

		<c:set var="total" value="0"></c:set>
		<c:forEach items="${listaCarrinho }" var="i">
			<c:forEach items="${listaProdutos }" var="produto">
				<c:if test="${i == produto.getId() }">

					<c:set var="total" value="${total + produto.getValor() }"></c:set>

					<table style="table-layout: fixed; width: 100%;">
						<tr>
							<td style="width: 100px; font-weight:bold;"><img src="${produto.getImagem()}"
								height="100" width="150"> <c:out
									value="${produto.getNome()}" /></td>
							<td style="width: 50px; text-align: center; font-weight:bold;"><c:out
									value="${produto.getValor()}" /></td>
							<%-- 					<td style="width: 100px;"><c:out value="${Product.getCategory()}"/></td> --%>
							<td style="width: 100px; text-align: center;"><a
								href="Controller?page=remove&id=<c:out value="${produto.getId()}"/>"><span
									class="btn btn-danger" style="border-radius: 25px; background-color: red;">X</span></a></td>
						</tr>
					</table>
				</c:if>
			</c:forEach>
		</c:forEach>

		<h4 style="margin-top: 40px; margin-bottom: 40px;">
			Valor Total: R&#36;
			<c:out value="${ total}"></c:out>
		</h4>

        <div class="btnCarrinho" style="display: flex; flex-direction: column; align-items: flex-end;">
		<c:choose>
			<c:when test="${session == null}">
				<a href="Controller?page=finalizarCompra_1"><input type="button"
					value="Efetuar compra" class="btn btn-success"
					style="padding: 8px; font-size: 16px; width: 170px; margin-bottom: 20px; background-color: green;"></a>
                    
			</c:when>
			<c:when test="${session != null}">
				<a href="Controller?page=finalizarCompra_2">
                    <input type="button"
					value="Efetuar compra" class="btn btn-success"
					style=" padding: 8px; font-size: 16px; width: 170px; margin-bottom: 20px; background-color: green;">
                </a>
			</c:when>
		</c:choose>

		<a href="Controller?page=index"><input type="button"
			value="Continue comprando" class="btn btn-warning"
			style="padding: 8px; font-size: 16px; width: 170px; background-color: orange;"></a>

        </div>





	</div>

	<footer style="margin-top: 40px;">
		<div class="footer">&copy; Mardonio Rodrigues</div>
	</footer>
</body>
</html>