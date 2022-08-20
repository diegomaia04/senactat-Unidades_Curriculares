package banco;

public class Agencia {
	/*******************
	 **** VARIAVEIS ****
	 *******************/
	public double saldo = 2000;

	/************************
	 **** METODO SIMPLES ****
	 ************************/
	public void metodoSimples() {
		System.out.println("===============");
		System.out.println("Banco do Brasil");
		System.out.println("Ag�ncia Tatuap�");
		System.out.println("===============");
	}

	/*******************************************
	 **** METODO COM PASSAGEM DE PARAMETROS ****
	 *******************************************/
	public void depositar(double valor) {
		saldo += valor;
		System.out.println("Saldo: " + saldo);

	}
}
