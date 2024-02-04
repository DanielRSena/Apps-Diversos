import java.util.InputMismatchException;
import java.util.Scanner;
import dataBank.*;

public class bank {

    public static void main(String[] args) {

        // variáveis gerais
        Scanner entrada = new Scanner(System.in);
        int option = 0;
        String senha;
        char menu = 's';

        while (menu == 's') {
            System.out.println("\n\nBem vindo ao banco Dan!\n\n\t\t1. Entrar na sua conta\n\t\t2. Abrir uma conta");
    
            while (true) {
                try {
                    do{
                        System.out.print("\nDigite a opção: ");
                        option = entrada.nextInt();
                    } while(option != 1 && option != 2);
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("\n\nDigite apenas números\n");
                    entrada.nextLine();
                }
            }
            
            if(option == 1) Conta.entrar();
    
            else { 
    
                String nome;
                System.out.print("\n\tDigite o nome de usuário: ");
                entrada.nextLine();
                nome = entrada.nextLine();
                System.out.print("\n\tAgora digite a senha: ");
                senha = entrada.nextLine();
                Client client = new Client(nome, senha);

                System.out.println("Seu número de conta é " + client.getNumConta());
    
                if(Conta.escolha("Deseja entrar na sua conta agora") == 's') Conta.entrar();
            }

            menu = Conta.escolha("Você quer voltar ao menu");
        }

        System.out.println("\n\n\tObrigado por usar meu app de banco! Aceito sugestões\n");
        entrada.close();
    }

}