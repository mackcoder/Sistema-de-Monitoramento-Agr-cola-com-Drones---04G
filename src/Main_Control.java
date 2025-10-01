import java.util.Arrays;
import java.util.Scanner;

public class Main_Control {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = new Usuario("Naoto", "naoto123", "senhaSegura");

        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        if (usuario.autenticar(login, senha)) {
            System.out.println("✅ Login autorizado. Bem-vindo, " + usuario.getNome());

            Drone drone1 = new Drone("DRN001", "DJI Phantom", StatusDrone.PRONTO, 25.0f);

            Missao missao = new Missao("MS003", "Monitoramento da Área 5 - Milho",
                    Arrays.asList("Captura de imagem", "Leitura de temperatura"));

            drone1.receberParametrosMissao(missao);
            drone1.executarMissao(missao);

            if (drone1.detectarEventoCritico()) {
                System.out.println("⚠️ Evento crítico detectado!");
            }

            drone1.retornarBase();
            System.out.println("Status final do drone: " + drone1.getStatus());
        } else {
            System.out.println("❌ Acesso negado.");
        }

        scanner.close();
    }
}
