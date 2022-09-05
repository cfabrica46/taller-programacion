import java.util.Scanner;

public class MarcaPrecio {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		double x, y;

		System.out.println("Ingrese el primer numero:");
		System.out.print("> ");
		x = input.nextDouble();

		System.out.println("Ingrese el segundo numero:");
		System.out.print("> ");
		y = input.nextDouble();

		if (x > y) {
			System.out.println("El numero mayor es el primero: " + x);
		} else {
			System.out.println("El numero mayor es el segundo: " + y);
		}
	}
}
