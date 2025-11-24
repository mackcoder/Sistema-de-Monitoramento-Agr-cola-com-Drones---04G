package PROJETO_DRONE;
import java.time.LocalDateTime;
import java.util.List;
/* Integrantes
    - Andre Doerner Duarte - 10427938
    - Naoto Ushizaki - 10437445
*/
public class Mission {
    private String idMission;
    private String descricao;
    private StatusMissao status;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private List<String> objetivos;

    public Mission(String idMission, String descricao, List<String> objetivos) {
        this.idMission = idMission;
        this.descricao = descricao;
        this.status = StatusMissao.PENDENTE;
        this.objetivos = objetivos;
    }

    public boolean validar() {
        return descricao != null && !descricao.isEmpty() && objetivos != null && !objetivos.isEmpty();
    }

    public void iniciar() {
        if (validar()) {
            this.status = StatusMissao.EM_ANDAMENTO;
            this.dataHoraInicio = LocalDateTime.now();
            System.out.println("🚁 Missão iniciada: " + idMission);
        } else {
            System.out.println("❌ Missão inválida. Não pode ser iniciada.");
        }
    }

    public void encerrar() {
        this.status = StatusMissao.CONCLUIDA;
        this.dataHoraFim = LocalDateTime.now();
        System.out.println("✅ Missão encerrada: " + idMission);
    }

    // Getters
    public String getIdMissao() { return idMission; }
    public String getDescricao() { return descricao; }
    public StatusMissao getStatus() { return status; }
    public LocalDateTime getDataHoraInicio() { return dataHoraInicio; }
    public LocalDateTime getDataHoraFim() { return dataHoraFim; }
    public List<String> getObjetivos() { return objetivos; }
}
