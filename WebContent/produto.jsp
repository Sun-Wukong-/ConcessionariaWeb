<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produto</title>
</head>
<body>
	Adiciona:
		<form action="produto"  method = "POST">
			Codigo: <input name="codigo"/><br/>
			Marca: <input name="marca"/><br/> 
			Modelo: <input name="modelo"/><br/> 
			Ano: <input name="ano"/><br/> 
			Cor: <input name="cor"/><br/> 
			Preco: <input name="preco"/><br/> 		
			<input type="submit" value="Salvar"/>
		</form>	
		<a href="http://localhost:8080/ConcessionariaCastelo/produto" target="_blank">Lista Produto</a>
</body>
</html>