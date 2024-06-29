import  java.util.Scanner;

import data21.*;

public class jogo21 {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);

        char op;

        boolean fim = false;

        System.out.println("\n--- 21 ---\n");

        System.out.print("Nome do jogador 1: ");
        Jogador jog1 = new Jogador(entrada.nextLine());

        System.out.print("Nome do jogador 2: ");
        Jogador jog2 = new Jogador(entrada.nextLine());

        while(!fim) {

            if (!jog1.getPassou()) {

                
                System.out.println("\n\n" + jog1.getNome() + ", sua vez!");
                if (jog1.getPontos() < 1) jog1.setPontos(jog1.getPontos() + Util.tirarCarta());
                System.out.println("Pontos: " + jog1.getPontos());
                System.out.print("Quer pegar mais uma carta? (s/n): ");
                op = entrada.nextLine().charAt(0);
                if(op == 's' || op == 'S') jog1.setPontos(jog1.getPontos() + Util.tirarCarta());
                else jog1.setPassou(true);
            }

            fim = Jogo.verificarFim(jog1, jog2);

            if(fim) break;

            if (!jog2.getPassou()) {

                System.out.println("\n\n" + jog2.getNome() + ", sua vez!");
                if (jog2.getPontos() < 1) jog2.setPontos(jog2.getPontos() + Util.tirarCarta());
                System.out.println("Pontos: " + jog2.getPontos());
                System.out.print("Quer pegar mais uma carta? (s/n): ");
                op = entrada.nextLine().charAt(0);
                if(op == 's' || op == 'S') jog2.setPontos(jog2.getPontos() + Util.tirarCarta());
                else jog2.setPassou(true);
            }

            fim = Jogo.verificarFim(jog1, jog2);

            if(jog1.getPassou() && jog2.getPassou()) fim = true;
            if(fim) break;
        }

        System.out.println("\tFim de Jogo!!\n\n");

        System.out.println(jog1.getNome() + " - " + jog1.getPontos());
        System.out.println(jog2.getNome() + " - " + jog2.getPontos());

        entrada.close();
    }
}