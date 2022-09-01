import java.util.Scanner;

public class Nombre {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String name;

		System.out.println("Ingrese su nombre:");
		System.out.print("> ");
		name = input.next();

		System.out.println("Tu nombre es: " + name);
	}
}
