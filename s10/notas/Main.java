import java.util.Scanner;

		// Nombre: César Fabricio Caycho Avila
		// CODIGO: U21311144

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int limit, notaBuscar;
		int count = 0;

		System.out.print("Cuantas notas desea ingresar: ");
		limit = input.nextInt();

		int[] notas = new int[limit];

		for (int i = 0; i < limit; i++) {
			int nota;

			System.out.print("Ingrese la nota: ");
			nota = input.nextInt();

			notas[i]=nota;
		}
	
		System.out.print("Que nota desea buscar: ");
		notaBuscar = input.nextInt();

		input.close();


		for (int i = 0; i < limit; i++) {
			if (notas[i] == notaBuscar) {
				count++;
			}
		}

		System.out.print("La nota (" + notaBuscar + ") se repite (" + count + ") veces");
	}
}
