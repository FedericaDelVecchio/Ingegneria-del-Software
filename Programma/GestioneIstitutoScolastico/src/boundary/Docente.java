package boundary;


import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Docente extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Docente dialog = new Docente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Docente() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username Docente");
		lblNewLabel.setBounds(103, 52, 109, 14);
		getContentPane().add(lblNewLabel);
		
		JTextArea username = new JTextArea();
		username.setBounds(222, 47, 128, 22);
		getContentPane().add(username);
		
		JButton btnNewButton = new JButton("Consulta Registro");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String user=username.getText();
				username.setEditable(false);
				new ConsultaRegistroDocente(user).setVisible(true);
			}
		});
		btnNewButton.setBounds(31, 118, 181, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Inserisci Voto");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new InserisciVoto().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(31, 173, 182, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Inserisci Attivita'");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new InserisciAttivita().setVisible(true);
			}
		});
		btnNewButton_2.setBounds(222, 173, 181, 23);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Modifica Pagella");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ModificaPagella().setVisible(true);
			}
		});
		btnNewButton_3.setBounds(222, 118, 181, 23);
		getContentPane().add(btnNewButton_3);
	}
}