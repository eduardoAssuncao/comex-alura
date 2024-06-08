package br.com.alura.tests;

import br.com.alura.entities.DTOs.ProdutoDTO;
import br.com.alura.services.ProdutoService;
import br.com.alura.utils.ExceptionMessage;

import java.util.Scanner;

public class ProdutoTest {

    private final static ProdutoService produtoService = new ProdutoService();
    private static Scanner sc = new Scanner(System.in).useDelimiter("\n");
    public static void main(String[] args) {
        System.out.println("Bom dia! Tudo bem? Espero que sim");
        var opcao = exibirMenu();
        while (opcao != 9) {
            try {
                switch (opcao) {
                    case 1:
                        listar();
                        break;
                    case 2:
                        listarNomes();
                        break;
                    case 3:
                        salvar();
                        break;
                    case 4:
                        deletar();
                        break;
                    case 5:
                        deletarLogico();
                        break;
                    case 6:
                        atualizar();
                        break;
                }
            } catch (ExceptionMessage e) {
                System.out.println("Erro: " + e.getMessage());

                System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu");
                sc.next();
            }
            opcao = exibirMenu();
        }

        System.out.println("Finalizando a aplicação.");
    }

    private static int exibirMenu() {
        System.out.println("""
                COMEX - ESCOLHA UMA OPÇÃO:
                1 - Listar produtos
                2 - Listar produtos por nome
                3 - Criar um produto
                4 - Deletar um produto
                5 - Deletar logicamente uma produto
                6 - Atualizar um produto
                9 - Sair
                """);
        return sc.nextInt();
    }

    private static void salvar(){
        System.out.println("Informe o nome do produto: ");
        String nome = sc.next();
        System.out.println("Informe a descrição do produto: ");
        String descricao = sc.next();
        System.out.println("Informe o valor do produto: ");
        Double valor = sc.nextDouble();
        ProdutoDTO produto = new ProdutoDTO(nome, descricao, valor);
        produtoService.criar(produto);

        System.out.println("Cadastro realizado com sucesso!");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        sc.next();
    }

    private static void listar(){
        var produto = produtoService.listar();
        produto.stream().forEach(System.out::println);

        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        sc.next();
    }

    private static void listarNomes(){
        var produto = produtoService.listarNomes();
        produto.stream().forEach(System.out::println);

        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        sc.next();
    }

    private static void atualizar(){
        System.out.println("Informe o id do produto: ");
        int id = sc.nextInt();
        System.out.println("Informe o nome do produto: ");
        String nome = sc.next();
        System.out.println("Informe a descrição do produto: ");
        String descricao = sc.next();
        System.out.println("Informe o valor do produto: ");
        Double valor = sc.nextDouble();
        ProdutoDTO dto = new ProdutoDTO(nome, descricao, valor);
        produtoService.atualizar(id, dto);

        System.out.println("Atualização realizada com sucesso!");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        sc.next();
    }

    private static void deletar() {
        System.out.println("Informe o id do produto: ");
        int id = sc.nextInt();
        produtoService.deletar(id);

        System.out.println("Produto deletado com sucesso!");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        sc.next();
    }

    private static void deletarLogico(){
        System.out.println("Informe o id do produto: ");
        int id = sc.nextInt();
        produtoService.deletar(id);

        System.out.println("Produto deletado com sucesso!");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        sc.next();
    }
}
