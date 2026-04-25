import java.sql.*;

public class DBConnection {
    static final String URL = "jdbc:mysql://localhost:3306/RestaurantDB?useSSL=false&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "password";

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }
}