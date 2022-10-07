import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int nPersonas, nMayores, nMenores, edad;

		nMayores = 0;
		nMenores = 0;

		System.out.print("Ingrese el numero de personas que se registraran: ");
		nPersonas = input.nextInt();

		System.out.println("---");

		for (int i = 0; i < nPersonas; i++) {
			System.out.print("Ingrese la edad de la persona n° " + (i + 1) + ": ");
			edad = input.nextInt();

			if (edad < 18) {
				nMenores++;
			} else {
				nMayores++;
			}
		}

		input.close();

		System.out.println("N° Personas mayores de edad: " + nMayores);
		System.out.println("N° Personas menores de edad: " + nMenores);
	}
}
