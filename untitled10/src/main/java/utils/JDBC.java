package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    private static String dbUrl="jdbc:mysql://localhost:3306/t2";
    private static String dbUserName="root";
    private static String dbPassword="748596";
    private static String jdbcName = "com.mysql.jdbc.Driver";
    private static Connection connection;
    static{
        try {
            Class.forName(jdbcName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection =  DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    public static void closeConnection(Connection connection){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
