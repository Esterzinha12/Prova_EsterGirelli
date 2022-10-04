package br.senai.sc.plano.view;

import Exceptions.ErroConexao;
import Exceptions.ErroExecucao;
import Exceptions.ErroTratamento;
import br.senai.sc.plano.controller.PlanoController;
import br.senai.sc.plano.model.entities.Plano;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    static private Scanner sc = new Scanner(System.in);

    /**
     * função executavel que chama a função menu;
     * @param args
     * @throws Exception
     * @throws ErroExecucao
     * @throws ErroTratamento
     * @throws ErroConexao
     */
    public static void main(String[] args) throws Exception, ErroExecucao, ErroTratamento, ErroConexao {
        menu();
    }

    /**
     * Função menu que recebe o que o usuario deseja fazer;
     * @throws Exception
     * @throws ErroExecucao
     * @throws ErroTratamento
     * @throws ErroConexao
     */
    private static void menu() throws Exception, ErroExecucao, ErroTratamento, ErroConexao {
        System.out.print("" + "----------MENU----------\n" + "1 - Cadastrar Plano\n" + "2 - Atualizar dados\n"
                + "3 - Listar Planos\n"
                + "4 - Remover Plano\n"
                + "5 - Encerrar\n" + "> ");
        Integer opcao= sc.nextInt();

        switch (opcao){
            case 1:
                cadastrar();
            case 2:
                atualizar();
            case 3:
                listar();
            case 4:
                excluir();
            case 5:
                System.exit(0);
        }
    }

    /**
     * função cadastrar onde é solicitado os dados de cadastro do plano ao usuario;
     * @throws Exception
     * @throws ErroExecucao
     * @throws ErroTratamento
     * @throws ErroConexao
     */
    private static void cadastrar() throws Exception, ErroExecucao, ErroTratamento, ErroConexao {
        System.out.println("----------CADASTRAR----------");

        System.out.println("Digite o nome da peradora que deseja:\n-tim\n-claro\n-vivo\n-oi");
        String operadora=sc.next();
        System.out.println("Nome plano: ");
        String nome=sc.next();
        System.out.println("Quantidade de dados: ");
        Double qtdDados =sc.nextDouble();
        System.out.println("Quantidade de dados bônus: ");
        Double qtdBonus =sc.nextDouble();
        System.out.println("Beneficios: ");
        String beneficios =sc.next();
        System.out.println("Valor: ");
        Double valor =sc.nextDouble();

        PlanoController.cadastrar(operadora, nome, qtdDados, qtdBonus, beneficios, valor);
        menu();
    }

    /**
     * função de atualizar que recebe o codigo e pede os novos dados para a edição do plano;
     * @throws Exception
     * @throws ErroExecucao
     * @throws ErroTratamento
     * @throws ErroConexao
     */
    private static void atualizar() throws Exception, ErroExecucao, ErroTratamento, ErroConexao {
        System.out.println("----------ATUALIZAR----------");

        System.out.println("Insira o codigo do plano a ser editado: ");
        Integer codigo = sc.nextInt();

        System.out.println("NOVOS DADOS:");
        System.out.println("Digite o nome da nova operadora:\n-tim\n-claro\n-vivo\n-oi");
        String operadora=sc.next();
        System.out.println("Nome plano: ");
        String nome=sc.next();
        System.out.println("Quantidade de dados: ");
        Double qtdDados =sc.nextDouble();
        System.out.println("Quantidade de dados bônus: ");
        Double qtdBonus =sc.nextDouble();
        System.out.println("Beneficios: ");
        String beneficios =sc.next();
        System.out.println("Valor: ");
        Double valor =sc.nextDouble();

        PlanoController.editar(codigo, operadora, nome, qtdDados, qtdBonus, beneficios, valor);
        menu();
    }

    /**
     * função que fará a listagem que o usuario deseja dos planos;
     * @throws Exception
     * @throws ErroExecucao
     * @throws ErroConexao
     * @throws ErroTratamento
     */
    private static void listar() throws Exception, ErroExecucao, ErroConexao, ErroTratamento {
        System.out.println("----------LISTAR----------");
        System.out.println("1- Por operadora\n2- Todos os planos\n3- Por codigo do plano");
        Integer opcao=sc.nextInt();

        switch(opcao){
            case 1:
                System.out.println("Digite o nome da operadora que deseja:\n-tim\n-claro\n-vivo\n-oi");
                String operadora=sc.next();
                ArrayList<Plano> operadoras = new ArrayList<>(PlanoController.listarOperadora(operadora));
                for (Plano p : operadoras) {
                    System.out.println(p.toString());
                }
                break;
            case 2:
                ArrayList<Plano> plano = new ArrayList<>(PlanoController.listarTudo());
                for (Plano p : plano) {
                    System.out.println(p.toString());
                }
                break;
            case 3:
                System.out.println("Insira o codigo do plano a ser listado: ");
                int codigo = sc.nextInt();
                Plano planos = new PlanoController().listarCodigo(codigo);
                System.out.println(planos);
                break;
        }
        menu();

    }

    /**
     * função que atraves do codigo inserido pelo usuario realiza a exclusão do plano;
     * @throws Exception
     * @throws ErroExecucao
     * @throws ErroTratamento
     * @throws ErroConexao
     */
    private static void excluir() throws Exception, ErroExecucao, ErroTratamento, ErroConexao {
        System.out.println("----------REMOVER----------");
            System.out.println("Insira o codigo do plano a ser removido: ");
            int codigo = sc.nextInt();
            PlanoController.excluir(codigo);
            menu();
    }
}
