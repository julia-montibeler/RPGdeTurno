package model.classes;

import model.Personagem;
import model.habilidades.Cura;

public class Druida extends Personagem {
    public Druida(String nome) {
        super(nome, 25, 5, 0, 5);
        this.getHabilidades().add(new Cura());
        this.getDesvantagens().add("Monstro");
        this.getVantagens().add("Criatura");
        this.setDestreza(3);
    }

    public void curar() {
        int n = random.nextInt(10);
        if (n == 1) {
            System.out.println(this.getNome()+" se curou");
            this.getHabilidades().get(0).usar(this);
        }
    }
}
