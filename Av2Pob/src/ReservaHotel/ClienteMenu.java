package ReservaHotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ClienteMenu {
    private static Scanner scanner = new Scanner(System.in);

    public static void exibirMenuCliente() {
        boolean sair = false;
        while (!sair) {
            System.out.println("GERENCIAR CLIENTES");
            System.out.println("1. Incluir Cliente");
            System.out.println("2. Alterar Cliente");
            System.out.println("3. Excluir Cliente");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    incluirCliente();
                    break;
                case 2:
                    alterarCliente();
                    break;
                case 3:
                    excluirCliente();
                    break;
                case 4:
                    Cliente.listarClientes();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void incluirCliente() {
        System.out.println("\nINSERIR DADOS DO CLIENTE");

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Código Postal: ");
        String postalCod = scanner.nextLine();

        System.out.print("País: ");
        String pais = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Passaporte: ");
        String passaporte = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Data de Nascimento (Formato: dd/MM/yyyy): ");
        String dataNascInput = scanner.nextLine();
        LocalDate dataNasc = LocalDate.parse(dataNascInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Cliente cliente = new Cliente(id, nome, endereco, postalCod, pais, cpf, passaporte, email, dataNasc);
        cliente.salvar();

        System.out.println("Cliente cadastrado com sucesso!");
    }

    public static void alterarCliente() {
        System.out.print("ID do Cliente a ser alterado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = encontrarClientePorId(id);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.println("ALTERAR DADOS DO CLIENTE");

        System.out.print("Nome (" + cliente.getNome() + "): ");
        String nome = scanner.nextLine();
        if (!nome.isEmpty()) {
            cliente.setNome(nome);
        }

        System.out.print("Endereço (" + cliente.getEndereco() + "): ");
        String endereco = scanner.nextLine();
        if (!endereco.isEmpty()) {
            cliente.setEndereco(endereco);
        }

        System.out.print("Código Postal (" + cliente.getPostalCod() + "): ");
        String postalCod = scanner.nextLine();
        if (!postalCod.isEmpty()) {
            cliente.setPostalCod(postalCod);
        }

        System.out.print("País (" + cliente.getPais() + "): ");
        String pais = scanner.nextLine();
        if (!pais.isEmpty()) {
            cliente.setPais(pais);
        }

        System.out.print("CPF (" + cliente.getCpf() + "): ");
        String cpf = scanner.nextLine();
        if (!cpf.isEmpty()) {
            cliente.setCpf(cpf);
        }

        System.out.print("Passaporte (" + cliente.getPassaporte() + "): ");
        String passaporte = scanner.nextLine();
        if (!passaporte.isEmpty()) {
            cliente.setPassaporte(passaporte);
        }

        System.out.print("E-mail (" + cliente.getEmail() + "): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) {
            cliente.setEmail(email);
        }

        System.out.print("Data de Nascimento (" + cliente.getDataNasc() + ", formato dd/MM/yyyy): ");
        String dataNascInput = scanner.nextLine();
        if (!dataNascInput.isEmpty()) {
            LocalDate dataNasc = LocalDate.parse(dataNascInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            cliente.setDataNasc(dataNasc);
        }

        System.out.println("Dados do cliente alterados com sucesso!");
    }

    public static void excluirCliente() {
        System.out.print("ID do Cliente a ser excluído: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = encontrarClientePorId(id);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.println("Tem certeza de que deseja excluir o cliente? (S/N)");
        String confirmacao = scanner.nextLine();

        if (confirmacao.equalsIgnoreCase("S")) {
            // Remover o cliente do arquivo ou banco de dados
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Operação de exclusão cancelada.");
        }
    }

    public static Cliente encontrarClientePorId(int id) {
        List<Cliente> clientes = Cliente.lerClientes();

        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }

        return null;
    }
}
