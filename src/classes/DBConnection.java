package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import com.mysql.jdbc.Connection;

public class DBConnection {
    private final String bd = "CDW_SAPP";
    private final String login = "root";
    private final String password = "12345678";
    private final String url = "jdbc:mysql://localhost:3306/CDW_SAPP?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private Connection connection = null;

    public DBConnection(){
        try {
            Class.forName(driver);
            this.connection = (Connection) DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException | SQLException ex){
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection(){
        return this.connection;
    }

    public void closeConnection(){
        this.connection = null;
    }
}
