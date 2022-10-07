import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int nMenor, nMayor;

		System.out.print("Ingrese el numero menor: ");
		nMenor = input.nextInt();

		System.out.print("Ingrese el numero mayor: ");
		nMayor = input.nextInt();

		input.close();

		System.out.println("---");

		for (int i = nMenor; i <= nMayor; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}

	}
}
