package br.senai.sc.plano.controller;

import Exceptions.ErroConexao;
import Exceptions.ErroExecucao;
import Exceptions.ErroTratamento;
import br.senai.sc.plano.model.entities.Plano;
import br.senai.sc.plano.model.service.PlanoService;

import java.util.Collection;
import java.util.Set;

/**
 * Classe que recebe os dados quando necessario por paramentro e encaminha para o service;
 */
public class PlanoController {

    public static void cadastrar( String operadora, String nome, Double qtdDados, Double qtdBonus, String beneficios,
                                 Double valor) throws Exception, ErroTratamento, ErroConexao {
        PlanoService service = new PlanoService();
        Plano plano = Plano.cadastrar(operadora, nome, qtdDados, qtdBonus, beneficios, valor);
        service.cadastrar(plano);
    }

    public static void excluir(Integer codigo) throws Exception, ErroTratamento, ErroConexao {
        PlanoService service = new PlanoService();
        service.excluir(codigo);
    }

    public static Collection<Plano> listarOperadora(String operadora) throws Exception, ErroExecucao, ErroConexao {
        PlanoService service = new PlanoService();
        return service.listarOperadora(operadora);
    }

    public static Plano listarCodigo(Integer codigo) throws Exception, ErroConexao, ErroTratamento {
        PlanoService service= new PlanoService();
        return service.listarCodigo(codigo);
    }

    public static Set<Plano> listarTudo() throws Exception, ErroConexao, ErroTratamento {
        PlanoService service = new PlanoService();
        return service.listarTudo();
    }

    public static void editar(Integer codigo, String operadora, String nome, Double qtdDados, Double qtdBonus, String beneficios, Double valor) throws Exception, ErroTratamento, ErroConexao {
        PlanoService service = new PlanoService();
        Plano plano = Plano.cadastrar(operadora, nome, qtdDados, qtdBonus, beneficios, valor);
        service.editar(codigo,plano);
    }
}
