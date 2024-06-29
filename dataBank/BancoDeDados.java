package dataBank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

    private static String nomeArquivo = "dataBank\\dataClients.txt"; //local do banco de dados
    private static List<String> linhas = new ArrayList<>(); //faz uma lista com cada cliente

    private static int lerDataClientes() { // lê o conteúdo do db

        try {

            //variáveis para leitura
            List<String> novaLeitura = new ArrayList<>(); //cria uma nova lista para sempre atualizar os dados
            String linha; //String com cada cliente
            BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));

            //atualiza 'linhas', a lista com os clientes
            while ((linha = leitor.readLine()) != null) {
                novaLeitura.add(linha); //add o cliente (linha) na lista
            } // enquanto o bd não estiver vazio, ads o conteúdo nas linhas

            leitor.close(); // se já esvaziou, fecha o leitor
            linhas = novaLeitura; //lista de clientes atualizada
        } catch (IOException e) {
            System.err.println("\n\nErro ao manipular o arquivo: " + e.getMessage() + "\n\n");
        }

        return 0;
    }

    public static boolean encontrarClientes(int numBusca) {

        lerDataClientes(); //faz a atualização dos clientes

        boolean clientFounded = false; 
        String clientData = String.valueOf(numBusca); //converte numBusca para String

        // validação nº conta e senha
        for (int i = 0; i < linhas.size(); i++) { //fará até passar por todos os clientes ou até encontrar o cliente
            String[] partes = linhas.get(i).split(", "); //divide os dados do cliente em partes de um vetor
            String contaCliente = partes[0];

            if (contaCliente.equals(clientData)) { //se o cliente buscado é achado
                clientFounded = true;
                break; //não é necessário continuar a busca
            }
        }

        return clientFounded;
    }

    public static String[] encontrarSenha(int numBusca, String senha) {

        lerDataClientes(); //atualiza a lista de clientes

        boolean passwordRight = false;
        String dados[] = new String[4];
        String error[] = new String[1];

        // validação nº conta e senha
        for (int i = 0; i < linhas.size(); i++) {
            String[] partes = linhas.get(i).split(", ");
            dados = partes.clone();
            String senhaCliente = partes[2];
            String numConta = partes[0];

            if (numBusca == Integer.parseInt(numConta) && senhaCliente.equals(senha)) {
                passwordRight = true;
                break;
            }
        }

        if (passwordRight == true) return dados; //se a senha estiver certa, retorna os dados do cliente
        else return error; //se a senha estiver errada, retorna um vetor vazio
    }

    public static String salvar(int numConta, String nome, String senha, double saldo) {

        String mensagem = "";
        String newClient = numConta + ", " + nome + ", " + senha + ", " + saldo;

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true));
            writer.newLine();
            writer.write(newClient);
            writer.close();
        } catch (IOException e) {
            mensagem = "\n\nErro ao adicionar o cliente\n";
        }

        return mensagem;
    }

    public static String saveSaldo(String numConta, String newSaldo) {

        lerDataClientes(); //mantem os dados dos clientes atualizados

        String mensagem = "realizado com sucesso", clientes[], contaCliente, cliente;

        try {

            StringBuilder stringBuilder = new StringBuilder();
            lerDataClientes(); //mantem os dados dos clientes atualizados

            for (int i = 0; i < linhas.size(); i++) {
                clientes = linhas.get(i).split(", ");
                contaCliente = clientes[0];

                if (numConta.equals(contaCliente))
                    cliente = clientes[0] + ", " + clientes[1] + ", " + clientes[2] + ", " + newSaldo;
                else
                    cliente = clientes[0] + ", " + clientes[1] + ", " + clientes[2] + ", " + clientes[3];

                stringBuilder.append(cliente).append("\n"); //add o cliente no bd
            }

            // Reescreve o conteúdo atualizado no arquivo
            lerDataClientes();
            BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo));
            writer.write(stringBuilder.toString()); //pega os novos dados dos clientes e os sobrepõe no bd
            writer.close(); //fecha o escritor

        } catch (Exception e) {
            System.out.println("Erro ao atualizar o saldo" + e.getMessage());
        }

        return mensagem;
    }
}