package model.inimigos;

import model.Personagem;

public class Troll extends Inimigo {
    public Troll(String nome) {
        super(nome, 50, 5, 0, 50, "Monstro");
        this.getVantagens().add("Terra");
    }

    @Override
    public void atacar(Personagem p) {
        int n = random.nextInt(20);
        if (n == 1) {
            System.out.println(this.getNome()+" adormeceu");
            this.setAdormecido(true);
            return;
        }
        super.atacar(p);
    }
}
