//Exerc�cio de calculadora chamando m�todo de outras classes na main.
package ex2;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		double num1, num2,sub,soma,multi,div;
		
		Scanner sc = new Scanner(System.in);
		
		Calculadora calc = new Calculadora();
		
		
		int op, continuar;
		
		do {
			System.out.println("____Calculadora___\n");
			System.out.println("1-Soma\n2-Subtra��o\n3-Multiplica��o\n4-Divis�o");
			op = sc.nextInt();
			
			switch(op) {
				case 1:
					System.out.println("\nEntre com o primeiro n�mero: ");
					num1 = sc.nextDouble();
					
					System.out.println("\nEntre com o segundo n�mero: ");
					num2 = sc.nextDouble();
					
					soma = calc.somar(num1,num2);
					
					System.out.println(soma);
				break;
				
				case 2:
					System.out.println("\nEntre com o primeiro n�mero: ");
					num1 = sc.nextInt();
					
					System.out.println("\nEntre com o segundo n�mero: ");
					num2 = sc.nextInt();
					
					sub = calc.subtracao(num1,num2);
					
					System.out.println(sub);
				break;
				
				case 3:
					System.out.println("\nEntre com o primeiro n�mero: ");
					num1 = sc.nextInt();
					
					System.out.println("\nEntre com o segundo n�mero: ");
					num2 = sc.nextInt();
					
					multi = calc.multiplicacao(num1,num2);
					
					System.out.println(multi);
				break;
				
				case 4:
					System.out.println("\nEntre com o primeiro n�mero: ");
					num1 = sc.nextInt();
					
					System.out.println("\nEntre com o segundo n�mero: ");
					num2 = sc.nextInt();
					
					div = calc.divisao(num1,num2);
					
					System.out.println(div);
				break;
				
				
			}
			System.out.println("\nDeseja continuar?\n1-Para continuar\n2-Para sair");
			continuar = sc.nextInt();
		}while(continuar==1);
		
		sc.close();
	}

}
