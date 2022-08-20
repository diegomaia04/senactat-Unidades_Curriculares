package main;

import javax.swing.JFrame;

public class Stage {

	public static void main(String[] args) {
		/*******************************
		 **** CRIA E DESENHA A TELA ****
		 *******************************/
		JFrame janela = new JFrame("Space Invaders");
		// janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
		janela.setSize(1280, 720);
		// janela.setUndecorated(true);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null); // centralizar a tela

		/***********************************************
		 **** CRIAR UM OBJETO PARA ACESSAR A ENGINE ****
		 ***********************************************/
		Engine assets = new Engine();
		assets.setBounds(0, 0, 1280, 720);
		janela.add(assets);

		/*************************************
		 **** ADICIONAR ESCUTA DE TECLADO ****
		 *************************************/
		janela.addKeyListener(assets);

	}

}
