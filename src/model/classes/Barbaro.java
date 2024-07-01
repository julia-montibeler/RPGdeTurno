package model.classes;

import model.Personagem;

public class Barbaro extends Personagem {

    public Barbaro(String nome) {
        super(nome, 25, 10, 0, 5);
        this.setChanceCritico(3);
        this.getDesvantagens().add("Incorporeo");
    }

}
