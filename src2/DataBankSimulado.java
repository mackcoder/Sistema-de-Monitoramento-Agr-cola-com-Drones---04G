package PROJETO_DRONE;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* Integrantes
    - Andre Doerner Duarte - 10427938
    - Naoto Ushizaki - 10437445
*/
public class DataBankSimulado {
    private final Map<String, Drone> drones = new HashMap<>();
    private final Map<String, Mission> missoes = new HashMap<>();
    private final Map<String, UserDrone> users = new HashMap<>();

    // 1. Métodos de gerenciamento de Drones
    public void insertDrone(Drone drone) {
        if (drone != null && drone.getIdDrone() != null) {
            drones.put(drone.getIdDrone(), drone);
            System.out.println("✅ Drone inserido no banco: " + drone.getIdDrone());
        }
    }

    public Collection<Drone> listDrones() {
        Collection<Drone> lista = drones.values();

        if (lista.isEmpty()) return lista;

        for (Drone d : lista) {
            System.out.println(" | Detalhes do Drone: " + d.getIdDrone());
        }
        return lista;
    }

    public Drone searchDrone(String idDrone) {
        return drones.get(idDrone);
    }

    // 2. Métodos de gerenciamento de Missões
    public void registerMission(Mission mission) {
        if (mission != null && mission.getIdMissao() != null) {
            missoes.put(mission.getIdMissao(), mission);
            System.out.println("✅ Missão registrada no banco: " + mission.getIdMissao());
        }
    }

    // 3. Métodos de gerenciamento de Usuários
    public void insertUser(UserDrone user) {
        if (user != null && user.getLogin() != null) {
            users.put(user.getLogin(), user);
            System.out.println("✅ Usuário inserido no banco: " + user.getLogin());
        }
    }

    public UserDrone buscarUsuarioPorLogin(String login) {
        return users.get(login);
    }

    //Autenticação agora depende de o usuário já ter sido inserido previamente.
     
    public boolean autenticarUsuario(String login, String senhaEmTextoPuro) {
        UserDrone usuario = buscarUsuarioPorLogin(login);

        if (usuario == null) {
            return false; // Usuário não encontrado no banco.
        }

        // Delega a verificação de credenciais para o UserDrone
        return usuario.autenticar(login, senhaEmTextoPuro);
    }
}
