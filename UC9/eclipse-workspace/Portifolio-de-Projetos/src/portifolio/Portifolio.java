package portifolio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Portifolio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Portifolio frame = new Portifolio();
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
	public Portifolio() {
		setForeground(new Color(0, 102, 153));
		setResizable(false);
		setTitle("Portifólio de Projetos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnImc = new JButton("IMC");
		btnImc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// as linhas abaixo fazem o link com o formulário IMC
				IMC imc = new IMC();
				imc.setVisible(true);
			}
		});
		btnImc.setBounds(24, 12, 117, 25);
		contentPane.add(btnImc);

		JButton btnSobre = new JButton("Sobre");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// as linhas abaixo fazem o link com o formulário Sobre
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setBounds(306, 12, 117, 25);
		contentPane.add(btnSobre);

		JButton btnBoletim = new JButton("Boletim");
		btnBoletim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Boletim boletim = new Boletim();
				boletim.setVisible(true);
			}
		});
		btnBoletim.setBounds(165, 12, 117, 25);
		contentPane.add(btnBoletim);

		JButton btnNewButton = new JButton("ºF para ºC");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Temperatura temperatura = new Temperatura();
				temperatura.setVisible(true);
			}
		});
		btnNewButton.setBounds(24, 61, 117, 25);
		contentPane.add(btnNewButton);

		JButton btnTemperatura = new JButton("ºC para ºF");
		btnTemperatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Temperatura2 temperatura2 = new Temperatura2();
				temperatura2.setVisible(true);
			}
		});
		btnTemperatura.setFont(new Font("Dialog", Font.BOLD, 12));
		btnTemperatura.setBounds(165, 60, 117, 25);
		contentPane.add(btnTemperatura);

		JButton btnPorcentagem = new JButton("%");
		btnPorcentagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Porcentagem porcentagem = new Porcentagem();
				porcentagem.setVisible(true);
			}
		});
		btnPorcentagem.setFont(new Font("Dialog", Font.BOLD, 12));
		btnPorcentagem.setBounds(306, 60, 117, 25);
		contentPane.add(btnPorcentagem);
		
		JButton btnServico = new JButton("Serviço");
		btnServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HoraServico horaservico = new HoraServico();
				horaservico.setVisible(true);
			}
		});
		btnServico.setBounds(24, 110, 117, 25);
		contentPane.add(btnServico);
	} // fim do construtor
}
