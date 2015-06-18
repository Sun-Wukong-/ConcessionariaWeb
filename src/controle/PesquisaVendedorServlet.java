package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Venda;
import persistencia.VendaDao;

@WebServlet("/pesquisavendavendedor")
@SuppressWarnings("serial")
public class PesquisaVendedorServlet extends HttpServlet {    
    
	private int id;
	private Venda venda;

	@Override
    protected void service(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
		try{
    		id = Integer.parseInt(request.getParameter("codigoGetByVendedor"));
    	}catch(NumberFormatException e){} 
        
        try {
            VendaDao dao = new VendaDao();
             venda = dao.getVendaByVendedor(id);
        } catch (Exception e) {
            
        } 
        
      //Coloca a Lista no Request
      		request.setAttribute("venda",venda);

      		//Encaminhando para o JSP
      		RequestDispatcher saida = request.getRequestDispatcher("listavendabyvendedor.jsp");
      		saida.forward(request,response);
    }
}
