import java.util.Scanner;

public class MarcaPrecio {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String marca;
		double precio;

		System.out.println("Ingrese la marca del carro:");
		System.out.print("> ");
		marca = input.next();

		System.out.println("Ingrese el precio del carro:");
		System.out.print("> ");
		precio = input.nextDouble();

		input.close();

		System.out.println(marca);

		precio = (marca.toLowerCase().equals("toyota") ? precio * 94 / 100 : precio * 97 / 100);

		/*
		 * if (marca.toLowerCase().equals("toyota")) {
		 * precio = precio * 94 / 100;
		 * } else {
		 * precio = precio * 97 / 100;
		 * }
		 */

		System.out.println("El precio es: " + precio + " soles");
	}
}
