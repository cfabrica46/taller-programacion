import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Nombre: César Fabricio Caycho Avila
		// CODIGO: U21311144

		int nEstudiantes;

		System.out.print("Ingrese el numero de estudiantes que desea registrar: ");
		nEstudiantes = input.nextInt();

		String estudiantes[] = new String[nEstudiantes];

		for (int i = 0; i < nEstudiantes; i++) {
			String nombre,apellido;

			System.out.print("Nombre del estudiante: ");
			nombre = input.next();
			
			estudiantes[i] = nombre;

			System.out.print("Apellido del estudiante: ");
			apellido = input.next();

			estudiantes[i] = estudiantes[i]+" "+apellido;
		}

		input.close();

		System.out.println("---");


		for (int i = 0; i < nEstudiantes; i++) {
			System.out.println(i + " " + estudiantes[i]);
		}
	}
}
