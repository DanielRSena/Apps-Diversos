package dataBank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Conta {

    static Scanner entrada = new Scanner(System.in);

    public static int entrar() {

        String senha;
        int numConta;

        while (true) { // pega o número da conta
            try {

                System.out.print("\n\tDigite o número da conta: ");
                numConta = entrada.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nApenas números são permitidos!\n");
                entrada.nextLine();
            }
        }

        if (BancoDeDados.findClient(numConta) == true) { // se o número da conta existe

            System.out.print("\n\tDigite a senha: ");
            entrada.nextLine();
            senha = entrada.nextLine();

            String dadosCliente[] = BancoDeDados.findPassword(senha);

            if (dadosCliente.length == 4)
                menu(dadosCliente); // se a senha está certa, 'abre' o menu do banco
            else
                System.out.println("\nSenha errada\n"); // se o tamanho do vetor é 1, significa que a senha está errada
        } else
            System.out.println("\nEsse número de conta não existe\n");

        return 0;
    }

    private static int menu(String dadosCliente[]) {

        int opcao = 0;

        while (opcao != 4) {

            System.out.println("\n\nBem vindo, " + dadosCliente[1] + "\n\n1. Sacar\n2. Depositar\n3. Ver saldo\n4. Sair \n");

            try {

                do {
                    System.out.print("Digite o que deseja fazer: ");
                    opcao = entrada.nextInt();
                } while (opcao < 1 || opcao > 4);
            } catch (InputMismatchException e) {
                System.out.println("\nOpção inválida");
                entrada.nextLine();
            }

            switch (opcao) { //opções disponíveis para o cliente
                case 1:
                    saqueEDeposito(opcao, dadosCliente);
                    System.out.println("\n\tO saldo atual é de R$ " + dadosCliente[3]);
                    break;
                case 2:
                    saqueEDeposito(opcao, dadosCliente);
                    System.out.println("\n\tO saldo atual é de R$ " + dadosCliente[3]);
                    break;
                case 3:
                    System.out.println("\n\tO saldo atual é de R$ " + dadosCliente[3]);
                    break;
                default: break; //se cair aqui, é porque escolheu a opçõ 4 e sairá da conta 
            }
        }

        return 0; //voltará para o menu do 'app'
    }

    static String[] saqueEDeposito(int operation, String[] dadosCliente) {

        String strSaldo = "";
        double saque = 0.0, saldo = Double.parseDouble(dadosCliente[3]);

        if (operation == 1) { // se a op escolhiad foi saque

            while (true) { // fará enquanto o saque não for válido

                try {
                    do {
                        System.out.print("\n\tSaldo atual: " + saldo + "\n\tDigite o valor do saque: ");
                        saque = entrada.nextDouble();
                    } while (saque < 0.0 || saque > saldo);
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("\nErro! Valor inválido");
                    entrada.next();
                }
            }
            saldo -= saque;

        } else {

            double deposito = 0.0;

            while (true) { // garante que o cliente colocará um valor válido
                try {

                    do {
                        System.out.print("\n\tDigite o valor do depósito: ");
                        deposito = entrada.nextDouble();
                    } while (deposito < 0);
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("\nErro! Valor inválido");
                    entrada.nextLine();
                }
            }

            saldo += deposito; // inclui o valor depositado no saldo
        }

        strSaldo = String.valueOf(saldo);
        System.out.println("Depósito " + BancoDeDados.saveSaldo(dadosCliente[0], strSaldo));
        dadosCliente[3] = strSaldo;

        return dadosCliente; //agora atualizado com o saque ou depósito
    }
}