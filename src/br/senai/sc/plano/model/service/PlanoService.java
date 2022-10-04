package br.senai.sc.plano.model.service;

import Exceptions.ErroConexao;
import Exceptions.ErroExecucao;
import Exceptions.ErroTratamento;
import br.senai.sc.plano.model.dao.PlanoDAO;
import br.senai.sc.plano.model.entities.Plano;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Set;

/**
 * Classe que recebe os dados do controller e encaminha para o DAO;
 */
public class PlanoService {

    public void cadastrar(Plano plano) throws Exception, ErroTratamento, ErroConexao {
        new PlanoDAO().cadastrar(plano);
    }

    public void excluir(Integer codigo) throws Exception, ErroTratamento, ErroConexao {
        new PlanoDAO().excluir(codigo);
    }

    public Collection<Plano> listarOperadora(String operadora) throws Exception, ErroExecucao, ErroConexao {
        return new PlanoDAO().listarOperadora(operadora);
    }

    public Plano listarCodigo(Integer codigo) throws Exception, ErroConexao, ErroTratamento {
        return new PlanoDAO().listarCodigo(codigo);
    }

    public Set<Plano> listarTudo() throws Exception, ErroConexao, ErroTratamento {
        return new PlanoDAO().listarTudo();
    }

    public void editar(Integer codigo, Plano plano) throws Exception, ErroTratamento, ErroConexao {
        new PlanoDAO().editar(codigo, plano);
    }
}
