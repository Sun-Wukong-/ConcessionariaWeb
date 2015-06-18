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

import modelo.Venda;
import persistencia.VendaDao;

@WebServlet("/venda")
public class VendaControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private VendaDao dao;
    
    public VendaControle() throws SQLException {
        super();
        dao = new VendaDao();
    }
    
    protected void doPost(HttpServletRequest request, 
    		HttpServletResponse response) 
    				throws ServletException, IOException{
    	
    	//String id = request.getParameter("codigo");
    	
    	Venda venda = new Venda();

		venda.setData(request.getParameter("data"));
    	venda.setRegistroVendedor(Long.parseLong(request.getParameter("registroVendedor")));
    	venda.setCodigoProduto(Long.parseLong(request.getParameter("codigoProduto")));
    	venda.setDesconto(Double.parseDouble(request.getParameter("desconto")));
    	venda.setValorAcessorios(Double.parseDouble(request.getParameter("valorAcessorios")));
        
        dao.adicionar(venda);
    }
    
    protected void doGet(HttpServletRequest request, 
    		HttpServletResponse response) 
    		throws ServletException, IOException {
    	
    	try {
    		//Obtendo Lista
			List<Venda> vendas = dao.getAllVendas();
			
			//Coloca a Lista no Request
			request.setAttribute("vendas",vendas);
			
			//Encaminhando para o JSP
			RequestDispatcher saida = request.getRequestDispatcher("listavenda.jsp");
			saida.forward(request,response);
			
		} catch (SQLException e) {}
    } 
}
