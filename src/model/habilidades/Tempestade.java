package model.habilidades;

import model.Personagem;

public class Tempestade extends Habilidade{
    public Tempestade() {
        super(15, "Água", "Tempestade");
    }

    @Override
    public void usar(Personagem p) {
        p.tomarDano(this.calcularDano(p));
    }
}
