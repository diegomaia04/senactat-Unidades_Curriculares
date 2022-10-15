package exercicios;

import java.util.Random;

public class Carro {

	// Atributos
	int ano;
	String cor;

	// Construtor
	public Carro() {
		// Chassi rand�mico
		System.out.println("======================");
		String chassi = new String("1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		Random random = new Random();
		System.out.print("Chassi: *");
		for (int i = 1; i < 16; i++) {
			// Cria uma vari�vel do tipo char que vai receber caracter do chassi
			// (char) - casting - converte para o tipo char
			// random.nextInt - faz um sorteio
			// chassi.length - tamanho m�ximo da string
			char numero = (char) random.nextInt(chassi.length());
			System.out.print(chassi.charAt(numero));
		}
		System.out.println("*");
	}

	// M�todos
	void ligar() {
		System.out.println("Ligando...");
	}

	void desligar() {
		System.out.println("Desligando...");
	}

	void acelerar() {
		System.out.println("Acelerando...");
	}
}
