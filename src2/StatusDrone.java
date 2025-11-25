/* Integrantes
    - Andre Doerner Duarte - 10427938
    - Naoto Ushizaki - 10437445
*/
package PROJETO_DRONE;

// ENUMS
enum StatusDrone {
    PRONTO,
    EM_MISSAO,
    CONCLUIDA
}

enum StatusMissao {
    PENDENTE,
    EM_ANDAMENTO,
    CONCLUIDA
}

enum StateTransition{
    DESCONECTED,
    AUTHENTICATING,
    USER_AUTHENTICATED,
    BLOQUED
}