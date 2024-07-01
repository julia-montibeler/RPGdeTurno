package model.inimigos;

import model.Personagem;

public class Banshee extends Inimigo {
    public Banshee(String nome) {
        super(nome, 25 , 5, 0, 10, "Incorpóreo");
        this.getVantagens().add("Terra");
        this.getDesvantagens().add("Ar");
        this.setDestreza(5);
    }

    @Override
    public void atacar(Personagem p) {
        int n = random.nextInt(10);
        if (n <= 1) {
            System.out.println(p.getNome()+" foi atordoado");
            p.setAtordoado(true);
        }
        super.atacar(p);
    }
}
