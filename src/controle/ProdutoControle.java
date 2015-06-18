package controle;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Produto;
import persistencia.ProdutoDao;

@WebServlet("/produto")
public class ProdutoControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProdutoDao dao;
    
    public ProdutoControle() throws SQLException {
        super();
        dao = new ProdutoDao();
    }
    
    protected void doPost(HttpServletRequest request, 
    		HttpServletResponse response) 
    				throws ServletException, IOException{
    	String id = request.getParameter("codigoAlterar");
    	
    	Produto produto = new Produto();
        produto.setMarca(request.getParameter("marca"));
        produto.setModelo(request.getParameter("modelo"));
        produto.setAno(Integer.parseInt(request.getParameter("ano")));
        produto.setCor(request.getParameter("cor"));
        produto.setPreco(Double.parseDouble(request.getParameter("preco")));
        
        if(id!=null && id!="" && id!="0"){
        	produto.setCodigo(Integer.parseInt(id));
        	dao.alterar(produto);
        	dao.alterar2(produto);
        }else{
        	dao.adicionar(produto);
        	dao.adicionar2(produto);
        }
    }
    
    protected void doGet(HttpServletRequest request, 
    		HttpServletResponse response) 
    		throws ServletException, IOException {
    	
    	try {
    		//Obtendo Lista
			List<Produto> produtos = dao.getAllProdutos();
			
			//Coloca a Lista no Request
			request.setAttribute("produtos",produtos);
			
			//Encaminhando para o JSP
			RequestDispatcher saida = request.getRequestDispatcher("listaproduto.jsp");
			saida.forward(request,response);
			
		} catch (SQLException e) {}
    } 
}

