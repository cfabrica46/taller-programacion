import java.util.Scanner;

public class PagoTotal {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		double nHoras, costoHoras, pagoTotal;

		System.out.println("Ingrese el numero de horas trabajadas:");
		System.out.print("> ");
		nHoras = input.nextDouble();

		System.out.println("Ingrese el costo de su hora:");
		System.out.print("> ");
		costoHoras = input.nextDouble();

		pagoTotal = nHoras * costoHoras;

		System.out.println("El pago total es: " + pagoTotal + " soles");
	}
}
