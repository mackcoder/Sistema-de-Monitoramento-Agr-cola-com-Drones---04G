package PROJETO_DRONE;
import java.util.ArrayList;
import java.util.List;
/* Integrantes
    - Andre Doerner Duarte - 10427938
    - Naoto Ushizaki - 10437445
*/
public class BancoDeDronesSimulado {
    private List<Drone> drones = new ArrayList<>();
    private List<Mission> missoes = new ArrayList<>();

    //Inserindo os drones:
    public void inserirDrone(Drone drone) {
        if (drone != null) {
            drones.add(drone);
            System.out.println("✅ Drone inserido no banco: " + drone.getIdDrone());
        }
    }

    // Lista dos drones:
    public void listarDrones() {
        System.out.println("📋 Lista de drones:");
        for (Drone d : drones) {
            System.out.println(d.getIdDrone() + " | " + d.getModelo() + " | " + d.getStatus() + " | " + d.getAutonomia());
        }
    }

    // Registro de missao:
    public void registrarMissao(Mission missao) {
        // Verifica se missao existe:
        if (missao != null) {
            missoes.add(missao);
            System.out.println("✅ Missão registrada no banco: " + missao.getIdMissao());
        }
    }
}
