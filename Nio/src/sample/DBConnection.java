package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    public static Connection partConnection() {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           // String url = "jdbc:sqlserver://LAPTOP-T7KM4803\\EXPRESS; databaseName=Nio; username=DAndrei; password=Thurrock01" ;
            String connectionUrl = "jdbc:sqlserver://LAPTOP-T7KM4803\\SQLEXPRESS; DatabaseName=Nio";
            String username = "DAndrei";
            String password = "Thurrock01";
            con = DriverManager.getConnection(connectionUrl,username,password);

        } catch(ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;

    }


}
