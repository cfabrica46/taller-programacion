import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int nPersonas;
		int sumaEdades = 0;

		int edadMayor = 0;
		int nPrimaria = 0;
		int nSecundaria = 0;
		int nSuperior = 0;

		int gradoMax = 3;
		int gradoMin = 1;

		int edadMax = 15;
		int edadMin = 80;

		System.out.print("Ingrese el numero de Personas: ");
		nPersonas = input.nextInt();

		input.close();

		System.out.println("---");

		for (int i = 0; i < nPersonas; i++) {
			int grado = (int) Math.floor(Math.random() * (gradoMax - gradoMin + 1) + gradoMin);
			int edad = (int) Math.floor(Math.random() * (edadMax - edadMin + 1) + edadMin);

			sumaEdades += edad;

			if (edad > edadMayor) {
				edadMayor = edad;
			}

			switch (grado) {
				case 1:
					nPrimaria++;
					break;
				case 2:
					nSecundaria++;
					break;
				case 3:
					nSuperior++;
					break;
			}

			System.out.println("grado: " + grado);
			System.out.println("edad: " + edad);
			System.out.println("---");
		}

		System.out.println("El promedio de edades es: " + sumaEdades / nPersonas);
		System.out.println("La edad Mayor es: " + edadMayor);
		System.out.println("Cantidad de personas con Primaria: " + nPrimaria);
		System.out.println("Cantidad de personas con Secundaria: " + nSecundaria);
		System.out.println("Cantidad de personas con Superior: " + nSuperior);

	}
}
