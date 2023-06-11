package cine;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		
		Filme filme = new Filme (1, "CasaBlanca", "US", 1954,90);
		filmes.add(filme);
		
		filme = new Filme(2, "E o vento Levou...", "US", 1955,110);
		filmes.add(filme);
		
		filme = new Filme(3, "Titanic", "US", 1990, 120);
		filmes.add(filme);
		
		filme = new Filme(4, "A cor Purpura", "US", 1940, 130);
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
		
		System.out.println("Filmes: ");
		
		filmes.forEach(x->System.out.println( x.getNome()));
		
		salas.forEach(x->System.out.println("\nSala: "+ x.getId()+ "\nQuantidade de fila: " + x.getFilas() + "\nQuantidade de cadeiras: " + x.getCadeirasPorFilas()));
		

	}

}
