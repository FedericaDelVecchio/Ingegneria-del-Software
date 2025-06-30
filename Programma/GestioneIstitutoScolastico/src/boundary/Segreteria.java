package boundary;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.GestioneIstitutoScolastico;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Segreteria extends JDialog {
	private JTextField soluzione;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Segreteria dialog = new Segreteria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Segreteria() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRAZIONE UTENTE");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(17, 1, 188, 34);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(17, 46, 89, 14);
		getContentPane().add(lblNewLabel_1);
		
		JTextArea username = new JTextArea();
		username.setBounds(116, 41, 89, 22);
		getContentPane().add(username);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(17, 79, 89, 14);
		getContentPane().add(lblNewLabel_2);
		
		JTextArea password = new JTextArea();
		password.setLineWrap(true);
		password.setBounds(116, 74, 89, 22);
		getContentPane().add(password);
		
		JLabel lblNewLabel_3 = new JLabel("Nome");
		lblNewLabel_3.setBounds(17, 112, 89, 14);
		getContentPane().add(lblNewLabel_3);
		
		JTextArea nome = new JTextArea();
		nome.setBounds(116, 107, 89, 22);
		getContentPane().add(nome);
		
		JTextArea cognome = new JTextArea();
		cognome.setBounds(116, 140, 89, 22);
		getContentPane().add(cognome);
		
		JLabel lblNewLabel_4 = new JLabel("Cognome");
		lblNewLabel_4.setBounds(17, 145, 89, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Data di nascita");
		lblNewLabel_5.setBounds(17, 178, 89, 14);
		getContentPane().add(lblNewLabel_5);
		
		JTextArea nascita = new JTextArea();
		nascita.setBounds(116, 173, 89, 22);
		getContentPane().add(nascita);
		
		JLabel lblNewLabel_6 = new JLabel("Codice Fiscale");
		lblNewLabel_6.setBounds(228, 21, 89, 14);
		getContentPane().add(lblNewLabel_6);
		
		JTextArea codiceFiscale = new JTextArea();
		codiceFiscale.setBounds(324, 16, 89, 22);
		getContentPane().add(codiceFiscale);
		
		JLabel lblNewLabel_7 = new JLabel("Residenza");
		lblNewLabel_7.setBounds(228, 54, 89, 14);
		getContentPane().add(lblNewLabel_7);
		
		JTextArea residenza = new JTextArea();
		residenza.setBounds(324, 49, 89, 22);
		getContentPane().add(residenza);
		
		JLabel lblNewLabel_8 = new JLabel("E-Mail");
		lblNewLabel_8.setBounds(228, 91, 89, 14);
		getContentPane().add(lblNewLabel_8);
		
		JTextArea email = new JTextArea();
		email.setBounds(324, 86, 89, 22);
		getContentPane().add(email);
		
		JLabel lblNewLabel_9 = new JLabel("Cellulare");
		lblNewLabel_9.setBounds(228, 124, 89, 14);
		getContentPane().add(lblNewLabel_9);
		
		JTextArea cellulare = new JTextArea();
		cellulare.setBounds(324, 119, 89, 22);
		getContentPane().add(cellulare);
		
		JLabel lblNewLabel_10 = new JLabel("Tipo di utente");
		lblNewLabel_10.setBounds(228, 157, 99, 14);
		getContentPane().add(lblNewLabel_10);
		
		JTextArea tipoUtente = new JTextArea();
		tipoUtente.setBounds(324, 152, 89, 22);
		getContentPane().add(tipoUtente);
		
		JButton btnNewButton = new JButton("Inserisci");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				soluzione.setText("");
				String user=username.getText();
				String pass=password.getText();
				String nom=nome.getText();
				String con=cognome.getText();
				String res=residenza.getText();
				String nasc=nascita.getText();
				String cf=codiceFiscale.getText();
				Integer cell=Integer.parseInt(cellulare.getText());
				String em=email.getText();
				String tipo=tipoUtente.getText();
				GestioneIstitutoScolastico is = new GestioneIstitutoScolastico();
				String ris="";
				ris=is.inserimentoUtente(user, pass, nom,con, res, nasc, cf, cell, em, tipo);
				username.setText("");
				password.setText("");
				nome.setText("");
				cognome.setText("");
				residenza.setText("");
				nascita.setText("");
				codiceFiscale.setText("");
				cellulare.setText("");
				email.setText("");
				tipoUtente.setText("");
				soluzione.setText(ris);
			}
		});
		btnNewButton.setBounds(271, 186, 99, 23);
		getContentPane().add(btnNewButton);
		
		soluzione = new JTextField();
		soluzione.setBounds(87, 220, 283, 20);
		getContentPane().add(soluzione);
		soluzione.setColumns(10);
		soluzione.setEditable(false);
	
	}
}