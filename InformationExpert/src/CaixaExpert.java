import java.util.List;

public class CaixaExpert {
    private final List<PedidoExpert> pedidos;

    public CaixaExpert(List<PedidoExpert> pedidos) {
        this.pedidos = pedidos;
    }

    public double calcularTotal() {
        double total = 0;
        for (PedidoExpert pedido : pedidos) {
            total += pedido.calcularTotal();
        }
        return total;
    }
}

class PedidoExpert {
    private final List<ItemPedidoExpert> itens;

    public PedidoExpert(List<ItemPedidoExpert> itens) {
        this.itens = itens;
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedidoExpert item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }
}

class ItemPedidoExpert {
    private final double preco;
    private final int quantidade;

    public ItemPedidoExpert(double preco, int quantidade) {
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public double calcularSubtotal() {
        return preco * quantidade;
    }
}