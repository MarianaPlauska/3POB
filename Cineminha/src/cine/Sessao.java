package cine;

import java.time.LocalDateTime;

public class Sessao {
	private int id;
	private int idSala;
	private int idFilme;
	private LocalDateTime horario;
	
	public Sessao(int id, int idSala, int idFilme, LocalDateTime horario) {
		this.id = id;
		this.idSala = idSala;
		this.idFilme = idFilme;
		this.horario = horario;
	}

	public int getId() {
		return id;
	}

	public int getIdSala() {
		return idSala;
	}

	public int getIdFilme() {
		return idFilme;
	}

	public LocalDateTime getHorario() {
		return horario;
	}
	
	

}
