import java.util.Scanner;

import dataVelha.Util;

public class jogoDaVelha {
    public static void main(String[] args) {

        char jogo[][] = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
        Scanner entrada = new Scanner(System.in);
        String jog1, jog2, jogadorAtual = "";
        int linha, coluna, cont = 0;
        boolean fim = false;

        System.out.println("\n--- Jogo da Velha ---\n");
        
        System.out.print("Digite o nome do jogador 1: ");
        jog1 = entrada.nextLine();
        System.out.print("Digite o nome do jogador 2: ");
        jog2 = entrada.nextLine();

        while (cont < 9 || fim) {
            
            Util.printaJogo(jogo);

            jogadorAtual = (cont % 2 == 0)? jog1 : jog2;

            System.out.println("\n\n" + jogadorAtual + ", sua vez!");
            
            linha = Util.pedeInt("Digite a linha");
            coluna = Util.pedeInt("Digite a coluna");

            if(jogo[linha][coluna] == '-') jogo[linha][coluna] = (cont % 2 == 0) ? 'X' : 'O';
            else {
                System.out.println("\nLugar já preenchido! Digite novamente, " + jogadorAtual);
                cont--;
            }

            fim = Util.verificaFim(jogo);
            if(fim) break;

            System.out.println();

            cont++;
        }

        Util.printaJogo(jogo);

        if(fim) System.out.println("\n\n\tParabéns, " + jogadorAtual + ", você ganhou!\n\n");
        else System.out.println("\n\n\tDEU VELHA\n\n");

        entrada.close();
    }
}