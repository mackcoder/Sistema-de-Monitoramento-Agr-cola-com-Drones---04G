/* Integrantes
    - Andre Doerner Duarte - 10427938
    - Naoto Ushizaki - 10437445
*/
package PROJETO_DRONE;
import java.util.Objects;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// USUÁRIO
public class UserDrone implements AuthenticationUser {
    private String nome, login;
    private final String hashPassword;
    private final String role;
    private int falhaLoginCount = 0;

    public UserDrone(String nome, String login, String senha, String role) {
        this.nome = Objects.requireNonNull(nome, "Nome nulo não permitido");
        this.login = Objects.requireNonNull(login, "Login nulo não permitido");
        this.hashPassword = gerarHashSHA256(Objects.requireNonNull(senha, "Senha nula não permitida"));
        this.role = Objects.requireNonNull(role.toLowerCase(), "Invalid Role");
    }

    // Exemplo didático com SHA-256
    private String gerarHashSHA256(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(senha.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar hash SHA-256", e);
        }
    }

    @Override
    public boolean autenticar(String GivenLogin, String GivenPassword) {
        if (!this.login.equals(GivenLogin)) {
            return false;
        }
        String GivenHash = gerarHashSHA256(GivenPassword);
        return GivenHash.equals(this.hashPassword);
    }

    // Getters
    public String getNome() { return nome; }
    public String getLogin() { return login; }
    public String getRole() { return role; }
    public int getFalhaLoginCount() { return falhaLoginCount; }

    // Métodos de controle de falhas
    public void incrementarFalhaLogin() { this.falhaLoginCount++; }
    public void resetarFalhaLogin() { this.falhaLoginCount = 0; }
}