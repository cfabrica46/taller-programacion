import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int max, sum;

		sum = 0;

		System.out.print("Ingrese hasta que numero desea que se imprima: ");
		max = input.nextInt();

		input.close();

		System.out.println("---");

		for (int i = 0; i < max; i++) {
			System.out.println(i + 1);
			sum += i + 1;
		}

		System.out.print("La suma total es: " + sum);
	}
}
