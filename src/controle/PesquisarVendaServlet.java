package controle;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Venda;
import persistencia.VendaDao;

@WebServlet("/pesquisarvenda")
public class PesquisarVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private VendaDao dao;
	private int id;
    
    public PesquisarVendaServlet() throws SQLException {
        super();
        dao = new VendaDao();
    }
    
    protected void doPost(HttpServletRequest request, 
    		HttpServletResponse response) 
    				throws ServletException, IOException{
    	 id = Integer.parseInt(request.getParameter("codigoGetById"));
    	
    }
    
    protected void doGet(HttpServletRequest request, 
    		HttpServletResponse response) 
    		throws ServletException, IOException {
    	
    	//Obtendo Lista
		Venda venda = dao.getVendaById(id);
		
		//Coloca a Lista no Request
		request.setAttribute("venda",venda);
		
		//Encaminhando para o JSP
		RequestDispatcher saida = request.getRequestDispatcher("listavendabyid.jsp");
		saida.forward(request,response);
    } 
}