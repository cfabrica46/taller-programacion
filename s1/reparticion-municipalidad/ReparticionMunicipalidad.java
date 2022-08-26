import java.util.Scanner;

public class ReparticionMunicipalidad {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		double avMar, av28, avBolivar, avClement, avSucre, montoTotal;

		System.out.println("Ingrese el monto a invertir:");
		System.out.print("> ");
		montoTotal = input.nextDouble();

		input.close();

		av28 = montoTotal * 25 / 100;
		avClement = montoTotal * 15 / 100;
		avBolivar = (av28 + avClement) * 10 / 100;
		avMar = avBolivar * 35 / 100;
		avSucre = montoTotal - (avMar + av28 + avBolivar + avClement);

		System.out.println("Monto Av. La Mar: S/." + avMar + " soles");
		System.out.println("Monto Av. 28 de Julio: S/." + av28 + " soles");
		System.out.println("Monto Av. Bolivar: S/." + avBolivar + " soles");
		System.out.println("Monto Av. Clement: S/." + avClement + " soles");
		System.out.println("Monto Av. Sucre: S/." + avSucre + " soles");

	}
}
