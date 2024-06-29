package data21;

public class Util {
    public static int tirarCarta() {
        int num = (int) (Math.random() * 10) + 1;
        System.out.println("Carta escolhida: " + num);
        return num;
    }
}