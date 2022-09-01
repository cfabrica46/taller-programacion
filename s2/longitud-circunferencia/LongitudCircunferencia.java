import java.util.Scanner;

public class LongitudCircunferencia {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		double radio, longitud, area;

		System.out.println("Ingrese el radio:");
		System.out.print("> ");
		radio = input.nextDouble();

		input.close();

		longitud = 2 * Math.PI * radio;
		area = Math.PI * Math.pow(radio, 2);

		System.out.println("La longitud de la circunferencia es: " + longitud);
		System.out.println("El area del circulo es: " + area);
	}
}
