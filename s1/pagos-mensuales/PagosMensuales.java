public class PagosMensuales {
	public static void main(String[] args) {

		double agua, luz, cable, internet, telefono, total;

		agua = 90.00;
		luz = 65.00;
		cable = 45.00;
		internet = 90.00;
		telefono = 45.00;

		System.out.println("El papa de María tiene los siguientes gastos mensuales:");
		System.out.println("Agua: S/." + agua + " soles");
		System.out.println("Luz: S/." + luz + " soles");
		System.out.println("Cable: S/." + cable + " soles");
		System.out.println("Internet: S/." + internet + " soles");
		System.out.println("Teléfono: S/." + telefono + " soles");

		total = agua + luz + cable + internet + telefono;

		System.out.println("El total a pagar seria: S/." + total + " soles");
	}
}
