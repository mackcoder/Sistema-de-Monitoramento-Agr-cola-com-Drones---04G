import java.util.Objects;

public class Usuario {
    private String nome;
    private String login;
    private String senhaHash; // Armazenar o hash da senha

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senhaHash = gerarHash(senha);
    }

    // Método de autenticação
    public boolean autenticar(String loginInformado, String senhaInformada) {
        return this.login.equals(loginInformado) &&
               Objects.equals(this.senhaHash, gerarHash(senhaInformada));
    }

    // Simulação de hash (não seguro para produção)
    private String gerarHash(String senha) {
        return Integer.toHexString(senha.hashCode()); // Simples hash para exemplo
    }

    // Getters
    public String getNome() { return nome; }
    public String getLogin() { return login; }
}
