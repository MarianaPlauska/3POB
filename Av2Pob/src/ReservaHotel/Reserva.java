package ReservaHotel;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reserva {
    private int id;
    private int idQuarto;
    private int idCama;
    private int idCliente;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;

    public Reserva(int id, int idQuarto, int idCama, int idCliente, LocalDate dataEntrada, LocalDate dataSaida) {
        this.id = id;
        this.idQuarto = idQuarto;
        this.idCama = idCama;
        this.idCliente = idCliente;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
		this.id = id;
	}

	public void setIdQuarto(int idQuarto) {
		this.idQuarto = idQuarto;
	}

	public void setIdCama(int idCama) {
		this.idCama = idCama;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public int getIdQuarto() {
        return idQuarto;
    }

    public int getIdCama() {
        return idCama;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void salvar() {
        try 
        {
            FileWriter fw = new FileWriter("reservas.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            
            pw.println(id + "," + idQuarto + "," + idCama + "," + idCliente + "," +
                    dataEntrada.format(DateTimeFormatter.ISO_DATE) + "," +
                    dataSaida.format(DateTimeFormatter.ISO_DATE));
            pw.close();
        } 
        catch (IOException e) 
        {
            System.out.println("Erro ao salvar a reserva no arquivo");
        }
    }

    public static List<Reserva> lerReservas() {
        List<Reserva> reservas = new ArrayList<>();

        try {
            File arquivo = new File("reservas.txt");

            if (arquivo.exists())
            {
                Scanner scanner = new Scanner(arquivo);
                
                while (scanner.hasNextLine()) 
                {
                    String linha = scanner.nextLine();
                    String[] dados = linha.split(",");
                    int id = Integer.parseInt(dados[0]);
                    int idQuarto = Integer.parseInt(dados[1]);
                    int idCama = Integer.parseInt(dados[2]);
                    int idCliente = Integer.parseInt(dados[3]);
                    LocalDate dataEntrada = LocalDate.parse(dados[4], DateTimeFormatter.ISO_DATE);
                    LocalDate dataSaida = LocalDate.parse(dados[5], DateTimeFormatter.ISO_DATE);

                    Reserva reserva = new Reserva(id, idQuarto, idCama, idCliente, dataEntrada, dataSaida);
                    reservas.add(reserva);
                }
                scanner.close();
            }
        } 
        catch (IOException e) 
        {
            System.out.println("Erro ao ler o arquivo de reservas");
        }

        return reservas;
    }

    public static void listarReservas() {
        List<Reserva> reservas = lerReservas();

        if (reservas.isEmpty())
        {
            System.out.println("Não há reservas cadastradas");
        } 
        else
        {
            System.out.println("LISTA DE RESERVAS");
            
            for (Reserva reserva : reservas)
            {
                System.out.println("ID: " + reserva.getId());
                System.out.println("ID do Quarto: " + reserva.getIdQuarto());
                System.out.println("ID da Cama: " + reserva.getIdCama());
                System.out.println("ID do Cliente: " + reserva.getIdCliente());
                System.out.println("Data de Entrada: " + reserva.getDataEntrada());
                System.out.println("Data de Saída: " + reserva.getDataSaida());
                System.out.println("------------------------------");
            }
        }
    }
    
    public static void salvarReservas(List<Reserva> reservas) {
        try 
        {
            FileWriter fw = new FileWriter("reservas.txt");
            PrintWriter pw = new PrintWriter(fw);
            
            for (Reserva reserva : reservas)
            {
                pw.println(reserva.getId() + "," + reserva.getIdQuarto() + "," + reserva.getIdCama() + "," +
                        reserva.getIdCliente() + "," + reserva.getDataEntrada().format(DateTimeFormatter.ISO_DATE) + "," +
                        reserva.getDataSaida().format(DateTimeFormatter.ISO_DATE));
            }
            
            pw.close();
        } 
        catch (IOException e) 
        {
            System.out.println("Erro ao salvar as reservas no arquivo");
        }
    }
}

