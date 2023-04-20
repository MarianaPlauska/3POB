package triangulo;

import java.util.*;

public class Triangulo {
	public double a;
	public double b;
	public double c;
	
	public double CalculaArea() {
		double p = (a+b+c)/2;
		return Math.sqrt(p *(p-a) * (p-b) * (p-c));
		
	}
}
