package data21;

public class Jogo {
    public static boolean verificarFim(Jogador j1, Jogador j2) {

        boolean fim = false;

        if (j1.getPontos() > 21) {
            System.out.print("\n\n" + j1.getNome() + " perdeu!");
            j1.setPerdeu(j1.getPerdeu() + 1);
            j2.setGanhou(j2.getGanhou() + 1);
            fim = true;
        }
        if (j2.getPontos() > 21) {
            System.out.print("\n\n" + j2.getNome() + " perdeu!");
            j2.setPerdeu(j2.getPerdeu() + 1);
            j1.setGanhou(j1.getGanhou() + 1);
            fim = true;
        }
        if (j1.getPontos() == 21) {
            System.out.print("\n\n" + j1.getNome() + " ganhou!");
            j1.setGanhou(j1.getGanhou() + 1);
            j2.setPerdeu(j2.getPerdeu() + 1);
            fim = true;
        }
        if (j2.getPontos() == 21) {
            System.out.print("\n\n" + j2.getNome() + " ganhou!");
            j2.setGanhou(j2.getGanhou() + 1);
            j1.setPerdeu(j1.getPerdeu() + 1);
            fim = true;
        }
        if (j1.getPontos() == j2.getPontos() && j1.getPassou() && j2.getPassou()) {
            j1.setEmpate(j1.getEmpate() + 1);
            j2.setEmpate(j2.getEmpate() + 1);
            System.out.print("\n\nEmpate!");
            fim = true;
        }
        if (j1.getPassou() && j2.getPassou()) {

            if (j1.getPontos() > j2.getPontos()) {
                System.out.print("\n\n" + j1.getNome() + " ganhou!");
                j1.setGanhou(j1.getGanhou() + 1);
                j2.setPerdeu(j2.getPerdeu() + 1);
                fim = true;
            } else {
                System.out.print("\n\n" + j2.getNome() + " ganhou!");
                j2.setGanhou(j2.getGanhou() + 1);
                j1.setPerdeu(j1.getPerdeu() + 1);
                fim = true;
            }
        }
        return fim;
    }
}