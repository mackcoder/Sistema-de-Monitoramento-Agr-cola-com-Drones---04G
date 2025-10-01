import java.sql.*;

public class bd_drone {
    private final String url = "jdbc:postgresql://localhost:5432/loja";
    private final String user = "app_user";
    private final String pass = "app_pwd";

    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }

    public void inserirDrone(Drone drone) {
        String sql = "INSERT INTO drone (id_drone, modelo, status, autonomia) VALUES (?, ?, ?, ?)";
        // Loop para inserir info dos drones no Banco de dados:
        try (Connection conn = conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, drone.getIdDrone());
            ps.setString(2, drone.getModelo());
            ps.setString(3, drone.getStatus().name());
            ps.setFloat(4, drone.getAutonomia());
            ps.executeUpdate();   // Atualiza
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
}
