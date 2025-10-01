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

        if (valida.validar(usuario, login, password)) {
            System.out.println("✅ Login autorizado. Bem-vindo, " + usuario.getNome());
            
            Drone drone1 = new Drone("RDBLL5", "Red Bull", StatusDrone.PRONTO, 25.0f);

            // Chamada do Banco de Dados
            bd_drone bd = new bd_drone(); 
            bd.inserirDrone(drone1);
            bd.listarDrones();

            Missao missao = new Missao("MS003", "Monitoramento da Área 5 - Soja",
                    Arrays.asList("Captura de imagem", "Leitura de temperatura"));
            // Recebe info da missao distribuida:
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


