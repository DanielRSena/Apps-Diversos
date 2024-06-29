package data21;

public class Jogador {

    private String nome;
    boolean passou;
    int pontos;
    int ganhou;
    int perdeu;
    int empate;
    
    public Jogador(String nome) {
        this.nome = nome;
        this.passou = false;
        this.pontos = 0;
        this.ganhou = 0;
        this.perdeu = 0;
        this.empate = 0;
    }

    public String getNome() { return this.nome; }
    public boolean getPassou() { return this.passou; }
    public int getPontos() { return this.pontos; }
    public int getGanhou() { return this.ganhou; }
    public int getPerdeu() { return this.perdeu; }
    public int getEmpate() { return this.empate; }

    public void setPassou(boolean passou) { this.passou = passou; }
    public void setPontos(int pontos) { this.pontos = pontos; }
    public void setGanhou(int ganhou) { this.ganhou = ganhou; }
    public void setPerdeu(int perdeu) { this.perdeu = perdeu; }
    public void setEmpate(int empate) { this.empate = empate; }
}