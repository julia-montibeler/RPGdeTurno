package model.inimigos;

import model.Personagem;

public class AranhaGigante extends Inimigo{
    public AranhaGigante(String nome) {
        super(nome, 15, 5, 0, 15, "Criatura");
        this.getVantagens().add("Ar");
        this.getDesvantagens().add("Fogo");
        this.setDestreza(3);
    }

    @Override
    public void atacar(Personagem p) {
        int n = random.nextInt(10);
        if (n <= 2) {
            System.out.println(p.getNome()+" foi envenenado");
            p.setEnvenenado(true);
        }
        super.atacar(p);
    }
}
