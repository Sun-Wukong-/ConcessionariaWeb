package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistencia.VendaDao;

@WebServlet("/removervenda")
@SuppressWarnings("serial")
public class RemoverVendaServlet extends HttpServlet {    
    
	private int id;

	@Override
    protected void service(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
    	
        id = Integer.parseInt(request.getParameter("codigoExcluir"));
        
        try {
            VendaDao dao = new VendaDao();
            dao.remover(id);
        } catch (Exception e) {
            
        } 
    }
}