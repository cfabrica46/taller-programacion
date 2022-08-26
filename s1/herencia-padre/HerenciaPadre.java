import java.util.Scanner;

public class HerenciaPadre {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		double herenciaTotal, herenciaTamara, herenciaJosue, herenciaCaleb, herenciaDaniel, herenciaDavid;

		System.out.println("Ingrese la cantidad que dejo el padre de herencia:");
		System.out.print("> ");
		herenciaTotal = input.nextDouble();

		input.close();

		herenciaJosue = herenciaTotal * 27 / 100;
		herenciaTamara = herenciaJosue * 85 / 100;
		herenciaDaniel = herenciaTotal * 25 / 100;
		herenciaCaleb = (herenciaJosue + herenciaDaniel) * 23 / 100;
		herenciaDavid = herenciaTotal - (herenciaTamara + herenciaJosue + herenciaCaleb + herenciaDaniel);

		System.out.println("Herencia de Tamara: S/." + herenciaTamara + " soles");
		System.out.println("Herencia de Josue: S/." + herenciaJosue + " soles");
		System.out.println("Herencia de Caleb: S/." + herenciaCaleb + " soles");
		System.out.println("Herencia de Daniel: S/." + herenciaDaniel + " soles");
		System.out.println("Herencia de David: S/." + herenciaDavid + " soles");

	}
}
