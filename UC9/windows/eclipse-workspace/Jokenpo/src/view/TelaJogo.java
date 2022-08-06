package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class TelaJogo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblPc;
	private JRadioButton rdbtnPedra;
	private JRadioButton rdbtnPapel;
	private JRadioButton rdbtnTesoura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaJogo frame = new TelaJogo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaJogo() {
		setTitle("JoKenPo");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 472);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaJogo.class.getResource("/img/pedra.png")));
		label.setBounds(31, 27, 64, 64);
		contentPane.add(label);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TelaJogo.class.getResource("/img/papel.png")));
		label_1.setBounds(126, 27, 64, 64);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(TelaJogo.class.getResource("/img/tesoura.png")));
		label_2.setBounds(221, 27, 64, 64);
		contentPane.add(label_2);

		lblPc = new JLabel("");
		lblPc.setIcon(new ImageIcon(TelaJogo.class.getResource("/img/pc.png")));
		lblPc.setBounds(74, 221, 171, 139);
		contentPane.add(lblPc);

		rdbtnPedra = new JRadioButton("");
		buttonGroup.add(rdbtnPedra);
		rdbtnPedra.setBackground(Color.WHITE);
		rdbtnPedra.setBounds(55, 99, 21, 23);
		contentPane.add(rdbtnPedra);

		rdbtnPapel = new JRadioButton("");
		buttonGroup.add(rdbtnPapel);
		rdbtnPapel.setBackground(Color.WHITE);
		rdbtnPapel.setBounds(149, 99, 21, 23);
		contentPane.add(rdbtnPapel);

		rdbtnTesoura = new JRadioButton("");
		buttonGroup.add(rdbtnTesoura);
		rdbtnTesoura.setBackground(Color.WHITE);
		rdbtnTesoura.setBounds(245, 99, 21, 23);
		contentPane.add(rdbtnTesoura);

		JButton btnPow = new JButton("POW");
		btnPow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pow();
			}
		});
		btnPow.setBounds(101, 165, 117, 25);
		contentPane.add(btnPow);
	} // Fim do construtor

	void pow() {
		// validação
		if (!rdbtnPedra.isSelected() && !rdbtnPapel.isSelected() && !rdbtnTesoura.isSelected()) {
			JOptionPane.showMessageDialog(null, "Selecione uma opção");
		} else {
			// lógica principal
			Random random = new Random();
			int pc = random.nextInt(3);
			// Dica para verificar o número sorteado
			// System.out.println(pc);
			// Associar o número a imagem
			switch (pc) {
			case 0:
				lblPc.setIcon(new ImageIcon(TelaJogo.class.getResource("/img/pcpapel.png")));
				break;
			case 1:
				lblPc.setIcon(new ImageIcon(TelaJogo.class.getResource("/img/pcpedra.png")));
				break;
			case 2:
				lblPc.setIcon(new ImageIcon(TelaJogo.class.getResource("/img/pctesoura.png")));
				break;
			}
			if (rdbtnPedra.isSelected() && (pc == 1) || rdbtnPapel.isSelected() && (pc == 0)
					|| rdbtnTesoura.isSelected() && (pc == 2)) {
				JOptionPane.showMessageDialog(null, "Empate");
			} else if (rdbtnPedra.isSelected() && (pc == 2) || rdbtnPapel.isSelected() && (pc == 1)
					|| rdbtnTesoura.isSelected() && (pc == 0)) {
				JOptionPane.showMessageDialog(null, "Você venceu");
			} else {
				JOptionPane.showMessageDialog(null, "Você perdeu");
			}
			// Limpar os campos
			lblPc.setIcon(new ImageIcon(TelaJogo.class.getResource("/img/pc.png")));
			buttonGroup.clearSelection();
		}
	} // Fim do método pow
} // Fim do código
