import java.util.Scanner;

public class RaizEcuacion {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		double a, b, c, resultadoPositivo, resultadoNegativo;

		System.out.println("Siendo la ecuacion: [ – b ± √( b2 – 4ac) ] / 2a");

		System.out.println("Introduzca el valor de 'a':");
		System.out.print("> ");
		a = input.nextFloat();

		System.out.println("Introduzca el valor de 'b':");
		System.out.print("> ");
		b = input.nextFloat();

		System.out.println("Introduzca el valor de 'c':");
		System.out.print("> ");
		c = input.nextFloat();

		input.close();

		resultadoPositivo = (-b + Math.sqrt(Math.pow(a, 2) - 4 * a * c)) / 2 * a;
		resultadoNegativo = (-b - Math.sqrt(Math.pow(a, 2) - 4 * a * c)) / 2 * a;

		System.out.println("Los resultados obtenidos serian los siguientes:");
		System.out.println("x1 = " + resultadoPositivo);
		System.out.println("x2 = " + resultadoNegativo);
	}
}
