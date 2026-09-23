package TandaPenaltis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Database.ConexionDB;
import Dominio.PenaltyShotooutSimulator;

public class DatabaseManager {

    public static void savePlayer(Player player) {
        String sql = "INSERT INTO Jugador (nombre_jugador, dorsal_jugador, habilidad_jugador) VALUES (?, ?, ?)";

        try (Connection conexion = ConexionDB.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setString(1, player.getName());
            pstmt.setInt(2, player.getJerseyNumber());
            pstmt.setInt(3, player.getSkillLevel());

            int insertedRows = pstmt.executeUpdate();

            if (insertedRows > 0) {
                System.out.println("¡" + player.getName() + " sincronizado con la base de datos!");
            }

        } catch (SQLException e) {
            System.out.println("No se pudo guardar en MySQL (modo memoria local activo). Detalle: " + e.getMessage());
        }
    }

    public static void saveMatchRecord(PenaltyShotooutRegister match) {
        String sql = "INSERT INTO Historial_Tanda (tirador, atajador, goles, atajadas) VALUES (?, ?, ?, ?)";

        try (Connection conexion = ConexionDB.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setString(1, match.getKicker().getName());
            pstmt.setString(2, match.getGoalkeeper().getName());
            pstmt.setInt(3, match.getGoals());
            pstmt.setInt(4, match.getSaves());

            int insertedRows = pstmt.executeUpdate();

            if (insertedRows > 0) {
                System.out.println("¡Resultado del partido guardado en el historial de la base de datos!");
            }

        } catch (SQLException e) {
            System.out.println("No se pudo guardar en MySQL (modo memoria local activo). Detalle: " + e.getMessage());
        }

    }
}