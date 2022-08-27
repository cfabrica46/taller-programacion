import java.util.Scanner;

public class ConvertirTemperatura {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		double gradosCentigrados, gradosFahrenheit, gradosKelvin, gradosRankine;

		System.out.println("Ingrese la temperatura en grados centigrados:");
		System.out.print("> ");
		gradosCentigrados = input.nextDouble();

		input.close();

		gradosFahrenheit = (gradosCentigrados * 9 / 5) + 32;
		gradosKelvin = gradosCentigrados + 273.15;
		gradosRankine = (gradosCentigrados * 9 / 5) + 491.67;

		System.out.println("Grados Centigrados:" + gradosCentigrados);
		System.out.println("Grados Fahrenheit:" + gradosFahrenheit);
		System.out.println("Grados Kelvin:" + gradosKelvin);
		System.out.println("Grados Rankine:" + gradosRankine);
	}
}
