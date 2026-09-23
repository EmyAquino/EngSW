import java.util.List;


public class Caixa {
    private List<Pedido> pedidos;

    public Caixa(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public double calcularTotal() {
        double total = 0;
        for (Pedido pedido : pedidos) {
            for (ItemPedido item : pedido.getItens()) {
                total += item.getPreco() * item.getQuantidade();
            }
        }
        return total;
    }
}

class Pedido {
    private final List<ItemPedido> itens;

    public Pedido(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }
}

class ItemPedido {
    private final double preco;
    private final int quantidade;

    public ItemPedido(double preco, int quantidade) {
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
}