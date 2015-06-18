package persistencia;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Venda;

/**
 *
 * @author Wukong
 */
public class VendaDao {
    
    	private final Connection connection;
	
	// Conexão
	public VendaDao() throws SQLException {
		this.connection = ConnectionFactory.getConnection();
	}
        
    //Adicionar no BD
   public void adicionar(Venda venda) {
        String sql = "insert into venda " +
             "(data,codigoVendedor,desconto,valorAcessorio,Produto_codigoProduto)" +
             " values (?,?,?,?,?)";
        try {
           // seta os valores
           try ( // prepared statement para inserção
                   PreparedStatement stmt = connection.prepareStatement(sql)) {
               // seta os valores
               stmt.setString(1, venda.getData());
               stmt.setLong(2,venda.getRegistroVendedor());
               stmt.setDouble(3, venda.getDesconto());
               stmt.setDouble(4,venda.getValorAcessorios());
               stmt.setLong(5, venda.getCodigoProduto());
               
               // executa
               stmt.execute();
           }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } 
    }
    
    //Remover do BD
    public void remover(int id) {
        try {
             PreparedStatement stmt = connection
                     .prepareStatement("delete from venda where codigoVenda=?");
             stmt.setInt(1, id);
             stmt.execute();
             stmt.close();
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
     } 
    
 // Pesquisar os dados do BD	pelo código
 	public List<Venda> getAllVendas() throws SQLException {
 		
 		List<Venda> vendas = new ArrayList<Venda>();
 		
 		String sql = "select codigoVenda, codigoVendedor, data, Produto_codigoProduto, desconto, valorAcessorio,"
                + "( produto.preco + venda.valorAcessorio - venda.desconto "
                + ") as ValorTotal " //Calculo do Valor Total
                + "from venda,produto where codigoProduto = Produto_codigoProduto";
 		PreparedStatement stmt = connection.prepareStatement(sql);
 		
 		// Executa o select
 		ResultSet rs = stmt.executeQuery();
 				
 		while (rs.next()) {
 			
 			Venda venda = new Venda();
 			
 			venda.setCodigo(rs.getLong("codigoVenda"));
 			venda.setData(rs.getString("data"));
 			venda.setRegistroVendedor(rs.getLong("codigoVendedor"));
 			venda.setCodigoProduto(rs.getInt("Produto_codigoProduto"));
 			venda.setDesconto(rs.getDouble("desconto"));
 			venda.setValorAcessorios(rs.getDouble("valorAcessorio"));
 			venda.setValorTotal(rs.getDouble("ValorTotal"));
 			
 			vendas.add(venda);
 		}		
 		
 		rs.close();
 		stmt.close();
 		
 		return vendas;
 	}	
    
    public Venda getVendaById(int id) {
        Venda venda = new Venda();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select codigoVenda, codigoVendedor, data, Produto_codigoProduto, desconto, valorAcessorio,"
                    + "( produto.preco + venda.valorAcessorio - venda.desconto "
                    + ") as ValorTotal " //Calculo do Valor Total
                    + "from venda,produto where codigoProduto = Produto_codigoProduto and codigoVenda = ? order by codigoVenda");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
 
            if (rs.next()) {
    			venda.setCodigo(rs.getLong("codigoVenda"));
    			venda.setRegistroVendedor(rs.getLong("codigoVendedor"));
    			
    			venda.setData(rs.getString("data"));
    			
    			venda.setCodigoProduto(rs.getLong("Produto_codigoProduto"));
    			venda.setDesconto(rs.getDouble("desconto"));
    			venda.setValorAcessorios(rs.getDouble("valorAcessorio"));
    			venda.setValorTotal(rs.getDouble("ValorTotal"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return venda;
    }
}
