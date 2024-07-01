package model.habilidades;

import model.Personagem;

import java.util.Random;

public abstract class Habilidade {
    protected Random random = new Random();
    private int valor;

    private String tipo;

    private String nome;

    public Habilidade(int valor, String tipo, String nome) {
        this.valor = valor;
        this.tipo = tipo;
        this.nome = nome;
    }

    public int calcularDano(Personagem p) {
        int dano = this.valor;
        if (p.getVantagens().contains(this.tipo)) {
            dano = this.valor - (this.valor/2);
        } if (p.getDesvantagens().contains(this.tipo)) {
            dano = this.valor + (this.valor/2);
        }
        System.out.println(this.getNome()+" causou "+dano+" de dano em "+p.getNome());
        return dano;

    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }

    public abstract void usar(Personagem p);
}
