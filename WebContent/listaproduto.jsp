<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Produto" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Produtos</title>
</head>
<body>
	<table border="1">
		<tr bgcolor="red">
			<th>Codigo</th> <th>Modelo</th> <th>Marca</th> <th>Ano</th> <th>Cor</th> <th>Preço</th>
		</tr>
<%
		List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
		for(Produto listaProdutos : produtos){
%>	
		<tr>
			<td><%= listaProdutos.getCodigo()%></td>
			<td><%= listaProdutos.getMarca()%></td>
			<td><%= listaProdutos.getModelo()%></td>
			<td><%= listaProdutos.getAno()%></td>
			<td><%= listaProdutos.getCor()%></td>
			<td><%= listaProdutos.getPreco()%></td>
		</tr>
	<%
	}
	%>
	</table>
</body>
</html>