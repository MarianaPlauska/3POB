package exerc1;

	public class Ex1 {
		public static void main(String[] args) {
			
			public class Aluno {
				String nome;
				String cpf;
				int matricula;
				
				public String getNome() {
					return nome;
				}
				public void setNome(String nome) {
					this.nome = nome;
				}
				public String getCpf() {
					return cpf;
				}
				public void setCpf(String cpf) {
					this.cpf = cpf;
				}
				public int getMatricula() {
					return matricula;
				}
				public void setMatricula(int matricula) {
					this.matricula = matricula;
				}
				
				public Aluno(String nome, String cpf, int matricula) {
					super();
					this.nome = nome;
					this.cpf = cpf;
					this.matricula = matricula;
				}
		}

	}

}
