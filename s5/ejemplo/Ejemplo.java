import java.util.Scanner;

public class Ejemplo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int numeroBolo;

		System.out.println("Ingrese el numero del Bolo:");
		System.out.print("> ");
		numeroBolo = input.nextInt();

		input.close();

		if (numeroBolo >= 1 && numeroBolo <= 20) {

			System.out.println("Usted gano un lapicero");

		} else if (numeroBolo >= 21 && numeroBolo <= 40) {

			System.out.println("Usted gano un cuaderno de 100 hojas");

		} else if (numeroBolo >= 41 && numeroBolo <= 60) {

			System.out.println("Usted gano una caja de plumones");

		} else if (numeroBolo >= 61 && numeroBolo <= 80) {

			System.out.println("Usted gano un cuaderno espiral");

		} else if (numeroBolo >= 81 && numeroBolo <= 99) {

			System.out.println("Usted gano una agenda");

		} else if (numeroBolo == 100) {

			System.out.println("Usted gano una mochila");

		} else {

			System.out.println("Usted no gano nada");

		}

	}
}
