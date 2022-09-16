import java.util.Scanner;

public class TarifaParking {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int horas, monto;

		System.out.println("Cuantas horas han pasado desde que llego al parking?");
		System.out.print("> ");
		horas = input.nextInt();

		if (horas <= 2) {
			monto = horas * 5;
			System.out.println("El monto a pagar es: S/" + monto);
		}

		if (horas <= 5) {
			monto = (2 * 5) + (horas - 2) * 4;
			System.out.println("El monto a pagar es: S/" + monto);
		}

		if (horas <= 10) {
			monto = (2 * 5) + (3 * 4) + (horas - 5) * 3;
			System.out.println("El monto a pagar es: S/" + monto);
		}

		if (horas > 10) {
			monto = (2 * 5) + (3 * 4) + (5 * 3) + (horas - 10) * 2;
			System.out.println("El monto a pagar es: S/" + monto);
		}
	}
}
