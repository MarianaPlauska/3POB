package ReservaHotel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cama {
    private int id;
    private String codigoCama;
    private boolean ehBeliche;
    private String posicao;
    private String descricao;

    public Cama(int id, String codigoCama, boolean ehBeliche, String posicao, String descricao) {
        this.id = id;
        this.codigoCama = codigoCama;
        this.ehBeliche = ehBeliche;
        this.posicao = posicao;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getCodigoCama() {
        return codigoCama;
    }

    public boolean isEhBeliche() {
        return ehBeliche;
    }

    public String getPosicao() {
        return posicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void salvar() {
        try {
            FileWriter fw = new FileWriter("camas.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(id + "," + codigoCama + "," + ehBeliche + "," + posicao + "," + descricao);
            pw.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar a cama no arquivo");
        }
    }

    public static List<Cama> lerCamas() {
        List<Cama> camas = new ArrayList<>();

        try {
            File arquivo = new File("camas.txt");

            if (arquivo.exists()) {
                Scanner scanner = new Scanner(arquivo);
                while (scanner.hasNextLine()) {
                    String linha = scanner.nextLine();
                    String[] dados = linha.split(",");
                    int id = Integer.parseInt(dados[0]);
                    String codigoCama = dados[1];
                    boolean ehBeliche = Boolean.parseBoolean(dados[2]);
                    String posicao = dados[3];
                    String descricao = dados[4];

                    Cama cama = new Cama(id, codigoCama, ehBeliche, posicao, descricao);
                    camas.add(cama);
                }
                scanner.close();
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de camas");
        }

        return camas;
    }

    public static void listarCamas() {
        List<Cama> camas = lerCamas();

        if (camas.isEmpty()) {
            System.out.println("Não há camas cadastradas");
        } else {
            System.out.println("LISTA DE CAMAS");
            for (Cama cama : camas) {
                System.out.println("ID: " + cama.getId());
                System.out.println("Código da Cama: " + cama.getCodigoCama());
                System.out.println("É Beliche: " + cama.isEhBeliche());
                System.out.println("Posição: " + cama.getPosicao());
                System.out.println("Descrição: " + cama.getDescricao());
                System.out.println("------------------------------");
            }
        }
    }
}
