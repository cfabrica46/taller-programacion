import java.util.Scanner;

public class IGVTotal {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		float ventas, igv;

		System.out.println("Ingrese el monto total de ventas: ");
		System.out.print("> ");
		ventas = input.nextFloat();

		input.close();

		igv = ventas * 18 / 100;

		System.out.println("El IGV es: S/" + igv);
	}
}
