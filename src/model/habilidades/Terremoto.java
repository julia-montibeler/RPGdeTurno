package model.habilidades;

import model.Personagem;

public class Terremoto extends Habilidade{
    public Terremoto() {
        super(10, "Terra", "Terremoto");
    }

    @Override
    public void usar(Personagem p) {
        int n = random.nextInt(2);
        if (n == 1) {
            p.setAtordoado(true);
        }
        p.tomarDano(this.calcularDano(p));
    }
}
