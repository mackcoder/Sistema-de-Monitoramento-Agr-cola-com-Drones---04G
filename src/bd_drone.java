import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

public class bd_drone {
    private final String url = "jdbc:postgresql://localhost:5432/loja";
    private final String user = "app_user";
    private final String pass = "app_pwd";

    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }

    public void inserirDrone(Drone drone) {
        String sql = "INSERT INTO drone (id_drone, modelo, status, autonomia) VALUES (?, ?, ?, ?)";
        try (Connection conn = conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, drone.getIdDrone());
            ps.setString(2, drone.getModelo());
            ps.setString(3, drone.getStatus().name());
            ps.setFloat(4, drone.getAutonomia());
            ps.executeUpdate();
            System.out.println("✅ Drone inserido no banco.");
        } catch (SQLException e) {
            System.out.println("❌ Erro ao inserir drone: " + e.getMessage());
        }
    }

    public void listarDrones() {
        String sql = "SELECT id_drone, modelo, status, autonomia FROM drone";
        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("📋 Lista de drones:");
            while (rs.next()) {
                System.out.println(
                    rs.getString("id_drone") + " | " +
                    rs.getString("modelo") + " | " +
                    rs.getString("status") + " | " +
                    rs.getFloat("autonomia")
                );
            }
        } catch (SQLException e) {
            System.out.println("❌ Erro ao consultar drones: " + e.getMessage());
        }
    }

    public void registarMissao(Mission missao) {
        String sql = "INSERT INTO missao (id_missao, descricao, status, data_inicio, data_fim, objetivos) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, missao.getIdMission());
            ps.setString(2, missao.getDescricao());
            ps.setString(3, missao.getStatus().name());
            ps.setTimestamp(4, missao.getDataHoraInicio() != null ? Timestamp.valueOf(missao.getDataHoraInicio()) : null);
            ps.setTimestamp(5, missao.getDataHoraFim() != null ? Timestamp.valueOf(missao.getDataHoraFim()) : null);
            ps.setString(6, String.join(",", missao.getObjetivos()));
            ps.executeUpdate();
            System.out.println("✅ Missão registrada no banco.");
        } catch (SQLException e) {
            System.out.println("❌ Erro ao registrar missão: " + e.getMessage());
        }
    }
}
