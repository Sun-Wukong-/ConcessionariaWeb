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

@WebServlet("/pesquisarvenda")
public class PesquisarVendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private VendaDao dao;
	private int id;
	private String data;
	private List<Venda> vendaComp;
	private Long codigoVendedor;
    
    public PesquisarVendaServlet() throws SQLException {
        super();
        dao = new VendaDao();
    }
    
    protected void doPost(HttpServletRequest request, 
    		HttpServletResponse response) 
    				throws ServletException, IOException{
    	try{
    		id = Integer.parseInt(request.getParameter("codigoGetById"));
    	}catch(NumberFormatException e){} 
    	data = request.getParameter("codigoGetByData");
    }

    protected void doGet(HttpServletRequest request, 
    		HttpServletResponse response) 
    		throws ServletException, IOException {
    	
    	Venda venda = new Venda();
    	//Obtendo Lista
    	if(data!=null && data!="" && data!="0"){
    		 venda = dao.getVendaByData(data);
    		 vendaComp = dao.getVendaByDataComplementar(data);
    	}else {
    		venda = dao.getVendaById(id);
    	}
		
		//Coloca a Lista no Request
		request.setAttribute("venda",venda);
		request.setAttribute("vendas",vendaComp);

		
		//Encaminhando para o JSP
		RequestDispatcher saida = request.getRequestDispatcher("listavendabyid.jsp");
		saida.forward(request,response);
    } 
}