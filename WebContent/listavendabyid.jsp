<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="modelo.Venda" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pesquisar Venda by ID</title>

<style type="text/css">
		@charset "UTF-8";
		@font-face{
			font-family:'FonteLogo';
			src:url("../_fonts/CUTEL___.ttf")
		}
		/*Formata��o Body*/
		body{
			font-family:Arial, sans-serif;
			background-color: #dddddd;
			color: rgba(0,0,0,1);
		}
		
		/*Formata��o Imagem*/
		figure.fotolegenda{
			position:relative;
			border:8px solid white;
			box-shadow:1px 1px 4px black;
		}
		
		figure.fotolegenda img{
			width:50%;
			height:50%;
		}
		
		figure.fotolegenda figcaption{
			opacity:0;
			position:absolute;
			top:0px;
			background-color:rgba(0,0,0,.4);
			color:white;
			width:100%;
			height:100%;
			padding:10px;
			box-sizing:border-box;
			transition:opacity 1s;
		}
		
		
		figure.fotolegenda:hover figcaption{
			opacity:1;
		
		}
		
		/*Forma��o Header*/
		header#cabecalho img#icone2{
			position:absolute;
			left:360px;
			top:24px;
		}
		
		header#cabecalho img#icone{
			position:absolute;
			left:783px;
			top:0px;
		}
		
		header#cabecalho {
			border-bottom: 1px #606060 solid;
			height:150px;
			background: url("../_imagens/Logo.gif") no-repeat 0px 90px;
		}
		
		header#cabecalho h1{
			font-family: Arial, sans-sefif;
			font-size: 30pt;
			color: #606060;
			text-shadow: 1px 1px 1px rgba(0,0,0,.6);
			padding:0px;
			margin-bottom:0px
		}
		
		header#cabecalho h2 {
			font-family: Arial, sans-sefif;
			font-size: 15pt;
			color: #888888;
			padding:0px;
			margin-top:0px
		
		}
		
		/*Forma��o Interface*/
		
		div#interface{
			width: 1000px;
			background-color:#ffffff;
			margin: -20px auto 0px auto;
			box-shadow: 0px 0px 10px rgba(0,0,0,.5);
			padding:10px;
		}
		
		p{
			text-align:justify;
			text-indent:50px;
		}
		
		a{
			color:#606060;
			text-decoration:none;
		}
		
		a:hover{
			text-decoration:underline;
		}
		
		/*Formata��o do Menu*/
		
		nav#menu{
			display: block;
		}
		
		nav#menu ul{
			list-style: none;
			text-transform: uppercase;
			position: absolute;
			top: 0px;
			left: 500px;
		}
		
		nav#menu li{
			display: inline-block; 
			background-color: #dddddd;
			padding: 10px;
			margin: 2px;
			transition: background-color 1s;
		}
		
		nav#menu li: hover{
			opacity:1;
			background-color: #606060;
		}
		
		nav#menu h1{
			display: none;
		}
		
		nav#menu a{
			color:#000000;
			text-decoration: none;
		}
		
		nav#menu  a: hover{
			color: #ffffff;
			text-decoration:underline;
		}
		
		section#corpo{
			display:block;
			width: 600px;
			float: left;
			border-right:1px solid #606060;
			padding-right:15px;
		}
		
		article#artigoprincipal h2{
			font-size:13pt;
			color:#606060;
			background-color:#dddddd;
			padding:5px 0px 5px 10px;
			margin:10px 0px 10px 0px;
		}
		
		header#cabecalhoartigo h1{
			font-family:'FonteLogo', sans-serif;
			font-size:20pt;
			margin-bottom:0px;
			margin-top:0px;
		
		}
		
		.direita{
			text-align:right;
		}
		
		header#cabecalhoartigo h2{
			font-size:13pt;
			color:#cecece;
			background-color:#ffffff;
			margin:0px;
		}
		
		header#cabecalhoartigo h3{
			font-size:12px;
			color:#606060;
		}
		
		table#tabelainfo{
			border:1px solid #606060;
			border-spacing:0px;
			margin-left:auto;
			margin-right:auto;
			margin-bottom:10px;
		
		}
		
		table#tabelainfo td{
			border:1px solid #606060;
			padding:10px;
			text-align:center;
			vertical-align:middle;
		
		}
		
		table#tabelainfo td.ce{
			color:#ffffff;
			background-color:#606060;
			font-weight:bold;
			
		}
		
		table#tabelainfo td.cd{
			background-color:#cecece;
		}
		
		table#tabelainfo caption{
			color:#888888;
			font-size:15pt;
			font-weight:bolder;
		}
		
		table#tabelainfo caption span{
			display:block;
			float:right;
			color:#000000;
			font-size:8pt;
			margin-top:10px;
		}
		
		aside#lateral{
			display:block;
			width: 350px;
			float:right;
			background-color:#dddddd;
			padding:10px;
			margin-top:10px;
			box-shadow:2px 2px 2px rgba(0,0,0,.5);
		}
		
		aside#lateral h1{
			font-family:'FonteLogo', sans-serif;
			font-size:20pt;
			color:#606060;
		}
		
		aside#lateral h2{
			background-color:#606060;
			font-size:13pt;
			color:#ffffff;
			padding:5px;
		}
		
		footer#rodape{
			clear: both;
			border-top:1px solid #606060;
		}
		
		footer#rodape p {
			text-align:center;
		}
		
	</style>

</head>
<body>
	<table border="1" align="center">
		<tr bgcolor="red">
			<th>Codigo</th> <th>Data</th> <th>Registro Vendedor</th> <th>Codigo Produto</th> <th>Desconto</th> <th>Valor Acessorios</th> <th>Valor Total</th>
		</tr>
<%
		Venda vendas = (Venda) request.getAttribute("venda");
%>	
		<tr>
			<td><%= vendas.getCodigo()%></td>
			<td><%= vendas.getData()%></td>
			<td><%= vendas.getRegistroVendedor()%></td>
			<td><%= vendas.getCodigoProduto()%></td>
			<td><%= vendas.getDesconto()%></td>
			<td><%= vendas.getValorAcessorios()%></td>
			<td><%= vendas.getValorTotal()%></td>
		</tr>

	</table>
</body>
</html>