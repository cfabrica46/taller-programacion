import java.util.Scanner;

public class Promedio {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String exit = "s";

		double nota1, nota2, promedio;

		do {
			// System.out.println(exit);

			System.out.println("--- Nuevo Alumno ---");
			System.out.println("");

			System.out.println("Ingrese la nota de la PC1:");
			System.out.print("> ");
			nota1 = input.nextDouble();

			System.out.println("");

			System.out.println("Ingrese la nota de la PC2:");
			System.out.print("> ");
			nota2 = input.nextDouble();

			promedio = (nota1 + nota2) / 2;

			System.out.println("");

			System.out.println("El promedio entre las 2 PC es: " + promedio);

			System.out.println("");

			System.out.println("Desea continuar?: [s/n]");
			System.out.print("> ");
			exit = input.next();

		} while (exit.equals("s"));
		input.close();

		System.out.println("");
		System.out.println("Fin de registro de notas");
	}
}
