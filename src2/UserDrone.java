/* Integrantes
    - Andre Doerner Duarte - 10427938
    - Naoto Ushizaki - 10437445
*/
package PROJETO_DRONE;

import javax.naming.AuthenticationException;

/**
 * Valida login e senha de um usuário.
 *
 * @param usuario          objeto UserDrone contendo login e senha corretos
 * @param GivenLogin   login digitado pelo usuário
 * @param GivenPassword   senha digitada pelo usuário
 * @return true se login e senha conferirem, false caso contrário
 */
public class ValidadorUser {
    public static void validar(UserDrone usuario, String GivenLogin, String GivenPassword) {
        // Check if exists:
        if (usuario == null) {
            throw new AuthenticateException("\nFailed to find User...");
        }
        // Caso 2: Tenta autenticar
        if(!usuario.autenticar(GivenLogin, GivenPassword))
            throw new AuthenticateException("Invalid Credentials");

        System.out.println("\nSucessfull Authentication");
    }
}
