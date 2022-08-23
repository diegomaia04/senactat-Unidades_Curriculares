/**
 * Estudo do array
 * Exemplo 1 - Array simples (vetor)
 */
package array;

/**
 * @author Fagner Geraldes Braga
 *
 */
public class Array1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*******************************
		 **** ARRAY SIMPLES (VETOR) ****
		 *******************************/
		String[] times = { "Corinthians", "S�o Paulo", "Palmeiras", "Santos" };

		/************************************
		 **** RECUPERA O VALOR DO INDICE ****
		 ************************************/
		System.out.println(times[0]);

		/************************************
		 **** INFORMA O TAMANHO DO ARRAY ****
		 ************************************/
		System.out.println("Tamanho do array: " + times.length);

		/**********************************************
		 **** LA�O FOR PARA PERCORRER TODO O ARRAY ****
		 **********************************************/
		System.out.println("===========================");
		System.out.println("Times");
		System.out.println("===========================");
		for (int i = 0; i < times.length; i++) {
			System.out.println(times[i]);
		}
	}
}
