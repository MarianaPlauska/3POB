package ReservaHotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class ClienteMenu {
    private static Scanner scanner = new Scanner(System.in);

    public static void exibirMenuCliente() {
    	boolean sair = false;
    	
        while (!sair) 
        {
            System.out.println("\n--GERENCIAR CLIENTES--");
            System.out.println("1. Incluir Cliente");
            System.out.println("2. Alterar Cliente");
            System.out.println("3. Excluir Cliente");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Voltar");
            System.out.println("6. Sair");
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
                    return; 
                case 6:
                    sair = true; 
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        System.out.println("Encerrando o programa..."); // Mensagem exibida ao sair do loop
        System.exit(0);
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

        System.out.println("\nCliente cadastrado com sucesso!");
    }

    public static void alterarCliente() {
        System.out.print("\nID do Cliente a ser alterado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = encontrarClientePorId(id);

        if (cliente == null) 
        {
            System.out.println("\nCliente não encontrado.");
            return;
        }

        System.out.println("\nALTERAR DADOS DO CLIENTE");

        System.out.print("Nome (" + cliente.getNome() + "): ");
        String nome = scanner.nextLine();
        
        if (!nome.isEmpty())
        {
            cliente.setNome(nome);
        }

        System.out.print("Endereço (" + cliente.getEndereco() + "): ");
        String endereco = scanner.nextLine();
        
        if (!endereco.isEmpty()) 
        {
            cliente.setEndereco(endereco);
        }

        System.out.print("Código Postal (" + cliente.getPostalCod() + "): ");
        String postalCod = scanner.nextLine();
        
        if (!postalCod.isEmpty())
        {
            cliente.setPostalCod(postalCod);
        }

        System.out.print("País (" + cliente.getPais() + "): ");
        String pais = scanner.nextLine();
        
        if (!pais.isEmpty()) 
        {
            cliente.setPais(pais);
        }

        System.out.print("CPF (" + cliente.getCpf() + "): ");
        String cpf = scanner.nextLine();
        
        if (!cpf.isEmpty()) 
        {
            cliente.setCpf(cpf);
        }

        System.out.print("Passaporte (" + cliente.getPassaporte() + "): ");
        String passaporte = scanner.nextLine();
        
        if (!passaporte.isEmpty()) 
        {
            cliente.setPassaporte(passaporte);
        }

        System.out.print("E-mail (" + cliente.getEmail() + "): ");
        String email = scanner.nextLine();
        
        if (!email.isEmpty()) 
        {
            cliente.setEmail(email);
        }

        System.out.print("Data de Nascimento (" + cliente.getDataNasc() + ", formato dd/MM/yyyy): ");
        String dataNascInput = scanner.nextLine();
        
        if (!dataNascInput.isEmpty()) 
        {
            LocalDate dataNasc = LocalDate.parse(dataNascInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            cliente.setDataNasc(dataNasc);
        }

        System.out.println("\nDados do cliente alterados com sucesso!");
    }

    public static void excluirCliente() {
        System.out.print("\nID do Cliente a ser excluído: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        List<Cliente> clientes = Cliente.lerClientes();

        boolean clienteEncontrado = false;
        
        for (Cliente cliente : clientes) 
        {
            if (cliente.getId() == id) 
            {
                clienteEncontrado = true;
                break;
            }
        }

        if (clienteEncontrado)
        {
            clientes.removeIf(cliente -> cliente.getId() == id);

            try (FileWriter writer = new FileWriter("cliente.txt")) 
            {
                for (Cliente c : clientes) 
                {
                    writer.write(c.toString() + "\n");
                }
            } 
            catch (IOException e) 
            {
                System.out.println("Erro ao excluir o cliente do arquivo.");
                return;
            }

            System.out.println("\nCliente removido com sucesso!");
        } 
        else 
        {
            System.out.println("\nCliente não encontrado.");
            return;
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
