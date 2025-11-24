/* Integrantes
    - Andre Doerner Duarte - 10427938
    - Naoto Ushizaki - 10437445
*/
package PROJETO_DRONE;

/**
 * Valida login e senha de um usuário.
 *
 * @param usuario          objeto UserDrone contendo login e senha corretos
 * @param loginInformado   login digitado pelo usuário
 * @param senhaInformada   senha digitada pelo usuário
 * @return true se login e senha conferirem, false caso contrário
 */
public class ValidadorUser {
    public static boolean validar(UserDrone usuario, String loginInformado, String senhaInformada) {
        if (usuario == null) {
            return false;
        }
        return usuario.getLogin().equals(loginInformado) &&
               usuario.getSenha().equals(senhaInformada);
    }
}
