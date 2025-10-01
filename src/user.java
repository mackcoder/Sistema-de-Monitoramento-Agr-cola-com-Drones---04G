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
