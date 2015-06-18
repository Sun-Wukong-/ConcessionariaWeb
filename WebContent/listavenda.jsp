<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Venda" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Venda</title>
</head>
<body>
	<table border="1">
		<tr bgcolor="red">
			<th>Codigo</th> <th>Data</th> <th>Registro Vendedor</th> <th>Codigo Produto</th> <th>Desconto</th> <th>Valor Acessorios</th> <th>Valor Total</th>
		</tr>
<%
		List<Venda> vendas = (List<Venda>) request.getAttribute("vendas");
		for(Venda listaVendas : vendas){
%>	
		<tr>
			<td><%= listaVendas.getCodigo()%></td>
			<td><%= listaVendas.getData()%></td>
			<td><%= listaVendas.getRegistroVendedor()%></td>
			<td><%= listaVendas.getCodigoProduto()%></td>
			<td><%= listaVendas.getDesconto()%></td>
			<td><%= listaVendas.getValorAcessorios()%></td>
			<td><%= listaVendas.getValorTotal()%></td>
		</tr>
	<%
	}
	%>
	</table>
</body>
</html>