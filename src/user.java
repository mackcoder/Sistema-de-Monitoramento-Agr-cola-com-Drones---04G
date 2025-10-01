public class User {
    private String nome;
    private String login;
    private String password;

    public User(String nome, String login, String password) {
        this.nome = nome;
        this.login = login;
        this.password = password;
    }

    public String getNome() { return nome; }
    public String getLogin() { return login; }
    public String getpassword() { return password; }

    public void setNome(String nome) { this.nome = nome; }
    public void setLogin(String login) { this.login = login; }
    public void setpassword(String password) { this.senha = password; }
}



