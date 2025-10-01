public class Main_Control {
    public static void main(String[] args) {
        var scanner = new java.util.Scanner(System.in);

        // Entrada dinâmica de login e senha
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu login: ");
        String login = scanner.nextLine();

        String senha;
        var console = System.console();
        if (console != null) {
            char[] senhaChars = console.readPassword("Digite sua senha: ");
            senha = new String(senhaChars);
        } else {
            System.out.println("⚠️ Console não disponível. Usando entrada visível.");
            System.out.print("Digite sua senha: ");
            senha = scanner.nextLine();
        }

        // Criação do usuário com dados informados
        var usuario = new Usuario(nome, login, senha);

        // Validação simples (simula login com os mesmos dados)
        System.out.print("Confirme seu login: ");
        String loginConfirmado = scanner.nextLine();

        System.out.print("Confirme sua senha: ");
        String senhaConfirmada = scanner.nextLine();

        if (valida.validar(usuario, loginConfirmado, senhaConfirmada)) {
            System.out.println("✅ Login autorizado. Bem-vindo, " + usuario.getNome());

            var drone1 = new Drone("RDBLL5", "Red Bull", StatusDrone.PRONTO, 25.0f);
            var bd = new bd_drone(); 
            bd.inserirDrone(drone1);
            bd.listarDrones();

            var missao = new Missao("MS003", "Monitoramento da Área 5 - Soja",
                    java.util.List.of("Captura de imagem", "Leitura de temperatura"));

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
