import java.util.Scanner;

public class PorcentajeGenero {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int nHombres, nMujeres, total;

		System.out.println("Ingrese el numero de hombres en el aula:");
		System.out.print("> ");
		nHombres = input.nextInt();

		System.out.println("Ingrese el numero de mujeres en el aula:");
		System.out.print("> ");
		nMujeres = input.nextInt();

		input.close();

		total = nHombres + nMujeres;

		System.out.println("El porcentaje de hombres es: " + (nHombres * 100 / total) + "%");
		System.out.println("El porcentaje de mujeres es: " + (nMujeres * 100 / total) + "%");
	}
}
