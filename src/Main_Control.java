public class Main_Control {
    public static void main(String[] args) {
        // Criando um drone
        Drone drone1 = new Drone("DRN001", "DJI Phantom", StatusDrone.PRONTO, 25.0f);

        // Criando uma missão
        Missao missao1 = new Missao("MS001", "Área 12 - Soja", "2025-10-01");

        // Enviando parâmetros da missão
        drone1.receberParametrosMissao(missao1);

        // Executando a missão
        drone1.executarMissao();

        // Verificando evento crítico
        boolean evento = drone1.detectarEventoCritico();
        if (evento) {
            System.out.println("⚠️ Atenção: evento crítico detectado!");
        }

        // Retornando à base
        drone1.retornarBase();

        // Status final
        System.out.println("Status final do drone: " + drone1.getStatus());
    }
}
