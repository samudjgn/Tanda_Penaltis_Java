package TandaPenaltis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GestorBD {

    public static void guardarJugador(Jugador jugador) {
        String sql = "INSERT INTO Jugador (nombre_jugador, dorsal_jugador, habilidad_jugador) VALUES (?, ?, ?)";

        try (Connection conexion = ConexionDB.obtenerConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setString(1, jugador.getNombre());
            pstmt.setInt(2, jugador.getDorsal());
            pstmt.setInt(3, jugador.getHabilidad());

            int filasInsertadas = pstmt.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("¡" + jugador.getNombre() + " sincronizado con la base de datos!");
            }

        } catch (SQLException e) {
            System.out.println("No se pudo guardar en MySQL (modo memoria local activo). Detalle: " + e.getMessage());
        }
    }
}