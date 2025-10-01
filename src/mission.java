public class Missao {
    private String idMissao;
    private String areaDesignada;
    private LocalDate dataAgendada;
    private String[] sensoresUtilizados;
    private String idDrone;

    public Missao(String idMissao, String areaDesignada, LocalDate dataAgendada, String[] sensoresUtilizados, String idDrone) {
        this.idMissao = idMissao;
        this.areaDesignada = areaDesignada;
        this.dataAgendada = dataAgendada;
        this.sensoresUtilizados = sensoresUtilizados;
        this.idDrone = idDrone;
    }

    // Verifica se a missão está agendada para hoje
    public boolean isMissaoHoje() {
        return LocalDate.now().equals(dataAgendada);
    }

    // Verifica se sensores estão definidos
    public boolean sensoresValidos() {
        return sensoresUtilizados != null && sensoresUtilizados.length > 0;
    }

    // Getters
    public String getIdMissao() { return idMissao; }
    public String getAreaDesignada() { return areaDesignada; }
    public LocalDate getDataAgendada() { return dataAgendada; }
    public String[] getSensoresUtilizados() { return sensoresUtilizados; }
    public String getIdDrone() { return idDrone; }

    // Setters
    public void setDataAgendada(LocalDate novaData) {
        this.dataAgendada = novaData;
    }

    public void setSensoresUtilizados(String[] novosSensores) {
        this.sensoresUtilizados = novosSensores;
    }
}
