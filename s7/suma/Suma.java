import java.util.Scanner;

public class Suma {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int exitNumber;
		double sum, number;
		boolean exit = false;

		sum = 0;

		do {
			System.out.println("Ingrese un numero:");
			System.out.print("> ");
			number = input.nextDouble();

			sum = sum + number;

			System.out.println("Desea agregar otro numero?: [0/1]");
			System.out.print("> ");
			exitNumber = input.nextInt();

			if (exitNumber == 0) {
				exit = true;
			}

		} while (!exit);

		System.out.println("La suma total es: " + sum);

		input.close();
	}
}
