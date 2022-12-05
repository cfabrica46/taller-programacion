import java.util.Scanner;
		// Nombre: César Fabricio Caycho Avila
		// CODIGO: U21311144

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int count = 0;
		int sum = 0;
		int media;
		String exit;

		do{
			int num;

			System.out.print("Ingrese un numero: ");
			num = input.nextInt();

			count++;
			sum += num;

			System.out.println("Ha introducido " + count + " numero(s) la suma es: " + sum);

			System.out.print("Si desea no ingresar mas numeros escriba 'n': ");
			exit = input.next();
			
		}while (!"n".equals(exit));
	
		input.close();

		media = sum/count;

		System.out.print("La media aritmetica final es: "+ media);
	}
}
