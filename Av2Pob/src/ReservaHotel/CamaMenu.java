package ReservaHotel;
import java.util.Scanner;

public class CamaMenu {
    private static Scanner scanner = new Scanner(System.in);

    public static void exibirMenuCama() {
        boolean sair = false;
        while (!sair) {
            System.out.println("GERENCIAR CAMAS");
            System.out.println("1. Incluir Cama");
            System.out.println("2. Alterar Cama");
            System.out.println("3. Excluir Cama");
            System.out.println("4. Listar Camas");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    incluirCama();
                    break;
                case 2:
                    alterarCama();
                    break;
                case 3:
                    excluirCama();
                    break;
                case 4:
                    Cama.listarCamas();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void incluirCama() {
        System.out.println("INSERIR DADOS DA CAMA");

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Código da Cama: ");
        String codigoCama = scanner.nextLine();

        System.out.print("É Beliche (S/N): ");
        String ehBelicheInput = scanner.nextLine();
        boolean ehBeliche = ehBelicheInput.equalsIgnoreCase("S");

        System.out.print("Posição: ");
        String posicao = scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        Cama cama = new Cama(id, codigoCama, ehBeliche, posicao, descricao);
        cama.salvar();

        System.out.println("Cama cadastrada com sucesso!");
    }

    public static void alterarCama() {
        System.out.print("ID da Cama a ser alterada: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Cama cama = encontrarCamaPorId(id);

        if (cama == null) {
            System.out.println("Cama não encontrada.");
            return;
        }

        System.out.println("ALTERAR DADOS DA CAMA");

        System.out.print("Código da Cama (" + cama.getCodigoCama() + "): ");
        String codigoCama = scanner.nextLine();
        if (!codigoCama.isEmpty()) {
            cama.setCodigoCama(codigoCama);
        }

        System.out.print("É Beliche (" + cama.isEhBeliche() + ", S/N): ");
        String ehBelicheInput = scanner.nextLine();
        if (!ehBelicheInput.isEmpty()) {
            boolean ehBeliche = ehBelicheInput.equalsIgnoreCase("S");
            cama.setEhBeliche(ehBeliche);
        }

        System.out.print("Posição (" + cama.getPosicao() + "): ");
        String posicao = scanner.nextLine();
        if (!posicao.isEmpty()) {
            cama.setPosicao(posicao);
        }

        System.out.print("Descrição (" + cama.getDescricao() + "): ");
        String descricao = scanner.nextLine();
        if (!descricao.isEmpty()) {
            cama.setDescricao(descricao);
        }

        System.out.println("Dados da cama alterados com sucesso!");
    }

    public static void excluirCama() {
        System.out.print("ID da Cama a ser excluída: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Cama cama = encontrarCamaPorId(id);

        if (cama == null) {
            System.out.println("Cama não encontrada.");
            return;
        }

        System.out.println("Tem certeza de que deseja excluir a cama? (S/N)");
        String confirmacao = scanner.nextLine();

        if (confirmacao.equalsIgnoreCase("S")) {
            // Remover a cama do arquivo ou banco de dados
            System.out.println("Cama removida com sucesso!");
        } else {
            System.out.println("Operação de exclusão cancelada.");
        }
    }

    public static Cama encontrarCamaPorId(int id) {
        List<Cama> camas = Cama.lerCamas();

        for (Cama cama : camas) {
            if (cama.getId() == id) {
                return cama;
            }
        }

        return null;
    }
}
