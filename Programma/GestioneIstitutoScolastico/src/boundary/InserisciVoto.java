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

public class InserisciVoto extends JDialog {

	/**
	 * Create the dialog.
	 */
	public InserisciVoto() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INSERIMENTO VOTO");
		lblNewLabel.setBounds(34, 11, 130, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valore");
		lblNewLabel_1.setBounds(34, 36, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JTextArea valore = new JTextArea();
		valore.setBounds(90, 36, 86, 22);
		getContentPane().add(valore);
		
		JLabel lblNewLabel_2 = new JLabel("Materia");
		lblNewLabel_2.setBounds(34, 74, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JTextArea materia = new JTextArea();
		materia.setBounds(90, 69, 86, 22);
		getContentPane().add(materia);
		
		JLabel lblNewLabel_3 = new JLabel("Data");
		lblNewLabel_3.setBounds(186, 36, 82, 14);
		getContentPane().add(lblNewLabel_3);
		
		JTextArea data = new JTextArea();
		data.setBounds(308, 36, 92, 22);
		getContentPane().add(data);
		
		JLabel lblNewLabel_4 = new JLabel("Username Alunno");
		lblNewLabel_4.setBounds(186, 74, 123, 14);
		getContentPane().add(lblNewLabel_4);
		
		JTextArea alunno = new JTextArea();
		alunno.setBounds(308, 69, 92, 22);
		getContentPane().add(alunno);
		
		
		JTextArea soluzioni = new JTextArea();
		soluzioni.setBounds(22, 150, 391, 100);
		getContentPane().add(soluzioni);
		soluzioni.setEditable(false);
		soluzioni.setLineWrap(true);
		soluzioni.setWrapStyleWord(true);
		
		JButton btnNewButton = new JButton("Inserisci");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int v=Integer.parseInt(valore.getText());
				String m=materia.getText();
				String d=data.getText();
				String u=alunno.getText();
				if(v>=0 && v<=10) {
					GestioneIstitutoScolastico gis=new GestioneIstitutoScolastico();
					String str=gis.inserimentoVoto(v, m, d, u);
					soluzioni.setText(str);
				}
				else {soluzioni.setText("Il valore del voto non e' valido!");}
				valore.setText("");
				materia.setText("");
				data.setText("");
				alunno.setText("");
			}
		});
		btnNewButton.setBounds(124, 116, 185, 23);
		getContentPane().add(btnNewButton);
		}
}