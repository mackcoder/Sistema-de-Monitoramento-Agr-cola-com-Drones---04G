/* Integrantes
    - Andre Doerner Duarte - 10427938
    - Naoto Ushizaki - 10437445
*/

import java.util.Objects;
import java.util.regex.Pattern;
import java.math.BigDecimal;

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

class AuthenticateException extends RuntimeException{
    public AuthenticateException(String message){
        super(message);
    }
}

interface Authentication{
    boolean autenticar(String token);
}

interface AuthenticationUser{
    boolean autenticar(String login, String senha);
}
