package connection;

import java.sql.Connection;                                                                       // Import per el SQL Connection
import java.sql.DriverManager;                                                                    // Import per el SQL Drive Manager

/**
 *
 * @Evaldas Casas, Jose Febrer, Ferran Climent / GRUP-2 - Gestio d'atracions del parc  
 */
public class DBConnection {

    static Connection conn = null;                                                                         // Variable per la conexio de tipus Connection

    static final String DB_URL = "jdbc:mysql://univeylandia.cat:3306/univeylandia_test2";           // Variable per igualar la localitzacio de la DB
    static final String DB_DRV = "com.mysql.jdbc.Driver";                                           // Variable per igualar la el driver de la DB
    static final String DB_USER = "super";                                                          // Variable per igualar el usuari de la DB
    static final String DB_PASSWD = "Alumne123";                                                    // Variable per igualar la contrasenya de la DB

    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);                         // Crear la variable per la conexio amb la DB
        } catch (Exception ex) {
            System.out.println(ex.getMessage());                                                    // Mostrar error si no es conecta
        }
    }

    public static Connection getConnection() {                                                             // Metode per cridar a la conexio
        return conn;
    }

    public void disconnect() {                                                                      // Metode per desconectar la conexio
        try {
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
