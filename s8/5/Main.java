import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int nNumeros;

		System.out.print("Ingrese la cantidad de numeros impares: ");
		nNumeros = input.nextInt();

		input.close();

		System.out.println("---");

		for (int i = 0; i < nNumeros * 2; i = i + 2) {
			System.out.println(i + 1);
		}

	}
}
