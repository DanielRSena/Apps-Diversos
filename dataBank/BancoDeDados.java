package dataBank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

    private static String nomeArquivo = "dataBank\\dataClients.txt";
    private static List<String> linhas = new ArrayList<>();

    private static int readDataClients(){
        try {

            List<String> novaLeitura = new ArrayList<>();
            String linha;
            BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
                while ((linha = br.readLine()) != null) { novaLeitura.add(linha); } //enquanto o bd bão estiver vazio, ads o conteúdo nas linhas
                br.close(); //se já esvaziou, fecha o leitor
            linhas = novaLeitura;
        } catch (IOException e) {
            System.err.println("\n\nErro ao manipular o arquivo: " + e.getMessage() + "\n\n");
        }

        return 0;

    }

    public static boolean findClient(int numBusca){

        readDataClients();

        boolean clientFounded = false;
        String clientData = String.valueOf(numBusca);

        // validação nº conta e senha
        for (int i = 0; i < linhas.size(); i++) {
            String[] partes = linhas.get(i).split(", ");
            String contaCliente = partes[0];

            if (contaCliente.equals(clientData)){
                clientFounded = true;
                break;
            }
        }

        return clientFounded;
    }

    public static String[] findPassword(String senha){

        readDataClients();

        boolean passwordRight = false;
        String dados[] = new String[4];
        String error[] = new String[1];

        // validação nº conta e senha
        for (int i = 0; i < linhas.size(); i++) {
            String[] partes = linhas.get(i).split(", ");
            dados = partes.clone();
            String senhaCliente = partes[2];

            if (senhaCliente.equals(senha)){
                passwordRight = true;
                break;
            }
        }

        if(passwordRight == true) return dados;
        else return error;
    }

    public static String salvar(int numConta, String nome, String senha, double saldo) {

        String mensagem = "";

        String newClient = numConta + ", " + nome + ", " + senha + ", " + saldo;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true));
            writer.write(newClient);
            writer.close();
        } catch (IOException e) {
            mensagem = "\n\nErro ao adicionar o cliente\n";
        }

        return mensagem;
    }

    public static String saveSaldo(String numConta, String newSaldo){

        readDataClients();

        String mensagem = "Saldo atualizado com sucesso", clientes[], contaCliente, cliente;

        try {

            StringBuilder stringBuilder = new StringBuilder();
            readDataClients();            

            for (int i = 0; i < linhas.size(); i++) {
                clientes = linhas.get(i).split(", ");
                contaCliente = clientes[0];

                if (numConta.equals(contaCliente)) cliente = clientes[0] + ", " + clientes[1] + ", " + clientes[2] + ", " + newSaldo;
                else cliente = clientes[0] + ", " + clientes[1] + ", " + clientes[2] + ", " + clientes[3];

                stringBuilder.append(cliente).append("\n");
            
            }

            // Reescreve o conteúdo atualizado no arquivo
            readDataClients();
            BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo));
            writer.write(stringBuilder.toString());
            writer.close();
            
        } catch (Exception e) {
            System.out.println("errrooooo");
        }

        return mensagem;
    }

}
