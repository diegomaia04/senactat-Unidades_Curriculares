package banco;

public class Cliente {

	public static void main(String[] args) {
		/********************************************************
		 **** ACESSAR OS METODOS E VARIAVEIS DE OUTRA CLASSE ****
		 ********************************************************/
		Agencia agencia = new Agencia();
		agencia.metodoSimples();
		agencia.depositar(4000);

	}

}
