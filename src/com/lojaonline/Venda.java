package com.lojaonline;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venda {
    private static int proximoId = 1; // Atributo estático para gerar IDs sequenciais
    private int id;
    private Usuario cliente;
    private List<ItemVenda> itens;
    private double valorTotal;
    private LocalDate data;

    public Venda(Usuario cliente) {
        this.id = proximoId++;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.data = LocalDate.now();
        this.valorTotal = 0.0;
    }

    // Método para adicionar itens e atualizar o valor total
    public void adicionarItem(ItemVenda item) {
        this.itens.add(item);
        // Atualiza o estoque do produto
        item.getProduto().baixarEstoque(item.getQuantidade());
        // Recalcula o valor total da venda
        this.calcularValorTotal();
    }

    // MÉTODO QUE FALTAVA
    public List<ItemVenda> getItens() {
        return this.itens;
    }

    private void calcularValorTotal() {
        this.valorTotal = 0; // Zera para recalcular
        for (ItemVenda item : this.itens) {
            this.valorTotal += item.getSubtotal();
        }
    }

    @Override
    public String toString() {
        // Usando um StringBuilder para uma construção mais eficiente da String
        StringBuilder sb = new StringBuilder();
        sb.append("Venda #").append(id)
                .append("\nData: ").append(data)
                .append("\nCliente: ").append(cliente.getNome())
                .append("\nItens:");

        for(ItemVenda item : itens) {
            // Adiciona cada item formatado em uma nova linha
            sb.append(item.toString());
        }

        sb.append("\nValor Total: R$").append(String.format("%.2f", valorTotal)).append("\n");

        return sb.toString();
    }
}