
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() throws SQLException{
        System.out.println("Conectando ao banco");
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Banco conectado");
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            return DriverManager.getConnection("jdbc:mysql://localhost/bandas", "root", "root");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
} 
