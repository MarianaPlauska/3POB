package cine;

public class Filme {
	
	private int id;
	private String nome;
	private String pais;
	private int ano;
	private int duracao;
	
	public Filme(int id, String nome, String pais, int ano, int duracao) {
		this.id = id;
		this.nome = nome;
		this.pais = pais;
		this.ano = ano;
		this.duracao = duracao;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getPais() {
		return pais;
	}

	public int getAno() {
		return ano;
	}

	public int getDuracao() {
		return duracao;
	}

}
