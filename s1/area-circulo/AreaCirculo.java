import java.util.Scanner;

public class AreaCirculo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		double radio, area;

		System.out.println("Introduzca el radio del circulo:");
		System.out.print("> ");
		radio = input.nextFloat();

		area = Math.PI * Math.pow(radio, 2);

		System.out.println("El área del circulo es: " + area);

		input.close();
	}
}
