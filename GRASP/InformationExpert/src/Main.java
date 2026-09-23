void main()
{
    ItemPedidoExpert mouse = new ItemPedidoExpert(50.0, 2);
    ItemPedidoExpert teclado = new ItemPedidoExpert(120.0, 1);
    PedidoExpert pedido1 = new PedidoExpert(List.of(mouse, teclado));

    ItemPedidoExpert monitor = new ItemPedidoExpert(800.0, 1);
    PedidoExpert pedido2 = new PedidoExpert(List.of(monitor));

    CaixaExpert caixa = new CaixaExpert(List.of(pedido1, pedido2));

    IO.println("Subtotal do mouse: R$ " + mouse.calcularSubtotal());
    IO.println("Total do pedido 1: R$ " + pedido1.calcularTotal());
    IO.println("Total do pedido 2: R$ " + pedido2.calcularTotal());
    IO.println("Total da caixa:   R$ " + caixa.calcularTotal());
}