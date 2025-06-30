package boundary;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import control.*;

public class Genitore extends JDialog {
	private JTextField alunno;
	/**
	 * Create the dialog.
	 */
	public Genitore() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username Genitore");
		lblNewLabel.setBounds(32, 33, 128, 14);
		getContentPane().add(lblNewLabel);
		
		JTextArea genitore = new JTextArea();
		genitore.setBounds(152, 28, 107, 22);
		getContentPane().add(genitore);
		
		
		JLabel lblNewLabel_1 = new JLabel("Username Alunno");
		lblNewLabel_1.setBounds(32, 64, 133, 14);
		getContentPane().add(lblNewLabel_1);
		
		alunno = new JTextField();
		alunno.setBounds(152, 61, 106, 20);
		getContentPane().add(alunno);
		alunno.setColumns(10);
		alunno.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 105, 384, 126);
		getContentPane().add(scrollPane);
		
		JTextArea soluzioni = new JTextArea();
		scrollPane.setViewportView(soluzioni);
		soluzioni.setEditable(false);
		soluzioni.setLineWrap(true);
		soluzioni.setWrapStyleWord(true);

		{
			JButton btnNewButton = new JButton("Stampa Figli");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String userGenitore=genitore.getText();
					genitore.setEditable(false);
					GestioneIstitutoScolastico g = new GestioneIstitutoScolastico();
					String ri = g.stampaFigli(userGenitore);
					soluzioni.setText(ri);
					alunno.setEditable(true);
				}
			});
			btnNewButton.setBounds(276, 29, 128, 23);
			getContentPane().add(btnNewButton);
		}
		
		
		JButton btnNewButton_1 = new JButton("Stampa Carriera");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String al = alunno.getText();
				GestioneIstitutoScolastico gi = new GestioneIstitutoScolastico();
				String ri = gi.letturaCarriera(al);
				soluzioni.setText(ri);
				
			}
		});
		btnNewButton_1.setBounds(276, 63, 128, 23);
		getContentPane().add(btnNewButton_1);
	}
}