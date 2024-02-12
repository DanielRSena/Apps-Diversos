package dataBank;

import java.util.Random;

public class Client {

    private int numConta;
    private String nome;
    private String senha;
    private double saldo;

    public Client(String nome, String senha){ //construtor dos novos clientes

        this.nome = nome;
        this.senha = senha;
        this.numConta = geraNumConta(); //cria um número de conta aleatório
        this.saldo = 0.0;
        
        System.out.println(BancoDeDados.salvar(this.numConta, this.nome, this.senha, this.saldo));
    }

    public String getNome() { return this.nome; }

    public double getSaldo() { return this.saldo; }

    public int getNumConta() { return this.numConta; }

    public String getSenha() { return this.senha; }

    private int geraNumConta(){ //método para gerar números de conta aleatórios

        Random random = new Random();
        int novaConta;

        while (true) { //fará enquanto o número da conta sorteado existir no bd

            novaConta = random.nextInt( 999999 - 000000 + 1) - 000000; //isso faz gerar números de 6 dígitos
            if(BancoDeDados.findClient(novaConta) == false) break;
        }

        return novaConta;
    }
}