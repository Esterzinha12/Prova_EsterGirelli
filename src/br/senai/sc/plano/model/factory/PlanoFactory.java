package br.senai.sc.plano.model.factory;

import br.senai.sc.plano.model.entities.Plano;

public class PlanoFactory {
    /**
     * Transforma os dados em um objeto;
     *
     * @param operadora
     * @param nome
     * @param quantidade_dados
     * @param valor
     * @return
     */
    public Plano getPlano(String operadora, String nome, double quantidade_dados, double valor) {
        return new Plano(operadora, nome, quantidade_dados, valor);
    }
}
