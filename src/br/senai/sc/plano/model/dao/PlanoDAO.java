package br.senai.sc.plano.model.dao;

import Exceptions.ErroConexao;
import Exceptions.ErroExecucao;
import Exceptions.ErroTratamento;
import br.senai.sc.plano.model.entities.Plano;
import br.senai.sc.plano.model.factory.ConexaoFactory;
import br.senai.sc.plano.model.factory.PlanoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *Classe onde são executados os comando SQL para ligação com o banco de dados;
 */
public class PlanoDAO {

    private static Set<Plano> listaPlano = new HashSet<>();

    private Connection conn;

    public PlanoDAO() throws SQLException, ErroConexao {
        this.conn = new ConexaoFactory().connectDB();
    }

    public void cadastrar(Plano plano) throws Exception, ErroTratamento {
        String sqlCommand = "INSERT INTO PLANO ( operadora, nome, quantidade_dados, quantidade_bonus, beneficios, valor) " +
                "values (?,?,?,?,?,?)";
        try (PreparedStatement pstm = conn.prepareStatement(sqlCommand)) {
            pstm.setString(1, plano.getOperadora());
            pstm.setString(2, plano.getNome());
            pstm.setDouble(3, plano.getQtdDados());
            pstm.setDouble(4, plano.getQtdBonus());
            pstm.setString(5, plano.getBeneficios());
            pstm.setDouble(6, plano.getValor());
            try {
                pstm.execute();
            } catch (Exception e) {
                throw new ErroExecucao();
            }
        } catch (Exception | ErroExecucao e) {
            throw  new ErroTratamento();
        }
        System.out.println("Cadastro do plano realizado com sucesso!");
    }

    public void excluir(Integer codigo) throws Exception, ErroTratamento {
        String sqlCommand = "DELETE FROM PLANO WHERE codigo = ?";
        try (PreparedStatement pstm = conn.prepareStatement(sqlCommand)) {
            pstm.setInt(1, codigo);
            try {
                pstm.execute();
            } catch (Exception e) {
                throw new ErroExecucao();
            }
        } catch (Exception | ErroExecucao e) {
            throw new ErroTratamento();
        }
        System.out.println("Plano removido!");
    }

    public Collection<Plano> listarOperadora(String operadora) throws Exception, ErroExecucao {
        String sqlCommand = "SELECT * FROM PLANO WHERE operadora =?";
        try (PreparedStatement pstm = conn.prepareStatement(sqlCommand)) {
            pstm.setString(1,operadora);
            try (ResultSet resultSet = pstm.executeQuery()) {
                while (resultSet.next()) {
                    listaPlano.add(extrairObjeto(resultSet));
                }
                return listaPlano;
            } catch (Exception e) {
                throw new Exception(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);

        }
    }

    public Plano listarCodigo(Integer codigo) throws Exception, ErroTratamento {
        String sqlCommand = "SELECT * FROM PLANO WHERE CODIGO =?";
        try (PreparedStatement pstm = conn.prepareStatement(sqlCommand)) {
            pstm.setInt(1, codigo);
            try (ResultSet resultSet = pstm.executeQuery()) {
                if(resultSet.next()){
                    return extrairObjeto(resultSet);
                }else{
                    throw new ErroExecucao();
                }
            } catch (Exception e) {
                throw new ErroExecucao();
            }
        } catch (Exception | ErroExecucao e) {
            throw new ErroTratamento();
        }
    }

    public Set<Plano> listarTudo() throws Exception, ErroTratamento {
        String sqlCommand = "SELECT * FROM PLANO";
        try (PreparedStatement pstm = conn.prepareStatement(sqlCommand)) {
            try (ResultSet resultSet = pstm.executeQuery()) {
                while (resultSet.next()) {
                    listaPlano.add(extrairObjeto(resultSet));
                }
                return  listaPlano;
            } catch (Exception e) {
                throw new ErroExecucao();
            }
        } catch (Exception | ErroExecucao e) {
            throw new ErroTratamento();
        }
    }

    private Plano extrairObjeto(ResultSet resultSet) throws Exception, ErroExecucao {
        try {
            return new PlanoFactory().getPlano(
                    resultSet.getString("operadora"),
                    resultSet.getString("nome"),
                    resultSet.getDouble("quantidade_dados"),
                    resultSet.getDouble("valor")
            );
        } catch (Exception e) {
            throw new ErroExecucao();
        }
    }

    public void editar(Integer codigo, Plano plano) throws Exception, ErroTratamento {
        String sqlCommand = "UPDATE PLANO SET OPERADORA = ?, NOME = ?, QUANTIDADE_DADOS = ?, QUANTIDADE_BONUS = ?," +
                "BENEFICIOS = ?, VALOR = ? WHERE CODIGO = ?";
        try (PreparedStatement pstm = conn.prepareStatement(sqlCommand)) {
            pstm.setString(1, plano.getOperadora());
            pstm.setString(2, plano.getNome());
            pstm.setDouble(3, plano.getQtdDados());
            pstm.setDouble(4, plano.getQtdBonus());
            pstm.setString(5, plano.getBeneficios());
            pstm.setDouble(6, plano.getValor());
            pstm.setInt(7, codigo);
            try {
                pstm.execute();
            } catch (Exception e) {
                throw new ErroExecucao();
            }
        } catch (Exception | ErroExecucao e) {
            throw  new ErroTratamento();
        }
        System.out.println("Edição do plano realizado com sucesso!");
    }
}
