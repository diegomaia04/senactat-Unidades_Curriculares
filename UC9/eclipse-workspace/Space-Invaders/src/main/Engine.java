package main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import sprites.Nave;

@SuppressWarnings("serial")
public class Engine extends JPanel implements Runnable, KeyListener {
	/*************************
	 **** VINCULAR A NAVE ****
	 *************************/
	Nave nave = new Nave();
	public int sentido;

	/*******************************
	 **** VINCULAR O BACKDROP ******
	 *******************************/
	Backdrop backdrop = new Backdrop();
	//public int movimenta;

	/********************
	 **** CONSTRUTOR ****
	 *********************/
	public Engine() {
		/**************************
		 **** CRIAR UMA THREAD ****
		 **************************/
		Thread game = new Thread(this);
		game.start(); // Iniciar processamento do jogo (run())
	}

	@Override
	public void run() {
		while (true) {
			/**************************
			 **** MECANICA DO JOGO ****
			 **************************/
			refresh(); // Atualizar o JPanel -> JFrame
			repaint(); // Redesenhar os assets
			delay(); // Tempo antes do refresh (ajustes UX)

		}
	}

	public void refresh() {

		nave.moverNave(sentido);

	}

	/***************************************************
	 **** LIMPAR A TELA E EVITAR O RASTRO DO SPRITE ****
	 ***************************************************/
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		backdrop.exibirFundo(g);
		nave.exibirNave(g);

	}

	public void delay() {
		/********************************
		 **** TRATAMENTO DE EXCECOES ****
		 ********************************/
		try {
			Thread.sleep(5); // milissegundos

		} catch (Exception e) {
			System.out.println(e);
		}

	} // Fim do metodo void

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/******************************
	 **** PRESSIONAR UMA TECLA ****
	 ******************************/
	@Override
	public void keyPressed(KeyEvent e) {
		/******************************
		 **** SE PRESSIONA TECLA > ****
		 ******************************/
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			// nave.moverNave(sentido = 1);
			sentido = 1;
		}
		/******************************
		 **** SE PRESSIONA TECLA < ****
		 ******************************/
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			// nave.moverNave(sentido = -1);
			sentido = -1;
		}
		/******************************
		 **** SE PRESSIONA TECLA > ****
		 ******************************/
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			sentido = 2;
		}
		/******************************
		 **** SE PRESSIONA TECLA < ****
		 ******************************/
		if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_X) {
			sentido = -2;
		}

	}

	/**************************
	 **** SOLTAR UMA TECLA ****
	 **************************/
	@Override
	public void keyReleased(KeyEvent e) {
		nave.moverNave(sentido = 0);

	}
} // Fim da classe Engine
