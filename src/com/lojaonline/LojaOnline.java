package com.lojaonline;

import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LojaOnline {

    // Estas listas agora funcionarão como nosso "banco de dados" em memória.
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Produto> produtos = new ArrayList<>();
    private static List<Venda> vendasRealizadas = new ArrayList<>();

    public static void main(String[] args) {
        // Inicializamos com alguns dados para o sistema não começar vazio
        inicializarDados();

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            exibirMenu();
            try {
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consome a quebra de linha pendente

                switch (opcao) {
                    case 1:
                        listarProdutos();
                        break;
                    case 2:
                        realizarNovaVenda(scanner);
                        break;
                    case 3:
                        listarVendas();
                        break;
                    case 0:
                        System.out.println("Obrigado por utilizar nosso sistema. Até logo!");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: por favor, digite um número válido.");
                scanner.nextLine(); // Limpa o buffer do scanner para evitar loop infinito
                opcao = -1; // Reseta a opção para continuar no loop
            }
        }

        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("\n===============================");
        System.out.println("      MENU DA LOJA ONLINE      ");
        System.out.println("===============================");
        System.out.println("1. Listar Produtos Disponíveis");
        System.out.println("2. Realizar Nova Venda");
        System.out.println("3. Listar Vendas Realizadas");
        System.out.println("0. Sair do Sistema");
        System.out.println("-------------------------------");
    }

    public static void inicializarDados() {
        usuarios.add(new Usuario("Ricardo Santos", "111.222.333-44", "rsantos@email.com", "Rua das Flores, 123"));
        usuarios.add(new Usuario("Rita Nascimento", "555.666.777-88", "rnascm@email.com", "Avenida Principal, 456"));

        produtos.add(new Produto(1, "Notebook Gamer", 5500.00, 10));
        produtos.add(new Produto(2, "Mouse Sem Fio", 150.00, 30));
        produtos.add(new Produto(3, "Teclado Mecânico", 350.00, 20));
        produtos.add(new Produto(4, "Monitor 4K", 1800.00, 15));
    }

    public static void listarProdutos() {
        System.out.println("\n--- LISTA DE PRODUTOS ---");
        for (Produto produto : produtos) {
            System.out.println("ID " + produto.getId() + " | " + produto.getNome() + " | Preço: R$" + String.format("%.2f", produto.getPreco()) + " | Estoque: " + produto.getQuantidadeEstoque());
        }
    }

    public static void listarVendas() {
        System.out.println("\n--- HISTÓRICO DE VENDAS ---");
        if (vendasRealizadas.isEmpty()) {
            System.out.println("Nenhuma venda foi realizada ainda.");
            return;
        }
        for (Venda venda : vendasRealizadas) {
            System.out.println(venda);
        }
    }

    public static void realizarNovaVenda(Scanner scanner) {
        System.out.println("\n--- REALIZAR NOVA VENDA ---");

        // 1. Selecionar o cliente
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado para realizar uma venda.");
            return;
        }
        System.out.println("Selecione o cliente (pelo número):");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println((i + 1) + ". " + usuarios.get(i).getNome());
        }
        int escolhaCliente = scanner.nextInt() - 1;
        scanner.nextLine(); // Consome a quebra de linha

        if (escolhaCliente < 0 || escolhaCliente >= usuarios.size()) {
            System.out.println("Seleção de cliente inválida.");
            return;
        }
        Usuario cliente = usuarios.get(escolhaCliente);
        Venda novaVenda = new Venda(cliente);

        // 2. Adicionar produtos ao carrinho
        int idProduto = -1;
        while (idProduto != 0) {
            listarProdutos();
            System.out.print("\nDigite o ID do produto para adicionar ao carrinho (ou 0 para finalizar a compra): ");
            idProduto = scanner.nextInt();
            scanner.nextLine(); // Consome a quebra de linha

            if (idProduto != 0) {
                Produto produtoEscolhido = null;
                for (Produto p : produtos) {
                    if (p.getId() == idProduto) {
                        produtoEscolhido = p;
                        break;
                    }
                }

                if (produtoEscolhido != null) {
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine(); // Consome a quebra de linha

                    if (quantidade > 0 && quantidade <= produtoEscolhido.getQuantidadeEstoque()) {
                        novaVenda.adicionarItem(new ItemVenda(produtoEscolhido, quantidade));
                        System.out.println(">>> Produto '" + produtoEscolhido.getNome() + "' adicionado com sucesso!");
                    } else {
                        System.out.println(">>> Erro: Quantidade inválida ou estoque insuficiente.");
                    }
                } else {
                    System.out.println(">>> Erro: ID de produto não encontrado.");
                }
            }
        }

        // 3. Finalizar a venda
        if (!novaVenda.getItens().isEmpty()) {
            vendasRealizadas.add(novaVenda);
            System.out.println("\n--- VENDA REALIZADA COM SUCESSO ---");
            System.out.println(novaVenda);
        } else {
            System.out.println("\nNenhum item adicionado. A venda foi cancelada.");
        }
    }
}