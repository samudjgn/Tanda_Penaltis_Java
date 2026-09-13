package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/torneo_penaltis";
    private static final String USER = "samu_db";
    private static final String PASSWORD = "s4mu1t0123321";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Invoca al Driver que inyectaste en el pom.xml de Maven
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establece el puente físico con el servidor
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("¡Conexión exitosa a la base de datos de tu torneo!");

        } catch (ClassNotFoundException e) {
            System.out.println("Error crítico: No se encontró el driver JDBC de MySQL.");
        } catch (SQLException e) {
            System.out.println("Fallo de conexión a la base de datos: " + e.getMessage());
        }
        return connection;
    }
}
