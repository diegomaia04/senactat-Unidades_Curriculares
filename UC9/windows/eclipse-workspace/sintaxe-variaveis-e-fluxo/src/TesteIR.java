
public class TesteIR {
	public static void main(String[] args) {
		double salario = 4000.0;
		if (salario >= 1900.0 && salario <= 2800) {
			System.out.println("O IR é de 7.5%");
			System.out.println("Pode deduzir na declaração o valor de R$142,00");
		} else if (salario > 2800.0 && salario <= 3751.0) {
			System.out.println("O IR é de 15%");
			System.out.println("Pode deduzir na declaração o valor de R$350,00");
		} else if (salario > 3751.0 && salario <= 4664.0) {
			System.out.println("O IR é de 22.5%");
			System.out.println("Pode deduzir na declaração o valor de R$636,00");
		}
	}

}
