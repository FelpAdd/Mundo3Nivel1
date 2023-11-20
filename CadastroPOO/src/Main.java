import Model.PessoaFisica;
import Model.PessoaFisicaRepo;
import Model.PessoaJuridica;
import Model.PessoaJuridicaRepo;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();

        do {
            System.out.println("Menu de Opções:");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Exibir pelo ID");
            System.out.println("5 - Exibir todos");
            System.out.println("6 - Salvar dados");
            System.out.println("7 - Recuperar dados");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Escolha o tipo (1 - Física, 2 - Jurídica): ");
                    int tipo = scanner.nextInt();
                    if (tipo == 1) {

                        PessoaFisica pessoaFisica = new PessoaFisica();
                        System.out.print("Informe o ID da Pessoa Física: ");
                        int id = scanner.nextInt();
                        System.out.print("Informe o nome da Pessoa Física: ");
                        String nome = scanner.next();
                        System.out.print("Informe o CPF: ");
                        String cpf = scanner.next();
                        System.out.print("Informe a idade: ");
                        int idade = scanner.nextInt();
                        pessoaFisica.setId(id);
                        pessoaFisica.setNome(nome);
                        pessoaFisica.setCpf(cpf);
                        pessoaFisica.setIdade(idade);

                        repoFisica.inserir(pessoaFisica);
                    } else if (tipo == 2) {

                        PessoaJuridica pessoaJuridica = new PessoaJuridica();
                        System.out.print("Informe o ID da Pessoa Juridica: ");
                        int id = scanner.nextInt();
                        System.out.print("Informe o nome da Pessoa Juridica: ");
                        String nome = scanner.next();
                        System.out.print("Informe o CNPJ: ");
                        String cnpj = scanner.next();
                        pessoaJuridica.setId(id);
                        pessoaJuridica.setNome(nome);
                        pessoaJuridica.setCnpj(cnpj);



                        repoJuridica.inserir(pessoaJuridica);
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 2:
                    System.out.println("Escolha o tipo (1 - Física, 2 - Jurídica): ");
                    int tipoAlterar = scanner.nextInt();
                    if (tipoAlterar == 1) {

                        System.out.print("Informe o ID da Pessoa Física a ser alterada: ");
                        int id = scanner.nextInt();
                        PessoaFisica pessoaFisica = repoFisica.obter(id);
                        if (pessoaFisica != null) {
                            System.out.println("Dados atuais da Pessoa Física:");
                            pessoaFisica.exibir();
                            System.out.print("Informe o novo nome da Pessoa Física: ");
                            String novoNome = scanner.next();

                            pessoaFisica.setNome(novoNome);
                            repoFisica.alterar(pessoaFisica);
                            System.out.println("Pessoa Física alterada com sucesso.");
                        } else {
                            System.out.println("Pessoa Física não encontrada.");
                        }
                    } else if (tipoAlterar == 2) {

                        System.out.print("Informe o ID da Pessoa Jurídica a ser alterada: ");
                        int id = scanner.nextInt();
                        PessoaJuridica pessoaJuridica = repoJuridica.obter(id);
                        if (pessoaJuridica != null) {
                            System.out.println("Dados atuais da Pessoa Jurídica:");
                            pessoaJuridica.exibir();
                            System.out.print("Informe o novo nome da Pessoa Jurídica: ");
                            String novoNome = scanner.next();

                            pessoaJuridica.setNome(novoNome);
                            repoJuridica.alterar(pessoaJuridica);
                            System.out.println("Pessoa Jurídica alterada com sucesso.");
                        } else {
                            System.out.println("Pessoa Jurídica não encontrada.");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 3:
                    System.out.println("Escolha o tipo (1 - Física, 2 - Jurídica): ");
                    int tipoExcluir = scanner.nextInt();
                    System.out.print("Informe o ID da entidade a ser excluída: ");
                    int id = scanner.nextInt();
                    if (tipoExcluir == 1) {

                        repoFisica.excluir(id);
                    } else if (tipoExcluir == 2) {

                        repoJuridica.excluir(id);
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 4:
                    System.out.println("Escolha o tipo (1 - Física, 2 - Jurídica): ");
                    int tipoExibir = scanner.nextInt();
                    System.out.print("Informe o ID da entidade a ser exibida: ");
                    int idExibir = scanner.nextInt();
                    if (tipoExibir == 1) {

                        PessoaFisica pessoaFisica = repoFisica.obter(idExibir);
                        if (pessoaFisica != null) {
                            pessoaFisica.exibir();
                        } else {
                            System.out.println("Pessoa Física não encontrada.");
                        }
                    } else if (tipoExibir == 2) {

                        PessoaJuridica pessoaJuridica = repoJuridica.obter(idExibir);
                        if (pessoaJuridica != null) {
                            pessoaJuridica.exibir();
                        } else {
                            System.out.println("Pessoa Jurídica não encontrada.");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 5:
                    System.out.println("Escolha o tipo (1 - Física, 2 - Jurídica): ");
                    int tipoExibirTodos = scanner.nextInt();
                    if (tipoExibirTodos == 1) {

                        for (PessoaFisica pessoaFisica : repoFisica.obterTodos()) {
                            pessoaFisica.exibir();
                        }
                    } else if (tipoExibirTodos == 2) {

                        for (PessoaJuridica pessoaJuridica : repoJuridica.obterTodos()) {
                            pessoaJuridica.exibir();
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 6:
                    System.out.print("Informe o prefixo dos arquivos para salvar: ");
                    String prefixoSalvar = scanner.next();
                    try {

                        repoFisica.persistir(prefixoSalvar + ".fisica.bin");
                        repoJuridica.persistir(prefixoSalvar + ".juridica.bin");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar os dados: " + e.getMessage());
                    }
                    break;
                case 7:
                    System.out.print("Informe o prefixo dos arquivos para recuperar: ");
                    String prefixoRecuperar = scanner.next();
                    try {

                        repoFisica.recuperar(prefixoRecuperar + ".fisica.bin");
                        repoJuridica.recuperar(prefixoRecuperar + ".juridica.bin");
                        System.out.println("Dados recuperados com sucesso.");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Erro ao recuperar os dados: " + e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }
}
