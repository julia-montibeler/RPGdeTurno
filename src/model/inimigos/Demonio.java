package model.inimigos;

import model.Personagem;
import model.classes.Mago;

public class Demonio extends Inimigo {
    public Demonio(String nome) {
        super(nome, 20, 10, 0, 25, "Monstro");
        this.getDesvantagens().add("Água");
        this.getVantagens().add("Fogo");
        this.setDestreza(3);
    }

    @Override
    public void atacar(Personagem p) {
        int n = random.nextInt(10);
        if (n <= 2) {
            System.out.println(p.getNome()+" foi queimado");
            p.setQueimado(true);
        }
        super.atacar(p);
    }
}
