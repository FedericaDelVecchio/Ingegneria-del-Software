package boundary;

import java.awt.BorderLayout;
import control.*;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModificaPagella extends JDialog {

	/**
	 * Create the dialog.
	 */
	public ModificaPagella() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MODIFICA PAGELLA");
		lblNewLabel.setBounds(22, 31, 133, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username Alunno");
		lblNewLabel_1.setBounds(22, 69, 113, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Materia");
		lblNewLabel_2.setBounds(22, 114, 86, 14);
		getContentPane().add(lblNewLabel_2);
		
		JTextArea materia = new JTextArea();
		materia.setBounds(156, 109, 88, 22);
		getContentPane().add(materia);
		
		JLabel lblNewLabel_3 = new JLabel("Arrotondamento per...");
		lblNewLabel_3.setBounds(22, 158, 133, 14);
		getContentPane().add(lblNewLabel_3);
		
		JTextArea alunno = new JTextArea();
		alunno.setBounds(156, 64, 88, 22);
		getContentPane().add(alunno);
		
		JTextArea arrotondamento = new JTextArea();
		arrotondamento.setBounds(156, 153, 88, 22);
		getContentPane().add(arrotondamento);
		
		JTextArea soluzioni = new JTextArea();
		soluzioni.setBounds(266, 26, 145, 212);
		getContentPane().add(soluzioni);
		soluzioni.setEditable(false);
		soluzioni.setLineWrap(true);
		soluzioni.setWrapStyleWord(true);
		
		JButton btnNewButton = new JButton("Modifica");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				soluzioni.setText("");
				String username=alunno.getText();
				String mat=materia.getText();
				String arroton=arrotondamento.getText();
				GestioneIstitutoScolastico g=new GestioneIstitutoScolastico();
				String ret="";
				if(arroton.equals("eccesso")) ret=g.modificaPagella(username, mat,0);
				else if(arroton.equals("difetto")) ret=g.modificaPagella(username, mat,1);
				soluzioni.setText(ret);
				alunno.setText("");
				materia.setText("");
				arrotondamento.setText("");
			}
		});
		btnNewButton.setBounds(60, 202, 162, 23);
		getContentPane().add(btnNewButton);
	}
}