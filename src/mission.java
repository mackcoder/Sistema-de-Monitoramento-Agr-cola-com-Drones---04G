import java.time.LocalDateTime;

public class Mission {
    private String idMission;
    private String descricao;
    private StatusMissao status;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private List<String> objetivos;

    public Missao(String idMission, String descricao, List<String> objetivos) {
        this.idMission = idMission;
        this.descricao = descricao;
        this.status = StatusMissao.PENDENTE;
        this.objetivos = objetivos;
    }

    public boolean validar() {
        return descricao != null && !descricao.isEmpty() &&
               objetivos != null && !objetivos.isEmpty();
    }

    public void iniciar() {
        if (validar()) {
            this.status = StatusMission.EM_ANDAMENTO;
            this.dataHoraInicio = LocalDateTime.now();
            System.out.println("🚁 Missão iniciada: " + idMission);
        } else {
            System.out.println("❌ Missão inválida. Não pode ser iniciada.");
        }
    }

    public void encerrar() {
        this.status = StatusMission.CONCLUIDA;
        this.dataHoraFim = LocalDateTime.now();
        System.out.println("✅ Missão encerrada: " + idMission);
    }

    // Getters
    public String getIdMission() { return idMission; }
    public String getDescricao() { return descricao; }
    public StatusMissao getStatus() { return status; }
    public LocalDateTime getDataHoraInicio() { return dataHoraInicio; }
    public LocalDateTime getDataHoraFim() { return dataHoraFim; }
    public List<String> getObjetivos() { return objetivos; }
}

