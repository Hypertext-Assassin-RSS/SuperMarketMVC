package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @PROJECT SuperMarketMVC
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 11
 **/
public class DBConnection {

    private static DBConnection dbConnection;

    private Connection connection;

    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        DriverManager.getConnection("jdbc:mysql//127.0.0.1:3306/Business","root","1234");
    }

    public static DBConnection getInstance(){
        if (dbConnection == null){
            try {
                dbConnection = new DBConnection();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return dbConnection;
    }

    public Connection getConnection(){
        return connection;
    }
}
