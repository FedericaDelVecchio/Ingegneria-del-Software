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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class Preside extends JDialog {

	/**
	 * Create the dialog.
	 */
	public Preside() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
			JLabel lblNewLabel = new JLabel("Username Preside");
			lblNewLabel.setBounds(20, 40, 131, 14);
			getContentPane().add(lblNewLabel);
		
			JTextArea preside = new JTextArea();
			preside.setBounds(142, 35, 73, 22);
			getContentPane().add(preside);
		
			JLabel lblNewLabel_1 = new JLabel("Username Alunno");
			lblNewLabel_1.setBounds(20, 68, 146, 14);
			getContentPane().add(lblNewLabel_1);
		
			JTextArea alunno = new JTextArea();
			alunno.setBounds(142, 63, 73, 22);
			getContentPane().add(alunno);
			alunno.setEditable(false);
		
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 105, 384, 126);
			getContentPane().add(scrollPane);
			
			JTextArea soluzioni = new JTextArea();
			scrollPane.setViewportView(soluzioni);
			soluzioni.setEditable(false);
			soluzioni.setLineWrap(true);
			soluzioni.setWrapStyleWord(true);
			
		
			JButton btnNewButton = new JButton("Stampa Classi e Alunni");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					alunno.setText("");
					String p=preside.getText();
					GestioneIstitutoScolastico is=new GestioneIstitutoScolastico();
					String str=is.stampaClassiEAlunni(p);
					soluzioni.setText(str);
					alunno.setEditable(true);
					preside.setEditable(false);
				}
			});
			btnNewButton.setBounds(241, 36, 168, 23);
			getContentPane().add(btnNewButton);
		
			JButton btnNewButton_1 = new JButton("Approva Pagella");
			btnNewButton_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String a=alunno.getText();
					GestioneIstitutoScolastico is=new GestioneIstitutoScolastico();
					String str=is.approvazionePagella(a);
					soluzioni.setText(str);
				}
			});
			btnNewButton_1.setBounds(241, 64, 168, 23);
			getContentPane().add(btnNewButton_1);

		
	}
}