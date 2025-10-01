import java.util.Arrays;
import java.util.Scanner;
import java.io.Console;

public class Main_Control {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = new Usuario("Naoto", "naoto123", "senhaSegura");

        System.out.print("Login: ");
        String login = scanner.nextLine();

        String senha;
        Console console = System.console();
        if (console != null) {
            char[] senhaChars = console.readPassword("Senha: ");
            senha = new String(senhaChars);
        } else {
            System.out.println("⚠️ Console não disponível. Usando Scanner como alternativa.");
            System.out.print("Senha: ");
            senha = scanner.nextLine();
        }

        if (valida.validar(usuario, login, senha)) {
            System.out.println("✅ Login autorizado. Bem-vindo, " + usuario.getNome());

            Drone drone1 = new Drone("RDBLL5", "Red Bull", StatusDrone.PRONTO, 25.0f);

            bd_drone bd = new bd_drone(); 
            bd.inserirDrone(drone1);
            bd.listarDrones();

            Missao missao = new Missao("MS003", "Monitoramento da Área 5 - Soja",
                    Arrays.asList("Captura de imagem", "Leitura de temperatura"));

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
