/* Integrantes
    - Andre Doerner Duarte - 10427938
    - Naoto Ushizaki - 10437445
*/
package PROJETO_DRONE;

// USUÁRIO
public class UserDrone {
    private String nome, login, senha;

    public UserDrone(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() { return nome; }
    public String getLogin() { return login; }
    public String getSenha() { return senha; }
}