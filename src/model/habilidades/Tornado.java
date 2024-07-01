package model.habilidades;

import model.Personagem;

public class Tornado extends Habilidade{

    public Tornado() {
        super(15, "Ar", "Tornado");
    }

    @Override
    public void usar(Personagem p) {
        int n = random.nextInt(10);
        if (n <= 2) {
            System.out.println(p.getNome()+" foi atordoado");
            p.setAtordoado(true);
        }
        p.tomarDano(this.calcularDano(p));
    }
}
