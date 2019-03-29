package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author alumne
 */
public class DBConnection {

    Connection conn = null;

    static final String DB_URL = "jdbc:mysql://univeylandia.cat:3306/univeylandia_test2";
    static final String DB_DRV = "com.mysql.jdbc.Driver";
    static final String DB_USER = "super";
    static final String DB_PASSWD = "Alumne123";

    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void disconnect() {
        try {
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
