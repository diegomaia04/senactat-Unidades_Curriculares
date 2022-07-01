/**
 * Fundamentos do Java
 * Números Aleatórios
 */
package fundamentos;

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
		// As linhas abaixo geram números aleatórios
		// O zero sempre é considerado

		Random random = new Random();
		int face = random.nextInt(6) + 1;
		System.out.println("Face do dado: " + face);

	}

}
