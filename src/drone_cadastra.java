public class Drone {
    private String idDrone;
    private String modelo;
    private StatusDrone status;
    private float autonomia; // em minutos ou km

    public Drone(String idDrone, String modelo, StatusDrone status, float autonomia) {
        this.idDrone = idDrone;
        this.modelo = modelo;
        this.status = status;
        this.autonomia = autonomia;
    }

    public void receberParametrosMission(Mission missao) {
        System.out.println("📡 Drone " + idDrone + " recebeu missão: " + m.getDescricao());
    }
        // Lógica para armazenar ou validar missão
    }

    public void executarMission() {
        m.iniciar();
        if (status == StatusDrone.PRONTO) {
            System.out.println("Drone " + idDrone + " executando missão...");
            status = StatusDrone.EM_MISSAO;
        } else {
            System.out.println("Drone não está pronto para missão.");
        }
        m.encerrar();
    }

    public void retornarBase() {
        System.out.println("Drone " + idDrone + " retornando à base...");
        status = StatusDrone.PRONTO;
    }

    public boolean detectarEventoCritico() {
        // Simulação de evento crítico (ex: bateria baixa)
        boolean evento = autonomia < 20;
        if (evento) {
            System.out.println("Evento crítico detectado no drone " + idDrone);
        }
        return evento;
    }

    // Getters e setters
    public String getIdDrone() { return idDrone; }
    public String getModelo() { return modelo; }
    public StatusDrone getStatus() { return status; }
    public float getAutonomia() { return autonomia; }

    public void setStatus(StatusDrone status) { this.status = status; }
    public void setAutonomia(float autonomia) { this.autonomia = autonomia; }
}


