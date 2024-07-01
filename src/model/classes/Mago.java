package model.classes;

import model.Personagem;
import model.habilidades.Tempestade;
import model.habilidades.Tornado;

public class Mago extends Personagem {
    public Mago(String nome) {
        super(nome, 20, 3, 5, 10);
        this.getHabilidades().add(new Tornado());
        this.getHabilidades().add(new Tempestade());
        this.getDesvantagens().add("Criatura");
        this.getVantagens().add("Incorporeo");
        this.setDestreza(2);
    }

    //mago tem chance de 20% de carregar pontos de habilidade no seu turno
    public void carregarMago() {
        int n = random.nextInt(5);
        if (n == 1) {
            this.carregar();
        }
    }
}
