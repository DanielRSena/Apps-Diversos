package dataBank;

import java.util.Random;

public class Client {

    private int numConta;
    private String nome;
    private String senha;
    private double saldo = 0.0;

    public Client(String nome, String senha){

        this.nome = nome;
        this.senha = senha;
        this.numConta = geraNumConta();
        this.saldo = 0.0;
        
        System.out.println(BancoDeDados.salvar(this.numConta, this.nome, this.senha, this.saldo));
    }

    public String getNome() { return this.nome; }

    public double getSaldo() { return this.saldo; }

    public int getNumConta() { return this.numConta; }

    public String getSenha() { return this.senha; }

    private int geraNumConta(){

        Random random = new Random();
        int novaConta;
        while (true) {
            novaConta = random.nextInt( 999999 - 000000 + 1) - 000000;
            if(BancoDeDados.findClient(novaConta) == false) break;
        }
        return novaConta;
    }
}
