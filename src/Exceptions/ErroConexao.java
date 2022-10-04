package Exceptions;

/**
 * Classe Exception que representa um erro de conexão;
 */
public class ErroConexao extends Throwable {
    public ErroConexao(){
        System.out.println("Erro na conexão com o banco!!");
    }
}
