import java.util.Scanner;

public class MayorMenor {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int number;

		System.out.println("Ingrese un numero:");
		System.out.print("> ");
		number = input.nextInt();

		input.close();

		if (number < 10) {
			System.out.println("El numero es menor a 10");
		} else if (number > 10) {
			System.out.println("El numero es mayor a 10");
		} else {
			System.out.println("El numero es 10");
		}
	}
}
