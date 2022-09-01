import java.util.Scanner;

public class Nacimiento {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int edad, nacimiento;

		System.out.println("Ingrese su edad:");
		System.out.print("> ");
		edad = input.nextInt();

		input.close();

		nacimiento = 2020 - edad;

		System.out.println("Su año de nacimiento es: " + nacimiento);
	}
}
