import java.util.Scanner;

public class Main_Control {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Simulando um usuário cadastrado
        Usuario usuario = new Usuario("Naoto", "naoto123", "senhaSegura");

        // Autenticação
        System.out.print("Login: ");
        String loginInformado = scanner.nextLine();

        System.out.print("Senha: ");
        String senhaInformada = scanner.nextLine();

        if (usuario.autenticar(loginInformado, senhaInformada)) {
            System.out.println("✅ Login autorizado. Bem-vindo, " + usuario.getNome());

            // Criando um drone
            Drone drone1 = new Drone("DRN001", "DJI Phantom", StatusDrone.PRONTO, 25.0f);

            // Criando uma missão
            Mission missao1 = new Mission("MS001", "Área 12 - Soja", "2025-10-01");

            // Enviando parâmetros da missão
            drone1.receberParametrosMission(missao1);

            // Executando a missão
            drone1.executarMission();

            // Verificando evento crítico
            boolean evento = drone1.detectarEventoCritico();
            if (evento) {
                System.out.println("⚠️ Atenção: evento crítico detectado!");
            }

            // Retornando à base
            drone1.retornarBase();

            // Status final
            System.out.println("Status final do drone: " + drone1.getStatus());
        } else {
            System.out.println("❌ Login ou senha incorretos. Acesso negado.");
        }

        scanner.close();
    }
}

