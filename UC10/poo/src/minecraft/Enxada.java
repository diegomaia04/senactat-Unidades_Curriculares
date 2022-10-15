/**
 * 
 */
package minecraft;

/**
 * @author Fagner Geraldes Braga
 *
 */
public class Enxada extends Bloco {
	// Atributos
	boolean conquista = false;

	// Novo m�todo
	void arar() {
		System.out.println("Terra preparada para o plantio.");
		conquista = true;
	}
	// Polimorfismo - modifica��o de um m�todo existente.
	// Importante: mesmo nome do m�todo e somente em caso de heran�a
	void minerar() {
		System.out.println("Atacar...");		
	}
}
