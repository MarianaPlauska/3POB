package exerc1;

public class Ex1 {
	public static void main(String[] args) {
		Aluno aluno = new Aluno("Vitoria", "160337", 830003);
		
		System.out.println("Aluno: " + aluno.getNome() + "\n" 
		+ "CPF: " + aluno.getCpf() + "\n" + "Matricula: " +aluno.getMatricula());
		
		aluno.setNome("Pedro");
		aluno.setCpf("02892");
		aluno.setMatricula(2829);
	
		System.out.println("\nAluno: " + aluno.getNome() + "\n" 
		+ "CPF: " + aluno.getCpf() + "\n" + "Matricula: " +aluno.getMatricula());
	
		Aluno aluno2 = new Aluno("Claudio", "6270", 9393);
		
		System.out.println("\nAluno: " + aluno2.getNome() + "\n" 
		+ "CPF: " + aluno2.getCpf() + "\n" + "Matricula: " +aluno2.getMatricula());
	}
}

