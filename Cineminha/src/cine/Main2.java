package cine;

import java.time.LocalDateTime;
import java.util.*;

public class Main2 {
	public static void main(String[] args) {
		//Filmes:
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		
		Filme filme = new Filme (1, "\tCasaBlanca", "US", 1954,90);
		filmes.add(filme);
		
		filme = new Filme(2, "\tE o vento Levou...", "US", 1955,110);
		filmes.add(filme);
		
		filme = new Filme(3, "\tTitanic", "US", 1990, 120);
		filmes.add(filme);
		
		filme = new Filme(4, "\tA cor Purpura", "US", 1940, 130);
		filmes.add(filme);
		
		//salas
		
		ArrayList<Sala> salas = new ArrayList<Sala>();
		Sala sala = new Sala(1,4,5);
		salas.add(sala);
		
		sala = new Sala(2,4,5);
		salas.add(sala);
		
		sala = new Sala(3,4,5);
		salas.add(sala);
		
		sala = new Sala(4,4,5);
		salas.add(sala);
		
		//sessões
		
		ArrayList<Sessao> sessoes = new ArrayList<Sessao>();
		Sessao sessao = new Sessao (1, 1, 1, LocalDateTime.now());
		sessoes.add(sessao);
		
		sessao = new Sessao(2,2,2,LocalDateTime.now().plusMinutes(120));
		sessoes.add(sessao);
		
		sessao = new Sessao(3,3,2,LocalDateTime.now().plusMinutes(240));
		sessoes.add(sessao);
		
		sessao = new Sessao(4,4,4,LocalDateTime.now().plusMinutes(360));
		sessoes.add(sessao);
		
		System.out.println("\tFilmes: ");
		
		//exibe os filmes:
		filmes.forEach(x->System.out.println(x.getNome()));
		salas.forEach(x->System.out.println("\nSala: "+ x.getId()+ "\nQuantidade de fila: " + x.getFilas() + "\nQuantidade de cadeiras: " + x.getCadeirasPorFilas()));
		

		System.out.println("\n");
		
		//Menu:
		Scanner sc = new Scanner(System.in);
		
		int [][] matriz = new int[5][5];
		int fileira, poltrona,op, opcao, i, j, cont=0;
		boolean sair = false;
		
		//Escolher o filme
		
		System.out.println("Escolha o filme: ");
		op = sc.nextInt();
		
		switch (op)
		{
		case 1:
			System.out.println("CasaBlanca");
			break;
		case 2:
			System.out.println("E o vento levou...");
			break;
		case 3:
			System.out.println("Titanic");
			break;
		case 4:
			System.out.println("A cor púrpura");
			break;
		}
		if (cont==5)
		{
			System.out.println("Sala cheia!");
		}
		
		
		//i- fileira j - poltrona
		
		while(!sair) {
			System.out.println("\n");
			System.out.println("\t===CineMari===");
			System.out.println("\t1- Mostrar mapa de assento");
			System.out.println("\t2- Reservar assento");
			System.out.println("\t3- Cancelar assento");
			System.out.println("\t4- Sair");
			System.out.println("\t===Digite a opcao desejada: ");
			opcao = sc.nextInt();
			
			switch (opcao) 
			{
			case 1:
				System.out.println("Mapa de ocupação: ");
				
				for (i=0; i<matriz.length;i++) 
				{
					for (j=0; j<matriz[i].length; j++) 
					{
						System.out.println(matriz[i][j] + " ");
						
					}
					System.out.println();
				}
				System.out.println("Lugares ocupados: " + cont);
				break;
			case 2:
				System.out.println("Digite a fileira desejada: ");
				fileira = sc.nextInt();
				
				System.out.println("Digite a poltrona desejada: ");
				poltrona = sc.nextInt();
				
				if (matriz[fileira][poltrona]==0)
				{
					matriz[fileira][poltrona]= 1;
					cont++;
					
					System.out.println("Reserva efetuada com sucesso!");
				}
				else
				{
					System.out.println("Assento já reservado x(");
				}
				break;
			case 3:
				System.out.println("Digite a fileira desejada: ");
				fileira = sc.nextInt();
				
				System.out.println("Digite a poltrona desejada: ");
				poltrona = sc.nextInt();
				
				if(matriz[fileira][poltrona]==1)
				{
					matriz[fileira][poltrona]=0;
					cont--;
					
					System.out.println("Reserva cancelada com sucesso!");
				}
				else
				{
					System.out.println("Assento não reservado");
				}
				break;
			case 4:
				sair = true;
				System.out.println("Bye!");
				break;
			default:
				System.out.println("Opção inválida");
			}
		}
	}


}
