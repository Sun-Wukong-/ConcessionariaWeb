<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Venda</title>

	<style type="text/css">
		@charset "UTF-8";
		*:focus {outline: none;}
		
		body {font: 14px/21px "Lucida Sans", "Lucida Grande", "Lucida Sans Unicode", sans-serif;}
		.contact_form h2, .contact_form label {font-family:Georgia, Times, "Times New Roman", serif;}
		.form_hint, .required_notification {font-size: 11px;}
		
		.contact_form ul {
		    width:750px;
		    list-style-type:none;
		    list-style-position:outside;
		    margin:0px;
		    padding:0px;
		}
		.contact_form li{
		    padding:12px; 
		    border-bottom:1px solid #eee;
		    position:relative;
		}
		
		.contact_form li:first-child, .contact_form li:last-child {
		    border-bottom:1px solid #777;
		}
		
		.contact_form h2 {
		    margin:0;
		    display: inline;
		}
		.required_notification {
		    color:#d45252; 
		    margin:5px 0 0 0; 
		    display:inline;
		    float:right;
		}
		
		.contact_form label {
		    width:150px;
		    margin-top: 3px;
		    display:inline-block;
		    float:left;
		    padding:3px;
		}
		.contact_form input {
		    height:20px; 
		    width:220px; 
		    padding:5px 8px;
		}
		.contact_form textarea {padding:8px; width:300px;}
		.contact_form button {margin-left:156px;}
		
		.contact_form input, .contact_form textarea { 
		    border:1px solid #aaa;
		    box-shadow: 0px 0px 3px #ccc, 0 10px 15px #eee inset;
		    border-radius:2px;
		}
		.contact_form input:focus, .contact_form textarea:focus {
		    background: #fff; 
		    border:1px solid #555; 
		    box-shadow: 0 0 3px #aaa; 
		}
		/* Button Style */
		button.submit {
		    background-color: #68b12f;
		    background: -webkit-gradient(linear, left top, left bottom, from(#68b12f), to(#50911e));
		    background: -webkit-linear-gradient(top, #68b12f, #50911e);
		    background: -moz-linear-gradient(top, #68b12f, #50911e);
		    background: -ms-linear-gradient(top, #68b12f, #50911e);
		    background: -o-linear-gradient(top, #68b12f, #50911e);
		    background: linear-gradient(top, #68b12f, #50911e);
		    border: 1px solid #509111;
		    border-bottom: 1px solid #5b992b;
		    border-radius: 3px;
		    -webkit-border-radius: 3px;
		    -moz-border-radius: 3px;
		    -ms-border-radius: 3px;
		    -o-border-radius: 3px;
		    box-shadow: inset 0 1px 0 0 #9fd574;
		    -webkit-box-shadow: 0 1px 0 0 #9fd574 inset ;
		    -moz-box-shadow: 0 1px 0 0 #9fd574 inset;
		    -ms-box-shadow: 0 1px 0 0 #9fd574 inset;
		    -o-box-shadow: 0 1px 0 0 #9fd574 inset;
		    color: white;
		    font-weight: bold;
		    padding: 6px 20px;
		    text-align: center;
		    text-shadow: 0 -1px 0 #396715;
		}
		button.submit:hover {
		    opacity:.85;
		    cursor: pointer; 
		}
		button.submit:active {
		    border: 1px solid #20911e;
		    box-shadow: 0 0 10px 5px #356b0b inset; 
		    -webkit-box-shadow:0 0 10px 5px #356b0b inset ;
		    -moz-box-shadow: 0 0 10px 5px #356b0b inset;
		    -ms-box-shadow: 0 0 10px 5px #356b0b inset;
		    -o-box-shadow: 0 0 10px 5px #356b0b inset;
		     
		}
		.contact_form input:focus, .contact_form textarea:focus { /* add this to the already existing style */
		    padding-right:70px;
		}
		.contact_form input, .contact_form textarea { /* add this to the already existing style */
		    -moz-transition: padding .25s; 
		    -webkit-transition: padding .25s; 
		    -o-transition: padding .25s;
		    transition: padding .25s;
		}
		
		.contact_form input, .contact_form textarea {
		    padding-right:30px;
		}
		input:required, textarea:required {
		    background: #fff url(images/red_asterisk.png) no-repeat 98% center;
		}
		.contact_form input:focus:invalid, .contact_form textarea:focus:invalid { /* when a field is considered invalid by the browser */
		    background: #fff url(images/invalid.png) no-repeat 98% center;
		    box-shadow: 0 0 5px #d45252;
		    border-color: #b03535
		}
		.contact_form input:required:valid, .contact_form textarea:required:valid { /* when a field is considered valid by the browser */
		    background: #fff url(images/valid.png) no-repeat 98% center;
		    box-shadow: 0 0 5px #5cd053;
		    border-color: #28921f;
		}
		.form_hint {
		    background: #d45252;
		    border-radius: 3px 3px 3px 3px;
		    color: white;
		    margin-left:8px;
		    padding: 1px 6px;
		    z-index: 999; /* hints stay above all other elements */
		    position: absolute; /* allows proper formatting if hint is two lines */
		    display: none;
		}
		.form_hint::before {
		    content: "\25C0"; /* left point triangle in escaped unicode */
		    color:#d45252;
		    position: absolute;
		    top:1px;
		    left:-6px;
		}
		
		.contact_form input:focus + .form_hint {display: inline;}
		.contact_form input:required:valid + .form_hint {background: #28921f;} /* change form hint color when valid */
		.contact_form input:required:valid + .form_hint::before {color:#28921f;} /* change form hint arrow color when valid *
	</style>


</head>
<body>
<form class="contact_form" action="venda" method="post" name="contact_form">
		<ul>
		    <li>
		         <h2>Formulario Venda</h2>
		         <span class="required_notification">* Campos para Preenchimento</span>
		    </li>
		    <li>
			    <label for="data">Data:</label>
				<input type="text" name="data" required/>			    
				<span class="form_hint">Data da Venda - 1995/05/28</span>
			</li>
		    <li>
		        <label for="registroVendedor">Registro Vendedor:</label>
		        <input type="text" name="registroVendedor" required />
		        <span class="form_hint">Registro do Vendedor</span>
		    </li>
		    <li>
		        <label for="codigoProduto">Codigo Produto:</label>
		        <input type="text" name="codigoProduto" required />
		        <span class="form_hint">Codigo do Produto Registrado</span>  
		    </li>
		    <li>
		        <label for="desconto">Desconto:</label>
		        <input type="text" name="desconto" required />
				<span class="form_hint">Valor de Desconto</span>
		    </li>
		    <li>
		        <label for="valorAcessorios">Valor Acessorios:</label>
		        <input type="text" name="valorAcessorios" required />
		   		<span class="form_hint">Valor Total dos Acessorios</span> 
		    </li>
			
			<li>
			    <button class="submit" type="submit">Enviar Formulario</button>
			</li>
		</ul>
		
	</form>	
	
	<form class="contact_form" action="removervenda" method="post" name="contact_form">
		<ul>
		    <li>
		         <h2>Formulario de Exclusao de Venda</h2>
		         <span class="required_notification">* Campos para Preenchimento</span>
		    </li>
		    <li>
			    <label for="codigoExcluir">Codigo Venda:</label>
				<input type="text" name="codigoExcluir" required />			    
				<span class="form_hint">Codigo da Venda que sera Deletada</span>
			</li>
			<li>
			    <button class="submit" type="submit">Enviar Formulario</button>
			</li>
	  </ul>
	</form>
		<ul>
			<li>
				<h2>Pesquisa Venda</h2>
			</li>
			<li>		
				<a href="http://localhost:8080/ConcessionariaCastelo/venda"><h2 align="left">Lista Vendas</h2></a>
			</li>
		</ul>
		
		<form class="contact_form" action="pesquisarvenda" method="post" name="contact_form">
			<ul>
			    <li>
			         <h2>Formulario de Pesquisa de Venda por Id</h2>
			         <span class="required_notification">* Campos para Preenchimento</span>
			    </li>
			    <li>
				    <label for="codigoGetById">Codigo Venda:</label>
					<input type="text" name="codigoGetById" required />			    
					<span class="form_hint">Codigo da Venda que sera Pesquisada</span>
				</li>
				<li>
				    <button class="submit" type="submit">Enviar Formulario</button>
				</li>
				<li>
					<a href="http://localhost:8080/ConcessionariaCastelo/pesquisarvenda"><h2 align="center">Lista Vendas por ID</h2></a>
				</li>
		  </ul>
	  </form>
	  
	  <form class="contact_form" action="pesquisarvenda" method="post" name="contact_form">
			<ul>
			    <li>
			         <h2>Formulario de Pesquisa de Venda por Data</h2>
			         <span class="required_notification">* Campos para Preenchimento</span>
			    </li>
			    <li>
				    <label for="codigoGetByData">Data Venda:</label>
					<input type="text" name="codigoGetByData" required />			    
					<span class="form_hint">Data da Venda que sera Pesquisada</span>
				</li>
				<li>
				    <button class="submit" type="submit">Enviar Formulario</button>
				</li>
				<li>
					<a href="http://localhost:8080/ConcessionariaCastelo/pesquisarvenda"><h2 align="center">Lista Vendas por Data</h2></a>
				</li>
		  </ul>
	  </form>
	  
	  	  <form class="contact_form" action="pesquisavendavendedor" method="post" name="contact_form">
			<ul>
			    <li>
			         <h2>Formulario de Pesquisa de Venda por Registro do Vendedor</h2>
			         <span class="required_notification">* Campos para Preenchimento</span>
			    </li>
			    <li>
				    <label for="codigoGetByVendedor">Registro Vendedor:</label>
					<input type="text" name="codigoGetByVendedor" required />			    
					<span class="form_hint">Registro do Vendedor que sera Pesquisado</span>
				</li>
				<li>
				    <button class="submit" type="submit">Enviar Formulario</button>
				</li>
				<li>
					<a href="http://localhost:8080/ConcessionariaCastelo/pesquisavendavendedor"><h2 align="center">Lista Vendas por Vendedor</h2></a>
				</li>
		  </ul>
	  </form>

</body>
</html>