//Exerc�cio de calculadora chamando m�todo de outras classes na main.
//Seno, Cosseno e Tangente

package ex2;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		double num1, num2,sub,soma,multi,div;
		int graus;
		double cosseno, seno, tangente;

		
		Scanner sc = new Scanner(System.in);
		
		Calculadora calc = new Calculadora();
		
		
		int op, continuar;
		
		do {
			System.out.println("____Calculadora___\n");
			System.out.println("\nEntre com o primeiro n�mero: ");
			num1 = sc.nextDouble();

			System.out.println("\n\n1-Soma\n2-Subtra��o\n3-Multiplica��o\n4-Divis�o\n5-Cosseno\n6-Seno\n7-Tangente");
			op = sc.nextInt();
					
			System.out.println("\nEntre com o segundo n�mero: ");
			num2 = sc.nextDouble();
			
			switch(op) {
				case 1:
					soma = calc.somar(num1,num2);
					
					System.out.println(soma);
				break;
				
				case 2:
					sub = calc.subtracao(num1,num2);
					
					System.out.println(sub);
				break;
				
				case 3:
					multi = calc.multiplicacao(num1,num2);
					
					System.out.println(multi);
				break;
				
				case 4:
					div = calc.divisao(num1,num2);
					
					System.out.println(div);
				break;

				case 5:
					System.out.println("Entre com o grau: ");
					graus = sc.nextInt();

					cosseno = calc.cosseno(graus);
					System.out.println("Cosseno de "+graus+" �: "+cosseno);
				break;

				case 6:
					System.out.println("Entre com o grau: ");
					graus = sc.nextInt();

					seno = calc.seno(graus);
					System.out.println("Seno de "+graus+" �: "+seno);
				break;
				case 7:
					System.out.println("Entre com o grau: ");
					graus = sc.nextInt();

					tangente = calc.tangente(graus);
					System.out.println("Tangente de "+graus+" �: "+tangente);
				break;
				
				
				
			}
			System.out.println("\nDeseja continuar?\n1-Para continuar\n2-Para sair");
			continuar = sc.nextInt();
		}while(continuar==1);
		
		sc.close();
	}

}