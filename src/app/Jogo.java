package app;
import model.Personagem;
import model.classes.Arqueiro;
import model.classes.Barbaro;
import model.classes.Druida;
import model.classes.Mago;
import model.inimigos.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
    Scanner sc = new Scanner(System.in);
    ArrayList<Personagem> personagens = new ArrayList<>();
    ArrayList<Inimigo> inimigos = new ArrayList<>();

    public void iniciarJogo() throws InterruptedException {
        System.out.println("Bem vindo ao RPG!");
        while (true) {
            System.out.println("Digite o número correspondente a ação que deseja realizar:");
            System.out.println("1 - Criar Personagem");
            System.out.println("2 - Criar Inimigo");
            System.out.println("3 - Entrar em batalha");
            System.out.println("4 - Ver informações");
            System.out.println("5 - Sair");
            String r = sc.next();

            if (r.equalsIgnoreCase("5")) {
                System.out.println("Jogo encerrado");
                break;
            }

            switch (r) {
                case "1" -> criarPersonagem();
                case "2" -> criarInimigo();
                case "3" -> iniciarBatalha();
                case "4" -> imprimirInformacoes();
                default -> System.out.println("Opção inválida");
            }
        }
    }

    public void criarPersonagem () {

        System.out.println("Digite o nome do personagem: ");
        String nome = sc.next();

        while (true) {
            System.out.println("Digite o número correspondente a classe do personagem: ");
            System.out.println("1 - Barbáro");
            System.out.println("2 - Mago");
            System.out.println("3 - Arqueiro");
            System.out.println("4 - Druida");
            System.out.println("5 - Cancelar");
            String classe = sc.next();

            if (classe.equalsIgnoreCase("5")) {
                return;
            }

            switch (classe) {
                case "1" -> personagens.add(new Barbaro(nome));
                case "2" -> personagens.add(new Mago(nome));
                case "3" -> personagens.add(new Arqueiro(nome));
                case "4" -> personagens.add(new Druida(nome));
                default -> {
                    System.out.println("Opção inválida");
                    continue;
                }
            }
            break;
        }
    }

    public void criarInimigo() {
        System.out.println("Digite o nome do Inimigo: ");
        String nome = sc.next();
        while (true) {
            System.out.println("Selecione a espécie: ");
            System.out.println("1 - Banshee");
            System.out.println("2 - Troll");
            System.out.println("3 - Demônio");
            System.out.println("4 - Aranha Gigante");
            System.out.println("5 - Cancelar");
            String classe = sc.next();
            if (classe.equalsIgnoreCase("5")) {
                return;
            }
            switch (classe) {
                case "1" -> inimigos.add(new Banshee(nome));
                case "2" -> inimigos.add(new Troll(nome));
                case "3" -> inimigos.add(new Demonio(nome));
                case "4" -> inimigos.add(new AranhaGigante(nome));
                default -> {
                    System.out.println("Opção inválida");
                    continue;
                }
            }
            break;
        }
    }

    public void imprimirInformacoes() {
        System.out.println("--------------------");
        System.out.println("\n--Heróis--");
        for (Personagem p: personagens) {
            System.out.println("");
            p.imprimirPersonagem();
        }
        System.out.println("\n--Inimigos--");
        for (Inimigo i: inimigos) {
            System.out.println("");
            i.imprimirPersonagem();
        }
        System.out.println("--------------------");
        System.out.println("");
    }

    public void iniciarBatalha() throws InterruptedException {
        if (personagens.isEmpty() && inimigos.isEmpty()) {
            System.out.println("Você não criou nenhum personagem, não é possível entrar em batalha");
            return;
        }
        if (inimigos.isEmpty()) {
            System.out.println("Você tem apenas heróis criados, para entrar em batalha é necessário criar algum inimigo");
            return;
        }
        if (personagens.isEmpty()) {
            System.out.println("Você tem apenas inimigos criados, para entrar em batalha é necessário criar algum herói");
            return;
        }
        Batalha b = new Batalha(personagens, inimigos);
        b.iniciarBatalha();
    }
}