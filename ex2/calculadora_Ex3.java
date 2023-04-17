package ex2;

public class Calculadora {
	
	public double somar (double a, double b) {
		//int soma;
		
		//soma=a+b;
		
		//System.out.println("A soma �: " +soma);
		return a+b;
		
	}
	
	public double subtracao(double a, double b) {
		
		return a-b;
	}
	
	public double multiplicacao(double a, double b) {
		
		return a*b;
	}
	
	public double divisao(double a, double b) {
		
		return a/b;
	}
	//seno, cosseno e tangente
	public double seno(double a) {
		
		return Math.sin(a);
	}
	//cosseno
	public double cosseno(double a) {
		
		return Math.cos(a);
	}
	//tangente
	public double tangente(double a) {
		
		return Math.tan(a);
	}
}