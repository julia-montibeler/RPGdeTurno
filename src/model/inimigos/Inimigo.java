package model.inimigos;

import model.Personagem;

public abstract class Inimigo extends Personagem {
    private int recompensaXP;
    private String tipo;

    public Inimigo(String nome, int pontosVida, int forca, int defesa, int recompensaXP, String tipo) {
        super(nome, pontosVida, forca, defesa);
        this.recompensaXP = recompensaXP;
        this.tipo = tipo;
    }

    public int getRecompensaXP() {
        return recompensaXP;
    }
}
