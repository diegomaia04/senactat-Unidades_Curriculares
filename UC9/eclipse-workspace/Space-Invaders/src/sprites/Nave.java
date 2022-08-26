package sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Nave {
	/**************************************************
	 **** CRIAR UM SPRITE COM UMA IMAGEM EXISTENTE ****
	 **************************************************/
	BufferedImage sprite1;

	/*******************
	 **** VARIAVEIS ****
	 *******************/
	int posX = 600;
	int velocidade = 3;
	int posY = 550;

	/********************
	 **** CONSTRUTOR ****
	 ********************/

	public Nave() {
		/********************************
		 **** TRATAMENTO DE EXCECOES ****
		 ********************************/
		try {
			/***************************
			 **** CARREGAR A IMAGEM ****
			 ***************************/
			sprite1 = ImageIO.read(new File("./img/nave2.png"));

		} catch (Exception e) {
			System.out.println("N�o foi poss�vel carregar a imagem da nave");
			System.out.println(e);
		}
	}

	/************************************************
	 **** METODO RESPONSAVEL POR DESENHAR A NAVE ****
	 ************************************************/
	public void exibirNave(Graphics g) {
		g.drawImage(sprite1, posX, posY, null); // x = 600 e y = 550
		// posX += velocidade;
	}

	/*****************************************************************************
	 **** METODO QUE AO SER EXECUTADO RECEBE UM VALOR PARA A VARIAVEL SENTIDO ****
	 *****************************************************************************/
	public void moverNave(int sentido) {

		/*****************************
		 **** HORIZONTAL POSITIVO ****
		 *****************************/
		if (sentido == 1) {
			posX += velocidade;
		} else if (sentido == -1) {
			/*****************************
			 **** HORIZONTAL NEGATIVO ****
			 *****************************/
			posX -= velocidade;
		} else if (sentido == 2) {
			/*****************************
			 **** VERTICAL POSITIVO ******
			 *****************************/
			posY -= velocidade;
		} else if (sentido == -2) {
			/*****************************
			 **** VERTICAL NEGATIVO ****
			 *****************************/
			posY += velocidade;
		}

		/****************************************
		 **** EVITAR QUE A NAVE SAIA DA TELA ****
		 ****************************************/
		if (posX >= 1175) {
			posX = 1175;
		}

		/****************************************
		 **** EVITAR QUE A NAVE SAIA DA TELA ****
		 ****************************************/
		if (posX <= 0) {
			posX = 0;
		}
		/****************************************
		 **** EVITAR QUE A NAVE SAIA DA TELA ****
		 ****************************************/
		if (posY >= 560) {
			posY = 560;
		}

		/****************************************
		 **** EVITAR QUE A NAVE SAIA DA TELA ****
		 ****************************************/
		if (posY <= 0) {
			posY = 0;
		}
	} // Fim do metodo moverNave

	/***********************
	 **** METODO ATIRAR ****
	 ***********************/
	// Cria o tiro passando a posicao x da nave para a classe Laser
	// Retornar o tiro para a Engine
	public Laser atirar() {
		Laser tiro = new Laser(posX + 42, posY);
		return tiro;

	} // Fim do metodo atirar

}
