package br.senai.sc.plano.model.entities;

/**
 * Classe onde são feitos os constructor, tostring, gets and setters e apresentação das variavies;
 */
public class Plano {
    String operadora;
    String nome, beneficios;
    Double qtdDados, qtdBonus, valor;


    public Plano( String operadora, String nome, String beneficios, Double qtdDados, Double qtdBonus, Double valor) {
        this(operadora, nome, qtdDados, valor);
        this.beneficios = beneficios;
        this.qtdBonus = qtdBonus;
    }
    public Plano( String operadora, String nome,  Double qtdDados, Double valor) {
        this.operadora = operadora;
        this.nome = nome;
        this.qtdDados = qtdDados;
        this.valor = valor;
    }

    public static Plano cadastrar( String operadora, String nome, Double qtdDados, Double qtdBonus, String beneficios, Double valor) {
        return new Plano( operadora, nome, beneficios, qtdDados, qtdBonus, valor);
    }

    @Override
    public String toString() {
        return "Plano{" +
                "operadora=" + operadora +
                ", nome='" + nome + '\'' +
                ", beneficios='" + beneficios + '\'' +
                ", qtdDados=" + qtdDados +
                ", qtdBonus=" + qtdBonus +
                ", valor=" + valor +
                '}';
    }


    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public Double getQtdDados() {
        return qtdDados;
    }

    public void setQtdDados(Double qtdDados) {
        this.qtdDados = qtdDados;
    }

    public Double getQtdBonus() {
        return qtdBonus;
    }

    public void setQtdBonus(Double qtdBonus) {
        this.qtdBonus = qtdBonus;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
