package br.senai.sc.plano.model.factory;

import Exceptions.ErroConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe que realiza a ligação com o banco de dados;
 */
public class ConexaoFactory {
    private String url = "jdbc:mysql://localhost:3306/planos";
    private String username = "root";
    private String password = "root";

    public Connection connectDB() throws SQLException, ErroConexao {
        try{
            return DriverManager.getConnection(url, username, password);
        }catch(Exception e){
            throw new ErroConexao();
        }
    }

}
