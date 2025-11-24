/* Integrantes
    - Andre Doerner Duarte - 10427938
    - Naoto Ushizaki - 10437445
*/
package PROJETO_DRONE;

// DRONE
public class Drone {
    private String idDrone;
    private String modelo;
    private StatusDrone status;
    private float autonomia;
    private Mission missao;

    // Construtor: inicializa um drone com id, modelo, status e autonomia
    public Drone(String idDrone, String modelo, StatusDrone status, float autonomia) {
        this.idDrone = idDrone;
        this.modelo = modelo;
        this.status = status;
        this.autonomia = autonomia;
    }

    // Associa uma missão ao drone
    public void receberMissao(Mission missao) {
        this.missao = missao;
        System.out.println("📡 Drone " + idDrone + " recebeu missão: " + missao.getDescricao());
    }

    // Inicia a missão se o drone estiver pronto e a missão for válida
    public void iniciarMissao() {
        if (status == StatusDrone.PRONTO && missao != null && missao.validar()) {
            missao.iniciar();
            status = StatusDrone.EM_MISSAO;
            System.out.println("Drone " + idDrone + " executando missão...");
        } else {
            System.out.println("Drone não está pronto para missão ou missão inválida.");
        }
    }

    public void encerrarMissao() {
        if (missao != null && status == StatusDrone.EM_MISSAO) {
            missao.encerrar();
            status = StatusDrone.CONCLUIDA;
            System.out.println("Drone " + idDrone + " concluiu a missão.");
        }
    }

    // Simula o retorno do drone à base e redefine o status para PRONTO
    public void retornarBase() {
        System.out.println("Drone " + idDrone + " retornando à base...");
        status = StatusDrone.PRONTO;
    }

    public void diagnostico() {
        System.out.println("Diagnóstico do drone " + idDrone +
            ": Autonomia = " + autonomia + " | Status = " + status);
    }

    public boolean detectarEventoCritico() {
        boolean evento = autonomia < 20;
        if (evento) {
            System.out.println("⚠️ Evento crítico detectado no drone " + idDrone);
        }
        return evento;
    }

    // Retornam as info de cada característica do drone (através de functions calls):
    public String getIdDrone() { return idDrone; }
    public String getModelo() { return modelo; }
    public StatusDrone getStatus() { return status; }
    public float getAutonomia() { return autonomia; }
    public void setStatus(StatusDrone status) { this.status = status; }
    public void setAutonomia(float autonomia) { this.autonomia = autonomia; }
}