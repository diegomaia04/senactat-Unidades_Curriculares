package portifolio;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Cep extends JDialog {
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	@SuppressWarnings("rawtypes")
	private JComboBox cboUf;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cep dialog = new Cep();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Cep() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cep.class.getResource("/img/cep-48.png")));
		getContentPane().setBackground(Color.WHITE);
		setTitle("Buscar CEP");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 250);
		getContentPane().setLayout(null);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(12, 40, 31, 15);
		getContentPane().add(lblCep);

		txtCep = new JTextField();
		txtCep.setBounds(91, 40, 130, 19);
		getContentPane().add(txtCep);
		txtCep.setColumns(10);

		JLabel lblEndereco = new JLabel("Endereço");
		lblEndereco.setBounds(12, 70, 70, 15);
		getContentPane().add(lblEndereco);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(12, 100, 49, 15);
		getContentPane().add(lblBairro);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(12, 130, 70, 15);
		getContentPane().add(lblCidade);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(91, 70, 300, 19);
		getContentPane().add(txtEndereco);
		txtEndereco.setColumns(10);

		txtBairro = new JTextField();
		txtBairro.setBounds(91, 100, 300, 19);
		getContentPane().add(txtBairro);
		txtBairro.setColumns(10);

		txtCidade = new JTextField();
		txtCidade.setBounds(91, 130, 200, 19);
		getContentPane().add(txtCidade);
		txtCidade.setColumns(10);

		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(321, 130, 31, 15);
		getContentPane().add(lblUf);

		cboUf = new JComboBox();
		cboUf.setModel(new DefaultComboBoxModel(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cboUf.setBounds(357, 130, 64, 19);
		getContentPane().add(cboUf);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setBounds(12, 160, 117, 19);
		getContentPane().add(btnLimpar);

		JButton btnCep = new JButton("Buscar");
		btnCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscar();
			}
		});
		btnCep.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCep.setBounds(260, 40, 117, 19);
		getContentPane().add(btnCep);

		/* Uso da biblioteca Atxy2k para validação do campo txtCep */
		RestrictedTextField validar = new RestrictedTextField(txtCep);

		lblStatus = new JLabel("");
		lblStatus.setBounds(230, 40, 20, 20);
		getContentPane().add(lblStatus);
		validar.setOnlyNums(true);
		validar.setLimit(8);

	} // Fim do construtor

	void buscar() {
		if (txtCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe o CEP");
			txtCep.requestFocus();
		} else {
			// buscar CEP
			String logradouro = "";
			String tipoLogradouro = "";
			String resultado = null;
			String cep = txtCep.getText();
			try {
				URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
				SAXReader xml = new SAXReader();
				Document documento = xml.read(url);
				Element root = documento.getRootElement();
				for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
					Element element = it.next();
					if (element.getQualifiedName().equals("cidade")) {
						txtCidade.setText(element.getText());
					}
					if (element.getQualifiedName().equals("bairro")) {
						txtBairro.setText(element.getText());
					}
					if (element.getQualifiedName().equals("uf")) {
						cboUf.setSelectedItem(element.getText());
					}
					if (element.getQualifiedName().equals("tipo_logradouro")) {
						tipoLogradouro = element.getText();
					}
					if (element.getQualifiedName().equals("logradouro")) {
						logradouro = element.getText();
					}
					if (element.getQualifiedName().equals("resultado")) {
						resultado = element.getText();
						if (resultado.equals("1")) {
							lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check.png")));

						} else {
							JOptionPane.showMessageDialog(null, "CEP não encontrado");
							txtCep.setText(null);
							txtCep.requestFocus();

						}

					}
				}
				// setar o campo endereço
				txtEndereco.setText(tipoLogradouro + " " + logradouro);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private void limpar() {
		txtCep.setText(null);
		txtEndereco.setText(null);
		txtBairro.setText(null);
		txtCidade.setText(null);
		cboUf.setSelectedItem(null);
		txtCep.requestFocus();
		lblStatus.setIcon(null);
	}
} // Fim
