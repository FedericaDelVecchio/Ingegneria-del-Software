package boundary;

import javax.swing.JButton;
import javax.swing.JDialog;

import control.GestioneIstitutoScolastico;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Alunno extends JDialog {

	/**
	 * Create the dialog.
	 */
	public Alunno() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("LETTURA ATTIVITA'");
			lblNewLabel.setBounds(158, 21, 117, 14);
			getContentPane().add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Data");
			lblNewLabel_1.setBounds(240, 63, 49, 14);
			getContentPane().add(lblNewLabel_1);
		}
		
		JTextArea data = new JTextArea();
		data.setBounds(286, 58, 84, 22);
		getContentPane().add(data);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBounds(48, 63, 71, 14);
		getContentPane().add(lblNewLabel_2);
		
		JTextArea username = new JTextArea();
		username.setBounds(129, 58, 84, 22);
		getContentPane().add(username);		

		JTextArea soluzioni = new JTextArea();
		soluzioni.setBounds(65, 104, 293, 87);
		getContentPane().add(soluzioni);
		soluzioni.setLineWrap(true);
		soluzioni.setWrapStyleWord(true);
		
		JButton btnCerca = new JButton("Cerca");
		btnCerca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				soluzioni.setText("");
				String dat = data.getText();
				String use = username.getText();
				username.setEditable(false);
				GestioneIstitutoScolastico gis = new GestioneIstitutoScolastico();
				String ris = gis.letturaAttivita(use,dat);
				soluzioni.setText(ris);
				data.setText("");
				data.setEditable(true);
			}
		});
		btnCerca.setBounds(165, 213, 97, 23);
		getContentPane().add(btnCerca);
		
	}
}