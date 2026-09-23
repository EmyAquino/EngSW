// Decorator é um padrão estrutural do catálogo GoF (Gang of Four), ele permite que um objeto seja modificado,
// com novos comportamentos sem alterar o comportamento do objeto original

interface Cafe {
    double getCusto();
    String getDescricao();
}

class CafeSimples implements Cafe{
    public double getCusto() { return 5.0; }
    public String getDescricao() {return "Café";}
}

abstract class CafeDecorator implements Cafe{
    protected Cafe cafe;
    public CafeDecorator(Cafe cafe) {this.cafe = cafe;}
}

class ComLeite extends CafeDecorator{
    public ComLeite(Cafe cafe) {super(cafe);}
    public double getCusto() {return cafe.getCusto() + 1.5;}
    public String getDescricao() {return cafe.getDescricao() + " + leite";}
}

class ComChocolate extends CafeDecorator {
    public ComChocolate(Cafe cafe) {super(cafe);}
    public double getCusto() {return cafe.getCusto() + 2.0;}
    public String getDescricao() {return cafe.getDescricao() + " + com chocolate";}
}

public class TestaDecorator {
    public static void main(String[] args) {
        Cafe pedido = new CafeSimples();
        pedido = new ComLeite(pedido);
        pedido = new ComChocolate(pedido);
        System.out.println(pedido.getDescricao() + " -> R$" + pedido.getCusto());
    }
}