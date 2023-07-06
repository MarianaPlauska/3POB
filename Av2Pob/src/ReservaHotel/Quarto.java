package ReservaHotel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quarto {
    private int id;
    private String nomeQuarto;
    private int qtdeCamas;
    private boolean temBanheiro;
    private String descricao;

    public Quarto(int id, String nomeQuarto, int qtdeCamas, boolean temBanheiro, String descricao) {
        this.id = id;
        this.nomeQuarto = nomeQuarto;
        this.qtdeCamas = qtdeCamas;
        this.temBanheiro = temBanheiro;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getNomeQuarto() {
        return nomeQuarto;
    }

    public int getQtdeCamas() {
        return qtdeCamas;
    }

    public boolean isTemBanheiro() {
        return temBanheiro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void salvar() {
        try {
            FileWriter fw = new FileWriter("quartos.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(id + "," + nomeQuarto + "," + qtdeCamas + "," + temBanheiro + "," + descricao);
            pw.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar o quarto no arquivo");
        }
    }

    public static List<Quarto> lerQuartos() {
        List<Quarto> quartos = new ArrayList<>();

        try {
            File arquivo = new File("quartos.txt");

            if (arquivo.exists()) {
                Scanner scanner = new Scanner(arquivo);
                while (scanner.hasNextLine()) {
                    String linha = scanner.nextLine();
                    String[] dados = linha.split(",");
                    int id = Integer.parseInt(dados[0]);
                    String nomeQuarto = dados[1];
                    int qtdeCamas = Integer.parseInt(dados[2]);
                    boolean temBanheiro = Boolean.parseBoolean(dados[3]);
                    String descricao = dados[4];

                    Quarto quarto = new Quarto(id, nomeQuarto, qtdeCamas, temBanheiro, descricao);
                    quartos.add(quarto);
                }
                scanner.close();
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de quartos");
        }

        return quartos;
    }

    public static void listarQuartos() {
        List<Quarto> quartos = lerQuartos();

        if (quartos.isEmpty()) {
            System.out.println("Não há quartos cadastrados");
        } else {
            System.out.println("LISTA DE QUARTOS");
            for (Quarto quarto : quartos) {
                System.out.println("ID: " + quarto.getId());
                System.out.println("Nome do Quarto: " + quarto.getNomeQuarto());
                System.out.println("Quantidade de Camas: " + quarto.getQtdeCamas());
                System.out.println("Tem Banheiro: " + quarto.isTemBanheiro());
                System.out.println("Descrição: " + quarto.getDescricao());
                System.out.println("------------------------------");
            }
        }
    }
}
