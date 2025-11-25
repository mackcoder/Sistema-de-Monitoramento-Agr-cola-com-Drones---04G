/* Integrantes
    - Andre Doerner Duarte - 10427938
    - Naoto Ushizaki - 10437445
*/

package PROJETO_DRONE;
import java.util.List;
import java.util.Scanner;

public class MainDrone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        DataBankSimulado bd = new DataBankSimulado(); // Usando o nome da classe unificada
        
        UserDrone usuarioCriado = null; // Variável para armazenar o usuário recém-criado

        try {
            // --- 1. CADASTRO DE NOVO USUÁRIO ---
            System.out.println("=== 1. CADASTRO ===");
            System.out.print("Digite seu nome: ");
            String nome = scanner.nextLine();

            System.out.print("Digite seu login: ");
            String login = scanner.nextLine();

            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();

            usuarioCriado = new UserDrone(nome, login, senha, "user");
            
            bd.insertUser(usuarioCriado);

            // --- 2. AUTENTICAÇÃO (LOGIN) ---
            System.out.println("\n=== 2. AUTENTICAÇÃO ===");
            System.out.print("Login: ");
            String loginConfirmado = scanner.nextLine();

            System.out.print("Senha: ");
            String senhaConfirmada = scanner.nextLine();

            // BUSCA: Tenta buscar o usuário no banco
            UserDrone usuarioParaValidar = bd.buscarUsuarioPorLogin(loginConfirmado);
            
            if (usuarioParaValidar == null) {
                // Caso o login não exista no banco (simula falha de busca)
                throw new AuthenticateException("Falha: Usuário não encontrado no banco.");
            }

            ValidadorUser.validar(usuarioParaValidar, loginConfirmado, senhaConfirmada); 

            System.out.println("✅ Login autorizado. Bem-vindo, " + usuarioParaValidar.getNome());

            // --- 3. INSERÇÃO E FLUXO DE DRONE E MISSÃO ---
            
            // Criação das entidades
            Drone drone1 = new Drone("RDBLL5", "Red Bull", StatusDrone.PRONTO, 25.0f);
            Mission missao = new Mission("MS003", "Monitoramento da Área 5 - Soja",
                List.of("Captura de imagem", "Leitura de temperatura"));

            // INSERÇÃO DO DRONE NO BANCO
            bd.insertDrone(drone1);

            // INSERÇÃO DA MISSÃO NO BANCO
            bd.registerMission(missao); 
            
            bd.listDrones();

            // Fluxo de Missão
            drone1.receberMissao(missao); // Assumindo método existe
            drone1.iniciarMissao();      // Assumindo método existe

            if (drone1.detectarEventoCritico()) { // Assumindo método existe
                System.out.println("⚠️ Evento crítico detectado!");
            }

            drone1.encerrarMissao();
            drone1.retornarBase();

            System.out.println("Status final do drone: " + drone1.getStatus());

        } catch (AuthenticateException e) {
            // Captura falhas de credenciais, bloqueio, etc.
            System.out.println("❌ Erro de Autenticação: " + e.getMessage());
        } catch (Exception e) {
            // Captura erros de inicialização, NullPointers, etc.
            System.out.println("❌ Ocorreu um erro inesperado: " + e.getMessage());
            // Opcional: e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}