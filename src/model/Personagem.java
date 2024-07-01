package model;

import app.Batalha;
import model.habilidades.Habilidade;

import java.util.ArrayList;
import java.util.Random;

public abstract class Personagem implements Comparable<Personagem> {
    protected Random random = new Random();
    private String nome;

    private int chanceCritico = 2;
    private int pontosVida;

    private int pontosHabilidade = 5;
    private int maxPontosHabilidade = 10;

    private int destreza;

    private ArrayList<String> vantagens = new ArrayList<>();
    private ArrayList<String> desvantagens = new ArrayList<>();

    private int vidaMax;
    private int forca;
    private int defesa;

    private ArrayList<Habilidade> habilidades = new ArrayList<>();

    private boolean isEnvenenado;
    private boolean isAdormecido;
    private boolean isAtordoado;
    private boolean isQueimado;


    public Personagem(String nome, int pontosVida, int forca, int defesa) {
        this.nome = nome;
        this.pontosVida = pontosVida;
        this.forca = forca;
        this.defesa = defesa;
        this.vidaMax = pontosVida;
    }

    public Personagem(String nome, int pontosVida, int forca, int defesa, int pontosHabilidade) {
        this.nome = nome;
        this.pontosVida = pontosVida;
        this.forca = forca;
        this.defesa = defesa;
        this.vidaMax = pontosVida;
        this.pontosHabilidade = pontosHabilidade;
    }

    // Ações de batalha
    public void atacar(Personagem p) {
        int dano = this.calcularDano(p);
        p.tomarDano(dano);
    }
    public void defender() {
        this.setDefesa(5);
    };

    public void fugir(Batalha b) {
        b.getPersonagensOrdenados().remove(this);
        b.getPersonagensBatalha().remove(this);
        System.out.println(this.getNome()+" fugiu da batalha");
    }
    public void usarHabilidade(Personagem p1, int id) {
        this.setPontosHabilidade(this.getPontosHabilidade()-5);
        this.getHabilidades().get(id).usar(p1);
    }

    // Auxiliares

    public void carregar() {
        this.setPontosHabilidade(Math.max(this.getPontosHabilidade()+5, this.maxPontosHabilidade));
    }

    public int calcularDano(Personagem p1) {
        int dano = this.forca;
        if (vantagens.contains(p1.toString())) {
            dano = this.forca + (this.forca/2);
        } if (desvantagens.contains(p1.toString())) {
            dano = this.forca - (this.forca/2);
        }
        int n = random.nextInt(20);
        if (n <= chanceCritico) {
            System.out.println("Crítico");
            dano += dano/2;
        }
        System.out.println("O ataque de "+this.getNome()+" causou "+dano+" de dano em "+p1.getNome());
        return dano;

    }

    public void tomarDano(int dano) {
        if (this.isAdormecido) {
            this.setAdormecido(false);
        }
        this.setDefesa(this.getDefesa()-dano);
        if (this.getDefesa() < 0) {
            this.setPontosVida(this.getPontosVida()+this.getDefesa());
            this.setDefesa(0);
        }
    }

    public void imprimirPersonagem() {
        System.out.println("- - - - - - - - - -");
        System.out.println(this.getNome());
        System.out.println(this);
        System.out.println("Vida: "+this.getPontosVida());
        System.out.println("------------");
        System.out.println("Força: "+this.getForca());
        System.out.println("Defesa: "+this.getDefesa());
        System.out.println("------------");
        if (isAdormecido) {
            System.out.println("Adormecido");
        }
        if (isAtordoado) {
            System.out.println("Atordoado");
        }
        if (isEnvenenado) {
            System.out.println("Envenenado");
        }
        if (isQueimado) {
            System.out.println("Queimado");
        }
        System.out.println("- - - - - - - - - -");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    // Getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public void setPontosVida(int pontosVida) {
        this.pontosVida = pontosVida;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public ArrayList<Habilidade> getHabilidades() {
        return habilidades;
    }

    @Override
    public int compareTo(Personagem p) {
        return Integer.compare(p.getDestreza(), this.destreza);
    }

    public ArrayList<String> getVantagens() {
        return vantagens;
    }


    public ArrayList<String> getDesvantagens() {
        return desvantagens;
    }


    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public boolean isEnvenenado() {
        return isEnvenenado;
    }

    public boolean isAdormecido() {
        return isAdormecido;
    }

    public boolean isAtordoado() {
        return isAtordoado;
    }

    public boolean isQueimado() {
        return isQueimado;
    }

    public void setEnvenenado(boolean envenenado) {
        isEnvenenado = envenenado;
    }

    public void setAdormecido(boolean adormecido) {
        isAdormecido = adormecido;
    }

    public void setAtordoado(boolean atordoado) {
        isAtordoado = atordoado;
    }

    public void setQueimado(boolean queimado) {
        isQueimado = queimado;
    }

    public int getPontosHabilidade() {
        return pontosHabilidade;
    }

    public void setPontosHabilidade(int pontosHabilidade) {
        this.pontosHabilidade = pontosHabilidade;
    }

    public void setChanceCritico(int chanceCritico) {
        this.chanceCritico = chanceCritico;
    }
}
