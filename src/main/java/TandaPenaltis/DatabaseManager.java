package TandaPenaltis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Database.ConexionDB;
import Dominio.PenaltyShotooutSimulator;

public class DatabaseManager {

    public static void savePlayer(Player player) {
        String sql = "INSERT INTO Jugador (nombre_jugador, dorsal_jugador, habilidad_jugador) VALUES (?, ?, ?)";

        // Le agregamos Statement.RETURN_GENERATED_KEYS al final
        try (Connection conexion = ConexionDB.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, player.getName());
            pstmt.setInt(2, player.getJerseyNumber());
            pstmt.setInt(3, player.getSkillLevel());

            int insertedRows = pstmt.executeUpdate();

            if (insertedRows > 0) {
                try (java.sql.ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idGenerado = rs.getInt(1);
                        player.setDbId(idGenerado);
                        System.out.println("¡" + player.getName() + " guardado con el ID " + idGenerado + "!");
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("No se pudo guardar en MySQL. Detalle: " + e.getMessage());
        }
    }

    public static void saveMatchRecord(PenaltyShotooutRegister match) {
        String sql = "INSERT INTO Historial_Tanda (id_tirador, id_arquero, goles, atajadas) VALUES (?, ?, ?, ?)";

        try (Connection conexion = ConexionDB.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setInt(1, match.getKicker().getDbId());
            pstmt.setInt(2, match.getGoalkeeper().getDbId());
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

    public static void getMatchHistory() {
        String sql = "SELECT t.nombre_jugador AS nombre_tirador, h.goles, a.nombre_jugador AS nombre_arquero, h.atajadas " +
                "FROM Historial_Tanda AS h " +
                "INNER JOIN Jugador AS t ON h.id_tirador = t.id_jugador " +
                "INNER JOIN Jugador AS a ON h.id_arquero = a.id_jugador;";

        try(Connection conexion = ConexionDB.getConnection();
            PreparedStatement pstmt = conexion.prepareStatement(sql)){

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            String kickerName = rs.getString("nombre_tirador");
            int goals = rs.getInt("goles");
            String gkName = rs.getString("nombre_arquero");
            int saves = rs.getInt("atajadas");

            System.out.println("Tirador: " + kickerName + " - Goles: " + goals + " | vs | Arquero : "
                    + gkName + " - Atajadas: " + saves);
        }
            System.out.println("-------------------------------------\n");
        } catch (SQLException e) {
            System.out.println("No se pudo leer los datos de la tanda. Detalle: " + e.getMessage());
        }
    }
}