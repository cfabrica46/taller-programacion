import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int max;

		System.out.print("Ingrese desde que numero desea descender: ");
		max = input.nextInt();

		input.close();

		System.out.println("---");

		for (int i = max; i > 0; i = i - 2) {
			System.out.println(i);
		}

	}
}
