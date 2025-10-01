public class User {
    private String nome;
    private String login;
    private String password;

    public User(String nome, String login, String password) {
        this.nome = nome;
        this.login = login;
        this.password = password;
    }

    // Método de autenticação simples
    public boolean autenticar(String loginInformado, String senhaInformada) {
        return this.login.equals(loginInformado) && this.senha.equals(senhaInformada);
    }

    public String getNome() { return nome; }
    public String getLogin() { return login; }
    public String getpassword() { return password; }

    public void setNome(String nome) { this.nome = nome; }
    public void setLogin(String login) { this.login = login; }
    public void setpassword(String password) { this.senha = password; }
}


