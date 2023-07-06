package ReservaHotel;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean sair = false;
        while (!sair) {
            System.out.println("MENU PRINCIPAL");
            System.out.println("1. Gerenciar Clientes");
            System.out.println("2. Gerenciar Quartos");
            System.out.println("3. Gerenciar Camas");
            System.out.println("4. Gerenciar Reservas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    ClienteMenu.exibirMenuCliente();
                    break;
                case 2:
                    QuartoMenu.exibirMenuQuarto();
                    break;
                case 3:
                    CamaMenu.exibirMenuCama();
                    break;
                case 4:
                    ReservaMenu.exibirMenuReserva();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
        System.out.println("...");
    }
}
