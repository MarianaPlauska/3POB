package cine;

public class Sala {
	private int id;
	private int filas;
	private int cadeirasPorFilas;
	
	public Sala(int id, int filas, int cadeirasPorFilas) {
		this.id = id;
		this.filas = filas;
		this.cadeirasPorFilas = cadeirasPorFilas;
	}

	public int getId() {
		return id;
	}

	public int getFilas() {
		return filas;
	}

	public int getCadeirasPorFilas() {
		return cadeirasPorFilas;
	}
	
	

}
