package ReservaHotel;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    private int id;
    private String nome;
    private String endereco;
    private String postalCod;
    private String pais;
    private String cpf;
    private String passaporte;
    private String email;
    private LocalDate dataNasc;

    public Cliente(int id, String nome, String endereco, String postalCod, String pais, String cpf,
                   String passaporte, String email, LocalDate dataNasc) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.postalCod = postalCod;
        this.pais = pais;
        this.cpf = cpf;
        this.passaporte = passaporte;
        this.email = email;
        this.dataNasc = dataNasc;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getPostalCod() {
        return postalCod;
    }

    public String getPais() {
        return pais;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void salvar() {
        try {
            FileWriter fw = new FileWriter("clientes.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(id + "," + nome + "," + endereco + "," + postalCod + "," + pais + "," + cpf + ","
                    + passaporte + "," + email + "," + dataNasc.format(DateTimeFormatter.ISO_DATE));
            pw.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar o cliente no arquivo");
        }
    }

    public static List<Cliente> lerClientes() {
        List<Cliente> clientes = new ArrayList<>();

        try {
            File arquivo = new File("clientes.txt");

            if (arquivo.exists()) {
                Scanner scanner = new Scanner(arquivo);
                while (scanner.hasNextLine()) {
                    String linha = scanner.nextLine();
                    String[] dados = linha.split(",");
                    int id = Integer.parseInt(dados[0]);
                    String nome = dados[1];
                    String endereco = dados[2];
                    String postalCod = dados[3];
                    String pais = dados[4];
                    String cpf = dados[5];
                    String passaporte = dados[6];
                    String email = dados[7];
                    LocalDate dataNasc = LocalDate.parse(dados[8], DateTimeFormatter.ISO_DATE);

                    Cliente cliente = new Cliente(id, nome, endereco, postalCod, pais, cpf, passaporte, email, dataNasc);
                    clientes.add(cliente);
                }
                scanner.close();
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de clientes");
        }

        return clientes;
    }

    public static void listarClientes() {
        List<Cliente> clientes = lerClientes();

        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados");
        } else {
           System.out.println("LISTA DE CLIENTES");
            for (Cliente cliente : clientes) {
                System.out.println("ID: " + cliente.getId());
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("Endereço: " + cliente.getEndereco());
                System.out.println("Código Postal: " + cliente.getPostalCod());
                System.out.println("País: " + cliente.getPais());
                System.out.println("CPF: " + cliente.getCpf());
                System.out.println("Passaporte: " + cliente.getPassaporte());
                System.out.println("E-mail: " + cliente.getEmail());
                System.out.println("Data de Nascimento: " + cliente.getDataNasc());
                System.out.println("------------------------------");
            }
        }
    }
}
