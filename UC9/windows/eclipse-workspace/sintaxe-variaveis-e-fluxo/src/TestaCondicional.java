
public class TestaCondicional {
	public static void main (String[] args) {
		System.out.println("testando condicionais");
		int idade = 16;
		int quantidadePessoas = 2;
		if (idade >= 18) {
			System.out.println("Maior de idade");
			System.out.println("Seja bem vindo");
		} else if (quantidadePessoas >= 2){
			System.out.println("Menor de idade, mas acompanhado");
			System.out.println("Pode entrar");
		} else {
			System.out.println("Não pode entrar");
		}
	}

}
