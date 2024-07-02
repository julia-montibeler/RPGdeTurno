package app;
import model.Personagem;
import model.inimigos.Inimigo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
public class Batalha {

    Random random = new Random();

    Scanner sc = new Scanner(System.in);
    //arraylist com as instâncias de personagens do jogo, caso o personagem morra em batalha, ele é eliminado também do jogo
    private ArrayList<Personagem> personagens;
    //arraylist com os personagens ordenados por ordem de destreza
    private ArrayList<Personagem> personagensOrdenados;
    //arraylist com cópias dos personagens do jogo, assim, se um personagem fugir da batalha ele é excluído desse arraylist
    //mas não do jogo
    private ArrayList<Personagem> personagensBatalha = new ArrayList<>();
    private ArrayList<Inimigo> inimigos;



    public Batalha(ArrayList<Personagem> personagens, ArrayList<Inimigo> inimigos) {
        this.personagens = personagens;
        this.inimigos = inimigos;
        personagensOrdenados = definirOrdem();
        personagensBatalha.addAll(personagens);
    }

    public void iniciarBatalha() throws InterruptedException {
        int i = 1;
        System.out.println("COMEÇOU A BATALHA!");
        this.imprimirInformacoes();
        while (!(personagensBatalha.isEmpty()) && !(inimigos.isEmpty())) {
            if ((i%3) == 0) {
                for (Personagem p: personagensBatalha) {
                    p.carregar();
                }
            }
            System.out.println("\n-----------------------------------");
            System.out.println("Rodada "+i);
            for (int j = 0; j < personagensOrdenados.size(); j++) {
                if (inimigos.isEmpty() || personagensBatalha.isEmpty()) {
                    break;
                }
                if (personagensOrdenados.get(j) instanceof Inimigo) {
                    turnoInimigo((Inimigo) personagensOrdenados.get(j));
                } else {
                    turnoPersonagem(personagensOrdenados.get(j));
                }
            }
            if (inimigos.isEmpty() || personagensBatalha.isEmpty()) {
                break;
            }
            i++;
            System.out.println("\n-----------------------------------");
        }

        if (inimigos.isEmpty()) {
            System.out.println("Os heróis venceram! :D\n");
        } else {
            System.out.println("Os inimigos venceram :(\n");
        }

    }

    public void turnoPersonagem(Personagem p) {

        System.out.println("\n--------------------");
        System.out.println("Turno de "+p.getNome());

        //verificação de efeitos de batalha
        if (p.isAtordoado()) {
            System.out.println("atordoado");
            p.setAtordoado(false);
            return;
        }
        if (p.isAdormecido()) {
            System.out.println("adormecido");
            return;
        }
        if (p.isEnvenenado()) {
            System.out.println("-2 veneno");
            p.tomarDano(2);
            if (p.getPontosVida() <= 0) {
                this.personagensOrdenados.remove(p);
                this.personagens.remove(p);
                this.personagensBatalha.remove(p);
            }
        }
        if (p.isQueimado()) {
            System.out.println("-1 queimadura");
            p.tomarDano(1);
            if (p.getPontosVida() <= 0) {
                this.personagensOrdenados.remove(p);
                this.personagens.remove(p);
                this.personagensBatalha.remove(p);
            }
        }

        p.imprimirPersonagem();

        while (true) {
            System.out.println("1 - Atacar");
            System.out.println("2 - Defender");
            if ((p.getHabilidades().isEmpty())) {
                System.out.println("3 - Usar Habilidade (Não possui nenhuma)");
            } else {
                System.out.println("3 - Usar Habilidade");
            }
            System.out.println("4 - Fugir");
            String r = sc.next();

            switch (r) {
                case "1" -> {
                    int ri = 1;
                    if (this.inimigos.size() > 1) {
                        System.out.println("Qual inimigo " + p.getNome() + " vai atacar?");
                        for (int i = 0; i < inimigos.size(); i++) {
                            System.out.println((i + 1) + " - " + inimigos.get(i).getNome());
                        }
                        ri = sc.nextInt();
                        if (ri < 1 || ri > inimigos.size()) {
                            System.out.println("Opção inválida");
                            System.out.println("Perdeu a vez!");
                            return;
                        }
                    }
                    p.atacar(inimigos.get(ri - 1));
                    if (inimigos.get(ri - 1).getPontosVida() <= 0) {
                        System.out.println(inimigos.get(ri - 1).getNome() + " morreu");
                        p.setXp(p.getXp()+inimigos.get(ri-1).getRecompensaXP());
                        System.out.println(p.getNome() +" ganhou "+inimigos.get(ri-1).getRecompensaXP()+" de xp");
                        personagensOrdenados.remove(inimigos.get(ri - 1));
                        inimigos.remove(ri-1);
                    }
                }
                case "2" -> p.defender();
                case "3" -> {
                    int ri = 1;
                    if (p.getHabilidades().isEmpty()) {
                        System.out.println("Não possui habilidades");
                        continue;
                    }
                    if (p.getPontosHabilidade() == 0) {
                        System.out.println("Está sem pontos para usar habilidades");
                        continue;
                    }
                    if (p.getHabilidades().size() > 1) {
                        System.out.println("Qual habilidade " + p.getNome() + " vai usar?");
                        for (int i = 0; i < p.getHabilidades().size(); i++) {
                            System.out.println((i + 1) + " - " + p.getHabilidades().get(i).getNome() + "("+p.getHabilidades().get(i).getValor()+")");
                        }
                        ri = sc.nextInt();
                        if (ri < 0 || ri > p.getHabilidades().size()) {
                            System.out.println("Opção inválida");
                            System.out.println("Perdeu a vez!");
                            return;
                        }
                    }
                    int i = 1;
                    if (personagensOrdenados.size() > 1) {
                        System.out.println("Em qual personagem " + p.getNome() + " vai usar " + p.getHabilidades().get(ri - 1).getNome() + " ?");
                        for (int j = 0; j < personagensOrdenados.size(); j++) {
                            System.out.println((j + 1) + " - " + personagensOrdenados.get(j).getNome());
                        }
                        i = sc.nextInt();
                        if (i < 0 || i > personagensOrdenados.size()) {
                            System.out.println("Opção inválida");
                            System.out.println("Perdeu a vez!");
                        }
                    }
                    p.usarHabilidade(personagensOrdenados.get(i - 1), ri - 1);
                    if (personagensOrdenados.get(i - 1).getPontosVida() <= 0) {
                        System.out.println(personagensOrdenados.get(i - 1).getNome() + " morreu");
                        p.setXp(p.getXp()+inimigos.get(ri-1).getRecompensaXP());
                        System.out.println(p.getNome() +" ganhou "+inimigos.get(ri-1).getRecompensaXP()+" de xp");
                        inimigos.remove(personagensOrdenados.get(i - 1));
                        personagensOrdenados.remove(i - 1);
                    }
                }
                case "4" -> p.fugir(this);
                default -> {
                    System.out.println("Opção inválida");
                    continue;
                }
            }
            break;
        }
        System.out.println("--------------------\n");
    }

    public void turnoInimigo(Inimigo i) throws InterruptedException {
        System.out.println("\n--------------------");
        System.out.println("turno de "+i.getNome());
        i.imprimirPersonagem();
        if (i.isAtordoado()) {
            System.out.println("atordoado");
            i.setAtordoado(false);
            return;
        }
        if (i.isAdormecido()) {
            System.out.println("adormecido");
            return;
        }
        if (i.isEnvenenado()) {
            System.out.println("-2 veneno");
            i.tomarDano(2);
            if (i.getPontosVida() <= 0) {
                this.personagensOrdenados.remove(i);
                this.inimigos.remove(i);
            }
        }
        if (i.isQueimado()) {
            System.out.println("-1 queimadura");
            i.tomarDano(1);
            if (i.getPontosVida() <= 0) {
                this.personagensOrdenados.remove(i);
                this.inimigos.remove(i);
            }
        }
        int indexPersonagem = 0;
        if (personagensBatalha.size() != 1) {
            indexPersonagem = random.nextInt(personagensBatalha.size());
        }
        i.atacar(personagensBatalha.get(indexPersonagem));
        if (personagensBatalha.get(indexPersonagem).getPontosVida() <= 0) {
            System.out.println(personagensBatalha.get(indexPersonagem).getNome()+" morreu");
            personagensOrdenados.remove(personagensBatalha.get(indexPersonagem));
            personagens.remove(personagensBatalha.get(indexPersonagem));
            personagensBatalha.remove(indexPersonagem);
        }
        System.out.println("--------------------\n");
        Thread.sleep(4000);
    }

    public ArrayList<Personagem> definirOrdem() {
        personagensOrdenados = new ArrayList<>();
        personagensOrdenados.addAll(personagens);
        personagensOrdenados.addAll(inimigos);
        Collections.sort(personagensOrdenados);
        return personagensOrdenados;
    }

    public void imprimirInformacoes() {
        System.out.println("--------------------");
        System.out.println("--Heróis--");
        for (Personagem p: personagens) {
            System.out.println("");
            p.imprimirPersonagem();
        }
        System.out.println("--Inimigos--");
        for (Inimigo i: inimigos) {
            System.out.println("");
            i.imprimirPersonagem();
        }
        System.out.println("--------------------");
        System.out.println("");
    }

    public ArrayList<Personagem> getPersonagensOrdenados() {
        return personagensOrdenados;
    }

    public void setPersonagensOrdenados(ArrayList<Personagem> personagensOrdenados) {
        this.personagensOrdenados = personagensOrdenados;
    }

    public ArrayList<Personagem> getPersonagensBatalha() {
        return personagensBatalha;
    }

    public void setPersonagensBatalha(ArrayList<Personagem> personagensBatalha) {
        this.personagensBatalha = personagensBatalha;
    }

    public ArrayList<Personagem> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(ArrayList<Personagem> personagens) {
        this.personagens = personagens;
    }

    public ArrayList<Inimigo> getInimigos() {
        return inimigos;
    }

    public void setInimigos(ArrayList<Inimigo> inimigos) {
        this.inimigos = inimigos;
    }
}