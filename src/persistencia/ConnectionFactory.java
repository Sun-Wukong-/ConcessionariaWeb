package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Wukong
 */
public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");   		
            return
            DriverManager.getConnection("jdbc:mysql://localhost/concessionariadb",
            "root","Taizai");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
  