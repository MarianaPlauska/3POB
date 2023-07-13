package ReservaHotel;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class QuartoMenu {
    private static Scanner scanner = new Scanner(System.in);

    public static void exibirMenuQuarto() {
    	boolean sair= false;
    	
        while (!sair) 
        {
            System.out.println("\n--GERENCIAR QUARTOS--");
            System.out.println("1. Incluir Quarto");
            System.out.println("2. Alterar Quarto");
            System.out.println("3. Excluir Quarto");
            System.out.println("4. Listar Quartos");
            System.out.println("5. Voltar");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    incluirQuarto();
                    break;
                case 2:
                    alterarQuarto();
                    break;
                case 3:
                    excluirQuarto();
                    break;
                case 4:
                    Quarto.listarQuartos();
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


    public static void incluirQuarto() {
        System.out.println("\nINSERIR DADOS DO QUARTO");

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome do Quarto: ");
        String nomeQuarto = scanner.nextLine();

        System.out.print("Quantidade de Camas: ");
        int qtdeCamas = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Tem Banheiro (S/N): ");
        String temBanheiroInput = scanner.nextLine();
        boolean temBanheiro = temBanheiroInput.equalsIgnoreCase("S");

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        Quarto quarto = new Quarto(id, nomeQuarto, qtdeCamas, temBanheiro, descricao);
        quarto.salvar();

        System.out.println("\nQuarto cadastrado com sucesso!");
    }

    public static void alterarQuarto() {
        System.out.print("\nID do Quarto a ser alterado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Quarto quarto = encontrarQuartoPorId(id);

        if (quarto == null) 
        {
            System.out.println("\nQuarto não encontrado.");
            return;
        }

        System.out.println("\nALTERAR DADOS DO QUARTO");

        System.out.print("Nome do Quarto (" + quarto.getNomeQuarto() + "): ");
        String nomeQuarto = scanner.nextLine();
        
        if (!nomeQuarto.isEmpty()) 
        {
            quarto.setNomeQuarto(nomeQuarto);
        }

        System.out.print("Quantidade de Camas (" + quarto.getQtdeCamas() + "): ");
        String qtdeCamasInput = scanner.nextLine();
        
        if (!qtdeCamasInput.isEmpty())
        {
            int qtdeCamas = Integer.parseInt(qtdeCamasInput);
            quarto.setQtdeCamas(qtdeCamas);
        }

        System.out.print("Tem Banheiro (" + quarto.isTemBanheiro() + ", S/N): ");
        String temBanheiroInput = scanner.nextLine();
        
        if (!temBanheiroInput.isEmpty())
        {
            boolean temBanheiro = temBanheiroInput.equalsIgnoreCase("S");
            quarto.setTemBanheiro(temBanheiro);
        }

        System.out.print("Descrição (" + quarto.getDescricao() + "): ");
        String descricao = scanner.nextLine();
        
        if (!descricao.isEmpty())
        {
            quarto.setDescricao(descricao);
        }

        System.out.println("\nDados do quarto alterados com sucesso!");
    }

    public static void excluirQuarto() 
    {
    	int id = scanner.nextInt();
    	
        System.out.print("\nID do Quarto a ser excluído: ");
        scanner.nextLine();
        
        Quarto quarto = encontrarQuartoPorId(id);

        if (quarto == null) 
        {
            System.out.println("\nQuarto não encontrado.");
            return;
        }

        System.out.println("Tem certeza de que deseja excluir o quarto? (S/N)");
        String confirmacao = scanner.nextLine();

        if (confirmacao.equalsIgnoreCase("S")) 
        {
            List<Quarto> quartos = Quarto.lerQuartos();
            quartos.remove(quarto);

            try (FileWriter writer = new FileWriter("quarto.txt"))
            {
                for (Quarto q : quartos) 
                {
                    writer.write(q.toString() + "\n");
                }
            } 
            catch (IOException e)
            {
                System.out.println("Erro ao excluir o quarto do arquivo.");
                return;
            }

            System.out.println("\nQuarto removido com sucesso!");
        } 
        else
        {
            System.out.println("\nOperação de exclusão cancelada.");
        }
    }


    public static Quarto encontrarQuartoPorId(int id) {
        List<Quarto> quartos = Quarto.lerQuartos();

        for (Quarto quarto : quartos) 
        {
            if (quarto.getId() == id)
            {
                return quarto;
            }
        }

        return null;
    }
}
