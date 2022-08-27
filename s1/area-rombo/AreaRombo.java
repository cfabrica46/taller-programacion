import java.util.Scanner;

public class AreaRombo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		double diagonal1, diagonal2, area;

		System.out.println("Ingrese el valor de la primera diagonal:");
		System.out.print("> ");
		diagonal1 = input.nextDouble();

		System.out.println("Ingrese el valor de la segunda diagonal:");
		System.out.print("> ");
		diagonal2 = input.nextDouble();

		area = diagonal1 * diagonal2 / 2;

		System.out.println("El area del rombo es: " + area);
	}
}
