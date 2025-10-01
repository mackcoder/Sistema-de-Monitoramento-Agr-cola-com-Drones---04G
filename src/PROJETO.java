import java.time.LocalDateTime;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

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
    public StatusMission getStatus() { return status; }
    public LocalDateTime getDataHoraInicio() { return dataHoraInicio; }
    public LocalDateTime getDataHoraFim() { return dataHoraFim; }
    public List<String> getObjetivos() { return objetivos; }
}

public class valida {
    public static boolean validar(Usuario usuario, String loginInformado, String senhaInformada) {
        return usuario.getLogin().equals(loginInformado) &&
               usuario.getSenha().equals(senhaInformada);
    }
}

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

public enum StatusMissao {
    PENDENTE,
    EM_ANDAMENTO,
    CONCLUIDA
}

public class User {
    private String nome;
    private String login;
    private String password;

    public User(String nome, String login, String password) {
        this.nome = nome;
        this.login = login;
        this.password = password;
    }

    public boolean login(String loginInformado, String senhaInformada) {
        return this.login.equals(loginInformado) && this.password.equals(senhaInformada);
    }

    public String getNome() { return nome; }
    public String getLogin() { return login; }
    public String getPassword() { return password; }

    public void setNome(String nome) { this.nome = nome; }
    public void setLogin(String login) { this.login = login; }
    public void setPassword(String password) { this.password = password; }

    
    public void encerrar() {
        System.out.println("🔒 Sessão encerrada para o usuário: " + nome);
    }
}

// MAIN:

public class Main_Control {
    public static void main(String[] args) {
        var scanner = new java.util.Scanner(System.in);

        // Entrada dinâmica de login e senha
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu login: ");
        String login = scanner.nextLine();

        String senha;
        var console = System.console();
        if (console != null) {
            char[] senhaChars = console.readPassword("Digite sua senha: ");
            senha = new String(senhaChars);
        } else {
            System.out.println("⚠️ Console não disponível. Usando entrada visível.");
            System.out.print("Digite sua senha: ");
            senha = scanner.nextLine();
        }

        // Criação do usuário com dados informados
        var usuario = new Usuario(nome, login, senha);

        // Validação simples (simula login com os mesmos dados)
        System.out.print("Confirme seu login: ");
        String loginConfirmado = scanner.nextLine();

        System.out.print("Confirme sua senha: ");
        String senhaConfirmada = scanner.nextLine();

        if (valida.validar(usuario, loginConfirmado, senhaConfirmada)) {
            System.out.println("✅ Login autorizado. Bem-vindo, " + usuario.getNome());

            var drone1 = new Drone("RDBLL5", "Red Bull", StatusDrone.PRONTO, 25.0f);
            var bd = new bd_drone(); 
            bd.inserirDrone(drone1);
            bd.listarDrones();

            var missao = new Missao("MS003", "Monitoramento da Área 5 - Soja",
                    java.util.List.of("Captura de imagem", "Leitura de temperatura"));

            drone1.receberParametrosMissao(missao);
            drone1.executarMissao(missao);

            if (drone1.detectarEventoCritico()) {
                System.out.println("⚠️ Evento crítico detectado!");
            }

            drone1.retornarBase();
            System.out.println("Status final do drone: " + drone1.getStatus());
        } else {
            System.out.println("❌ Login ou senha incorretos. Acesso negado.");
        }

        scanner.close();
    }
}

