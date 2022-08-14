/**
 * Fundamentos do Java
 * Números Aleatórios
 */
package fundamentos;

import java.util.Scanner;
import java.util.Random;

/**
 * @author Fagner Geraldes Braga
 *
 */
public class NumerosAleatorios {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// As linhas abaixo geram n�meros aleat�rios
		// O zero sempre � considerado

		char novoJogo = 'n';
		Scanner teclado = new Scanner(System.in);
		do {
			Random random = new Random();
			int face = random.nextInt(6) + 1;
			System.out.println("====== JOGO de DADO ======");
			System.out.println("Face do dado: " + face);
			System.out.println("Jogar novamente (s/n) ?");
			System.out.println("");
			novoJogo = teclado.next().charAt(0);
			/**
			do { 
			if (novoJogo != 's' || novoJogo != 'S' || novoJogo != 'n' || novoJogo != 'N') {
				System.out.println("Caracter incorreto");
				System.out.println("Digite S ou N");
			} while ()	
			}**/

		} while (novoJogo == 's');
		teclado.close();

	}

}
