package PROJETO_DRONE;
import java.util.List;
import java.util.Scanner;


/* Integrantes
    - Andre Doerner Duarte - 10427938
    - Naoto Ushizaki - 104374445
*/

public class MainDrone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada dinâmica de login e senha
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu login: ");
        String login = scanner.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        UserDrone usuario = new UserDrone(nome, login, senha);

        // Validação simples
        System.out.print("Confirme seu login: ");
        String loginConfirmado = scanner.nextLine();

        System.out.print("Confirme sua senha: ");
        String senhaConfirmada = scanner.nextLine();

        if (ValidadorUser.validar(usuario, loginConfirmado, senhaConfirmada)) {
            System.out.println("✅ Login autorizado. Bem-vindo, " + usuario.getNome());

            Drone drone1 = new Drone("RDBLL5", "Red Bull", StatusDrone.PRONTO, 25.0f);
            BancoDeDronesSimulado bd = new BancoDeDronesSimulado();
            bd.inserirDrone(drone1);
            bd.listarDrones();

            Mission missao = new Mission("MS003", "Monitoramento da Área 5 - Soja",
                List.of("Captura de imagem", "Leitura de temperatura"));

            drone1.receberMissao(missao);
            drone1.iniciarMissao();

            if (drone1.detectarEventoCritico()) {
                System.out.println("⚠️ Evento crítico detectado!");
            }

            drone1.encerrarMissao();
            drone1.retornarBase();
            System.out.println("Status final do drone: " + drone1.getStatus());
        } else {
            System.out.println("❌ Login ou senha incorretos. Acesso negado.");
        }

        scanner.close();
    }
}
