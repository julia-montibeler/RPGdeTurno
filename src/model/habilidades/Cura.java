package model.habilidades;

import model.Personagem;
import model.habilidades.Habilidade;

public class Cura extends Habilidade {
    public Cura() {
        super(5, "Cura", "Cura");
    }

    @Override
    public void usar(Personagem p) {
        p.setAtordoado(false);
        p.setQueimado(false);
        p.setEnvenenado(false);
        p.setAdormecido(false);
        p.setPontosVida(Math.min((p.getPontosVida() + this.getValor()), p.getVidaMax()));
        System.out.println(p.getNome() + " foi curado");
    }
}
