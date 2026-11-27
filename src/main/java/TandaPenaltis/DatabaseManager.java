package TandaPenaltis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.ConexionDB;
import Dominio.PenaltyShotooutSimulator;

public class DatabaseManager {

    public static void savePenaltyShotoout(PenaltyShotooutRegister match) {
        try (Connection conexion = ConexionDB.getConnection()) {
            conexion.setAutoCommit(false);
            try {
                savePlayer(match.getKicker(), conexion);
                savePlayer(match.getGoalkeeper(), conexion);
                saveMatchRecord(match, conexion);
                conexion.commit();
                System.out.println("Datos correctamente insertados");
            } catch (SQLException e) {
                try {
                    conexion.rollback();
                } catch (SQLException ex) {
                    e.addSuppressed(ex);
                }
                throw e;
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
        }
    }

    public static void savePlayer(Player player, Connection conexion) throws SQLException {
        String sql = "INSERT INTO Jugador (nombre_jugador, dorsal_jugador, habilidad_jugador) VALUES (?, ?, ?)";

        // Le agregamos Statement.RETURN_GENERATED_KEYS al final
        try (PreparedStatement pstmt = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

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

        }
    }

    public static void saveMatchRecord(PenaltyShotooutRegister match, Connection conexion) throws SQLException {
        String sql = "INSERT INTO Historial_Tanda (id_tirador, id_arquero, goles, atajadas) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setInt(1, match.getKicker().getDbId());
            pstmt.setInt(2, match.getGoalkeeper().getDbId());
            pstmt.setInt(3, match.getGoals());
            pstmt.setInt(4, match.getSaves());

            int insertedRows = pstmt.executeUpdate();

            if (insertedRows > 0) {
                System.out.println("¡Resultado del partido guardado en el historial de la base de datos!");
            }

        }
    }

    public static List<MatchHistoryDTO> getMatchHistory() {
        String sql = "SELECT t.nombre_jugador AS nombre_tirador, h.goles, a.nombre_jugador AS nombre_arquero, h.atajadas " +
                "FROM Historial_Tanda AS h " +
                "INNER JOIN Jugador AS t ON h.id_tirador = t.id_jugador " +
                "INNER JOIN Jugador AS a ON h.id_arquero = a.id_jugador;";

        ArrayList<MatchHistoryDTO> history = new ArrayList<>();
        try(Connection conexion = ConexionDB.getConnection();
            PreparedStatement pstmt = conexion.prepareStatement(sql)){

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            String kickerName = rs.getString("nombre_tirador");
            int goals = rs.getInt("goles");
            String gkName = rs.getString("nombre_arquero");
            int saves = rs.getInt("atajadas");

            history.add(new MatchHistoryDTO(kickerName, gkName, goals, saves));
        }
            System.out.println("-------------------------------------\n");
        } catch (SQLException e) {
            System.out.println("No se pudo leer los datos de la tanda. Detalle: " + e.getMessage());
        }
        return history;
    }
}