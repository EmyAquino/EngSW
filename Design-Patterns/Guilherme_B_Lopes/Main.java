public class Main {
    public static void main(String[] args) {
        // Criamos os componentes do subsistema
        Amplificador amp = new Amplificador();
        Projetor proj = new Projetor();
        Luzes luz = new Luzes();

        // Passamos eles para a nossa Fachada
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, proj, luz);
        
        // O cliente não precisa ligar um por um
        homeTheater.assistirFilme();
    }
}
