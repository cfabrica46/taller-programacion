import java.util.Scanner;

public class Promedio {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		double nota1, nota2, nota3, nota4, promedio;

		System.out.println("Ingrese la nota 1:");
		System.out.print("> ");
		nota1 = input.nextDouble();

		System.out.println("Ingrese la nota 2:");
		System.out.print("> ");
		nota2 = input.nextDouble();

		System.out.println("Ingrese la nota 3:");
		System.out.print("> ");
		nota3 = input.nextDouble();

		System.out.println("Ingrese la nota 4:");
		System.out.print("> ");
		nota4 = input.nextDouble();

		input.close();

		nota1 = nota1 * 0.20;
		nota2 = nota2 * 0.20;
		nota3 = nota3 * 0.30;
		nota4 = nota4 * 0.30;

		promedio = nota1 + nota2 + nota3 + nota4;

		System.out.println("El promedio total es: " + promedio);
	}
}
