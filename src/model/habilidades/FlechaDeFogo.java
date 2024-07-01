package model.habilidades;

import model.Personagem;

public class FlechaDeFogo extends Habilidade{

    public FlechaDeFogo() {
        super(10, "Fogo", "Flecha de fogo");
    }

    @Override
    public void usar(Personagem p) {
        int n = random.nextInt(2);
        if (n == 1) {
            p.setQueimado(true);
        }
        p.tomarDano(this.calcularDano(p));
    }
}
