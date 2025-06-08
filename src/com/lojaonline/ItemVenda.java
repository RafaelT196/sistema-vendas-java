package com.lojaonline;

public class ItemVenda {
    private Produto produto;
    private int quantidade;
    private double precoUnitario; // Preço no momento da venda

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = produto.getPreco(); // Captura o preço atual do produto
    }

    public double getSubtotal() {
        return this.quantidade * this.precoUnitario;
    }

    public Produto getProduto() {
        return produto;
    }


    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "\n\t- " + produto.getNome() +
                ", Qtd: " + quantidade +
                ", Preço Unit: R$" + String.format("%.2f", precoUnitario) +
                ", Subtotal: R$" + String.format("%.2f", getSubtotal());
    }
}
