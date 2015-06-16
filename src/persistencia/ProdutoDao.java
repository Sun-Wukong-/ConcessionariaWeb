package persistencia;






import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Produto;

/**
 *
 * @author Wukong
 */
public class ProdutoDao {
    
    	private final Connection connection;
	
	// Conecção
	public ProdutoDao() throws SQLException {
		this.connection = ConnectionFactory.getConnection();
	}
        
    //Adicionar no BD
   public void adicionar(Produto produto) {
        String sql = "insert into produto " +
             "(modelo,marca,ano,cor,preco)" +
             " values (?,?,?,?,?)";
 
        try {
           // seta os valores
           try ( // prepared statement para inserção
                   PreparedStatement stmt = connection.prepareStatement(sql)) {
               // seta os valores
               stmt.setString(1,produto.getModelo());
               stmt.setString(2,produto.getMarca());
               stmt.setInt(3, produto.getAno());
               stmt.setString(4,produto.getCor());
               stmt.setDouble(5,produto.getPreco());
               
               // executa
               stmt.execute();
           }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } 
    }
   
      public void adicionar2(Produto produto) {
        String sql = "insert into produtoF " +
             "(modelo,marca,ano,cor,preco)" +
             " values (?,?,?,?,?)";
 
        try {
           // seta os valores
           try ( // prepared statement para inserção
                   PreparedStatement stmt = connection.prepareStatement(sql)) {
               // seta os valores
               stmt.setString(1,produto.getModelo());
               stmt.setString(2,produto.getMarca());
               stmt.setInt(3, produto.getAno());
               stmt.setString(4,produto.getCor());
               stmt.setDouble(5,produto.getPreco());
               
               // executa
               stmt.execute();
           }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } 
    }
   
     //Alterar BD
    public void alterar(Produto produto) {
        String sql = "update produto set modelo=?, marca=? , ano=?, cor=?, preco=? "+
            "where codigoProduto=? ";
        
        try {
            try (PreparedStatement stmt = connection
                    .prepareStatement(sql)) {
                stmt.setString(1,produto.getModelo());
                stmt.setString(2,produto.getMarca());
                stmt.setInt(3, produto.getAno());
                stmt.setString(4,produto.getCor());
                stmt.setDouble(5,produto.getPreco());
                stmt.setLong(6, produto.getCodigo());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }   
    }
    
        //Alterar BD
    public void alterar2(Produto produto) {
        String sql = "update produtoF set modelo=?, marca=? , ano=?, cor=?, preco=? "+
            "where codigoProduto=? ";
        
        try {
            try (PreparedStatement stmt = connection
                    .prepareStatement(sql)) {
                stmt.setString(1,produto.getModelo());
                stmt.setString(2,produto.getMarca());
                stmt.setInt(3, produto.getAno());
                stmt.setString(4,produto.getCor());
                stmt.setDouble(5,produto.getPreco());
                stmt.setLong(6, produto.getCodigo());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }   
    }
    //Remover BD
    public void remover(int id) {
        try {
             PreparedStatement stmt = connection.prepareStatement("delete from produtoF where codigoProduto=?");
             stmt.setInt(1, id);
             stmt.execute();
             stmt.close();
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
     } 
    
	// Pesquisar os dados do BD	pelo código
	public List<Produto> getAllProdutos() throws SQLException {
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		String sql = "select * from produtoF";
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		// Executa o select
		ResultSet rs = stmt.executeQuery();
				
		while (rs.next()) {
			
			Produto produto = new Produto();
			
			produto.setCodigo(rs.getLong("codigoProduto"));
			produto.setMarca(rs.getString("marca"));
			produto.setModelo(rs.getString("modelo"));
			produto.setCor(rs.getString("cor"));
			produto.setAno(rs.getInt("ano"));
			produto.setPreco(rs.getDouble("preco"));
			
			produtos.add(produto);
		}		
		
		rs.close();
		stmt.close();
		
		return produtos;
	}	
	
	 public Produto getProdutoById(int id) {
	        Produto produto = new Produto();
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("select * from produtoF where codigoProduto=?");
	            preparedStatement.setInt(1, id);
	            ResultSet rs = preparedStatement.executeQuery();
	 
	            if (rs.next()) {
	    			produto.setCodigo(rs.getLong("codigoProduto"));
	    			produto.setMarca(rs.getString("marca"));
	    			produto.setModelo(rs.getString("modelo"));
	    			produto.setCor(rs.getString("cor"));
	    			produto.setAno(rs.getInt("ano"));
	    			produto.setPreco(rs.getDouble("preco"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 
	        return produto;
	    }
}