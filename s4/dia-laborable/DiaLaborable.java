import java.util.Scanner;

public class DiaLaborable {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int dia;

		System.out.println("Ingrese un numero entero correspondiente a un dia de la semana:");
		System.out.print("> ");
		dia = input.nextInt();

		switch (dia) {
			case 1:
				System.out.println("Es un dia laborable: Lunes");
				break;

			case 2:
				System.out.println("Es un dia laborable: Martes");
				break;

			case 3:
				System.out.println("Es un dia laborable: Miercoles");
				break;

			case 4:
				System.out.println("Es un dia laborable: Jueves");
				break;

			case 5:
				System.out.println("Es un dia laborable: Viernes");
				break;

			case 6:
				System.out.println("Es un dia NO laborable: Sabado");
				break;

			case 7:
				System.out.println("Es un dia NO laborable: Domingo");
				break;

			default:
				System.out.println("Dia no valido");
		}
	}
}
