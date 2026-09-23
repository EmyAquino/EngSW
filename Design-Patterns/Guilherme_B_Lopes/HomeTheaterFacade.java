public class HomeTheaterFacade {
    private Amplificador amplificador;
    private Projetor projetor;
    private Luzes luzes;

    public HomeTheaterFacade(Amplificador amp, Projetor proj, Luzes luz) {
        this.amplificador = amp;
        this.projetor = proj;
        this.luzes = luz;
    }

    // O cliente chama apenas este método simples
    public void assistirFilme() {
        System.out.println("Preparando o ambiente para o filme...");
        luzes.esmaecer();
        projetor.ligar();
        projetor.modoCinema();
        amplificador.ligar();
        amplificador.definirVolume(10);
        System.out.println("Filme iniciado com sucesso!");
    }
}
