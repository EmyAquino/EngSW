import java.util.HashMap;
import java.util.Map;

public class JogoSemP {

    public static void main(String[] args) {

        RegistrodePersonagem registro = new RegistrodePersonagem();

        registro.registrar("guerreiro", new Guerreiro("Espada", 80));
        registro.registrar("arqueiro", new Arqueiro("Arco curto", 65));

        //Clonar Perrsonagens
        Personagem g1 = registro.obter("guerreiro");
        Personagem a1 = registro.obter("arqueiro");
        Personagem g2 = registro.obter("guerreiro");
        Personagem a2 = registro.obter("arqueiro");

        g1.exibir();
        g2.exibir();
        a1.exibir();
        a2.exibir();

    }

    public static class RegistrodePersonagem{
        private final Map<String, Personagem> personagens = new HashMap<>();

        public void registrar(String tipo, Personagem personagem){
            personagens.put(tipo, personagem);
        }

        //Precisa saber qual é o tipo do personagem
        public Personagem obter(String tipo){
            Personagem personagem = personagens.get(tipo);


            //Necessidade de recriar com o new
            // Se add mago, tem que add um novo else if
            if (personagem instanceof Guerreiro g) {
                return new Guerreiro(g.getArma(), g.getForca());
            } else if (personagem instanceof Arqueiro a) {
                return new Arqueiro(a.getArco(), a.getAgilidade());
            }
            return null;

        }
    }

    public interface Personagem {
        void exibir();
    }

    public static class Guerreiro implements Personagem {
        private final String arma;
        private final int forca;

        public Guerreiro(String arma, int forca){
            this.arma = arma;
            this.forca = forca;
        }

        public String getArma() {
            return arma;
        }

        public int getForca() {
            return forca;
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

        public String getArco() {
            return arco;
        }

        public int getAgilidade() {
            return agilidade;
        }

        @Override
        public void exibir() {
            System.out.println("Arqueiro com arco: "+ arco + "| Agilidade: "+ agilidade);

        }
    }
}