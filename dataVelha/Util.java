package dataVelha;

import java.util.Scanner;

public class Util {

    static Scanner entrada = new Scanner(System.in);

    public static int pedeInt(String mensagem) {

        int num = 0;
        try {
            do {
                System.out.print(mensagem + ": ");
                num = entrada.nextInt();
                num--;
            } while (num < 0 || num > 2);

        } catch (NumberFormatException e) {
            entrada.next();
        }
        return num;
    }

    public static boolean verificaFim(char jogo[][]){

        char p1, p2, p3;

        for (int i = 0; i < 3; i++) {

            p1 = jogo[i][0];
            p2 = jogo[i][1];
            p3 = jogo[i][2];
            if(p1 != '-' && p1 == p2 && p2 == p3) return true;

            p1 = jogo[0][i];
            p2 = jogo[1][i];
            p3 = jogo[2][i];
            if(p1 != '-' && p1 == p2 && p2 == p3) return true;

            if(jogo[0][0] != '-' && jogo[0][0] == jogo[1][1] && jogo[1][1] == jogo[2][2]) return true;
            if(jogo[0][2] != '-' && jogo[0][2] == jogo[1][1] && jogo[1][1] == jogo[2][0]) return true;
        }
        return false;
    }

    public static int printaJogo(char jogo[][]){

        for (int i = 0; i < 3; i++) {
            System.out.println();
            for (int j = 0; j < 3; j++)
                System.out.print("\t" + jogo[i][j]);
        }

        return 0;
    }
}