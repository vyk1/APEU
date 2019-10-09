<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="parts/header.html"%>
<title>APEU</title>

<div class="jumbotron">
	<h1 class="display-4">
		<%
			String title = request.getAttribute("title").toString();
			out.print(title);
		%>
	</h1>
	<p class="lead">
		<%
			String mensagem = request.getAttribute("mensagem").toString();
			out.print(mensagem);
		%>
	</p>
	<hr class="my-4">
	<p class="lead">
		<a class="btn btn-primary btn-lg" role="button" href="index.jsp">Clique aqui para acessar a página principal</a>
	</p>
</div>
<%@ include file="parts/footer.html"%>