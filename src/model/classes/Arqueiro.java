package model.classes;

import model.Personagem;
import model.habilidades.FlechaDeFogo;

public class Arqueiro extends Personagem {
    public Arqueiro(String nome) {
        super(nome, 30, 5, 0, 5);
        this.setDestreza(5);
        this.getHabilidades().add(new FlechaDeFogo());
        this.getDesvantagens().add("Incorporeo");
        this.getVantagens().add("Monstro");
    }

    @Override
    public void tomarDano(int dano) {
        int n = random.nextInt(10);
        if (n == 1) {
            System.out.println(this.getNome()+" esquivou");
            return;
        }
        super.tomarDano(dano);
    }
}
