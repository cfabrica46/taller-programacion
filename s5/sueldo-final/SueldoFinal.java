import java.util.Scanner;

public class SueldoFinal {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int añosDeServicio, horasTrabajadas;
		double sueldoFinal;

		System.out.println("Ingrese cuantos años de servicio brindó:");
		System.out.print("> ");
		añosDeServicio = input.nextInt();

		System.out.println("Ingrese cuantas horas trabajo en el mes:");
		System.out.print("> ");
		horasTrabajadas = input.nextInt();

		input.close();

		sueldoFinal = 30 * horasTrabajadas;

		System.out.println("El numero es menor a 10");
		if (añosDeServicio <= 5) {

			sueldoFinal = sueldoFinal * 160 / 100;

		} else if (añosDeServicio >= 6 && añosDeServicio <= 10) {

			sueldoFinal = sueldoFinal * 180 / 100;

		} else if (añosDeServicio >= 11) {

			sueldoFinal = sueldoFinal * 200 / 100;

		} else {
			System.out.println("Opcion invalida");
		}

		System.out.println("El sueldo final es: S/" + sueldoFinal);
	}
}
