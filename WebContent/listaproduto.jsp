<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Produto" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Produtos</title>

	<style type="text/css">
		@charset "UTF-8";
		th {
			font: bold 11px "Trebuchet MS", Verdana, Arial, Helvetica,
			sans-serif;
			color: #6D929B;
			border-right: 1px solid #C1DAD7;
			border-bottom: 1px solid #C1DAD7;
			border-top: 1px solid #C1DAD7;
			letter-spacing: 2px;
			text-transform: uppercase;
			text-align: left;
			padding: 6px 6px 6px 12px;
			background: #CAE8EA url(images/bg_header.jpg) no-repeat;
		}
		
		th.nobg {
			border-top: 0;
			border-left: 0;
			border-right: 1px solid #C1DAD7;
			background: none;
		}
		
		th.spec {	
			border-left: 1px solid #C1DAD7;
			border-top: 0;
			background: #fff url(images/bullet1.gif) no-repeat;
			font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica,
			sans-serif;
		}
		
		th.specalt {
			border-left: 1px solid #C1DAD7;
			border-top: 0;
			background: #f5fafa url(images/bullet2.gif) no-repeat;
			font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica,
			sans-serif;
			color: #B4AA9D;
		}
		
		td {
			border-right: 1px solid #C1DAD7;
			border-bottom: 1px solid #C1DAD7;
			background: #fff;
			padding: 6px 6px 6px 12px;
			color: #6D929B;
		}
		
		
		td.alt {
			background: #F5FAFA;
			color: #B4AA9D;
		}
		
	</style>

</head>
<body>
	<table id="mytable" cellspacing="0" summary="Lista de Produtos">
	<caption>Table 1: Produtos </caption>
		<tr bgcolor="red">
			<th scope="col" abbr="Codigo" class="nobg">Codigo</th> 
			<th scope="col" abbr="Modelo">Modelo</th> 
			<th scope="col" abbr="Marca">Marca</th> 
			<th scope="col" abbr="Ano">Ano</th> 
			<th scope="col" abbr="Cor">Cor</th> 
			<th scope="col" abbr="Preço">Preço</th>
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