import java.util.HashMap;
import java.util.Map;

public class JogoComP {

    public static void main(String[] args) {

        RegistrodePersonagem registro = new RegistrodePersonagem();

        registro.registrar("guerreiro", new Guerreiro("Espada", 80));
        registro.registrar("arqueiro", new Arqueiro("Arco curto", 65));

        //Clonar

        Personagem g1 = registro.obter("guerreiro");
        Personagem a1 = registro.obter("arqueiro");
        Personagem g2 = registro.obter("guerreiro");
        Personagem a2 = registro.obter("arqueiro");

        g1.exibir();
        g2.exibir();
        a1.exibir();
        a2.exibir();

    }

    //Registro de Protótipos

    public static class RegistrodePersonagem{
        private final Map<String, Personagem> prototipos = new HashMap<>();

        public void registrar(String tipo, Personagem prototipo){
            prototipos.put(tipo, prototipo);
        }

        public Personagem obter(String tipo){
            Personagem prototipo = prototipos.get(tipo);
            return prototipo != null ? prototipo.clone() : null;

        }
    }

    public interface Personagem {
        Personagem clone();
        void exibir();
    }

    //Objeto do Guerreiro
    public static class Guerreiro implements Personagem {
        private final String arma;
        private final int forca;

        //Construtor do Guerreiro
        public Guerreiro(String arma, int forca){
            this.arma = arma;
            this.forca = forca;
        }

        //Construtor Clone
        public Guerreiro(Guerreiro prototipo){
            this.arma = prototipo.arma;
            this.forca = prototipo.forca;
        }
        @Override
        public Personagem clone() {
            return new Guerreiro(this);
        }

        @Override
        public void exibir() {
            System.out.println("Guerreiro com arma: "+ arma + " | Força: " + forca);

        }
    }

    public static class Arqueiro implements Personagem {
        private final String arco;
        private final int agilidade;

        public Arqueiro(String arco, int agilidade){
            this.arco = arco;
            this.agilidade = agilidade;
        }
        //Construtor Clone
        public Arqueiro(Arqueiro prototipo){
            this.arco = prototipo.arco;
            this.agilidade = prototipo.agilidade;
        }


        @Override
        public Personagem clone() {
            return new Arqueiro(this);
        }

        @Override
        public void exibir() {
            System.out.println("Arqueiro com arco: "+ arco + "| Agilidade: "+ agilidade);

        }
    }
}