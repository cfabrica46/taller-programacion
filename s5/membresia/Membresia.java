import java.util.Scanner;

public class Membresia {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int type, age;
		double precio;

		System.out.println("Ingrese el tipo de cliente que es usted:");
		System.out.println("1. Ocasional");
		System.out.println("2. Regular");
		System.out.println("3. Exclusivo");
		System.out.print("> ");
		type = input.nextInt();

		switch (type) {
			case 1:
				precio = 50 * 105 / 100;

				break;
			case 2:
				precio = 75 * 107 / 100;

				break;
			case 3:
				precio = 100 * 109 / 100;

				break;
			default:
				System.out.println("Opcion invalida");
				input.close();
				return;
		}

		System.out.println("Ingrese su edad:");
		System.out.print("> ");
		age = input.nextInt();

		input.close();

		if (age > 60) {
			precio = precio * 98 / 100;
		}

		System.out.println("El pago mensual es: S/" + precio);
	}
}
