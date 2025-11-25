/* Integrantes
    - Andre Doerner Duarte - 10427938
    - Naoto Ushizaki - 10437445
*/

package PROJETO_DRONE;

class ValorInvalidoException extends RuntimeException{
    public ValorInvalidoException(String message){
        super(message);
    }
}

class InvalidTokenException extends RuntimeException{
    public InvalidTokenException(String message){
        super(message);
    }
}

interface Authentication{
    boolean autenticar(String token);
}

interface AuthenticationUser{
    boolean autenticar(String login, String senha);
}
