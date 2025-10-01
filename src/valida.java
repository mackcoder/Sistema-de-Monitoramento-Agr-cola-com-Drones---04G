public class valida {
    public static boolean validar(Usuario usuario, String loginInformado, String senhaInformada) {
        return usuario.getLogin().equals(loginInformado) &&
               usuario.getSenha().equals(senhaInformada);
    }
}
