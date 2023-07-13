package ReservaHotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.List;

public class ReservaMenu {
    private static Scanner scanner = new Scanner(System.in);

    public static void exibirMenuReserva() {
        boolean sair = false;
        
        while (!sair) 
        {
            System.out.println("\n--GERENCIAR RESERVAS--");
            System.out.println("1. Incluir Reserva");
            System.out.println("2. Alterar Reserva");
            System.out.println("3. Excluir Reserva");
            System.out.println("4. Listar Reservas");
            System.out.println("5. Voltar");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    incluirReserva();
                    break;
                case 2:
                    alterarReserva();
                    break;
                case 3:
                    excluirReserva();
                    break;
                case 4:
                    Reserva.listarReservas();
                    break;
                case 5:
                    return; 
                case 6:
                    sair = true; 
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        System.out.println("Encerrando o programa..."); 
        System.exit(0); 
    }


    public static void incluirReserva() {
        System.out.println("\nINSERIR DADOS DA RESERVA");

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("ID do Quarto: ");
        int idQuarto = scanner.nextInt();
        scanner.nextLine();

        System.out.print("ID da Cama: ");
        int idCama = scanner.nextInt();
        scanner.nextLine();

        System.out.print("ID do Cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Data de Entrada (Formato: dd/MM/yyyy): ");
        String dataEntradaInput = scanner.nextLine();
        LocalDate dataEntrada = LocalDate.parse(dataEntradaInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Data de Saída (Formato: dd/MM/yyyy): ");
        String dataSaidaInput = scanner.nextLine();
        LocalDate dataSaida = LocalDate.parse(dataSaidaInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Reserva reserva = new Reserva(id, idQuarto, idCama, idCliente, dataEntrada, dataSaida);
        reserva.salvar();

        System.out.println("\nReserva cadastrada com sucesso!");
    }

    public static void alterarReserva() {
        System.out.print("\nID da Reserva a ser alterada: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Reserva reserva = encontrarReservaPorId(id);

        if (reserva == null) 
        {
            System.out.println("\nReserva não encontrada.");
            return;
        }

        System.out.println("\nALTERAR DADOS DA RESERVA");

        System.out.print("ID do Quarto (" + reserva.getIdQuarto() + "): ");
        String idQuartoInput = scanner.nextLine();
        if (!idQuartoInput.isEmpty()) {
            int idQuarto = Integer.parseInt(idQuartoInput);
            reserva.setIdQuarto(idQuarto);
        }

        System.out.print("ID da Cama (" + reserva.getIdCama() + "): ");
        String idCamaInput = scanner.nextLine();
        
        if (!idCamaInput.isEmpty())
        {
            int idCama = Integer.parseInt(idCamaInput);
            reserva.setIdCama(idCama);
        }

        System.out.print("ID do Cliente (" + reserva.getIdCliente() + "): ");
        String idClienteInput = scanner.nextLine();
        
        if (!idClienteInput.isEmpty())
        {
            int idCliente = Integer.parseInt(idClienteInput);
            reserva.setIdCliente(idCliente);
        }

        System.out.print("Data de Entrada (" + reserva.getDataEntrada() + ", formato dd/MM/yyyy): ");
        String dataEntradaInput = scanner.nextLine();
        
        if (!dataEntradaInput.isEmpty()) 
        {
            LocalDate dataEntrada = LocalDate.parse(dataEntradaInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            reserva.setDataEntrada(dataEntrada);
        }

        System.out.print("Data de Saída (" + reserva.getDataSaida() + ", formato dd/MM/yyyy): ");
        String dataSaidaInput = scanner.nextLine();
        
        if (!dataSaidaInput.isEmpty())
        {
            LocalDate dataSaida = LocalDate.parse(dataSaidaInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            reserva.setDataSaida(dataSaida);
        }

        System.out.println("\nDados da reserva alterados com sucesso!");
    }

    public static void excluirReserva() {
        System.out.print("\nID da Reserva a ser excluída: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Reserva reserva = encontrarReservaPorId(id);

        if (reserva == null) 
        {
            System.out.println("\nReserva não encontrada.");
            return;
        }

        System.out.println("Tem certeza de que deseja excluir a reserva? (S/N)");
        String confirmacao = scanner.nextLine();

        if (confirmacao.equalsIgnoreCase("S"))
        {
            List<Reserva> reservas = Reserva.lerReservas();
            reservas.remove(reserva);

            Reserva.salvarReservas(reservas); 
            System.out.println("Reserva removida com sucesso!");
        }
        else 
        {
            System.out.println("Operação de exclusão cancelada.");
        }
    }


    public static Reserva encontrarReservaPorId(int id) {
        List<Reserva> reservas = Reserva.lerReservas();

        for (Reserva reserva : reservas) 
        {
            if (reserva.getId() == id)
            {
                return reserva;
            }
        }

        return null;
    }
}
