package boundary;

import control.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConsultaRegistroDocente extends JDialog {
	String username="";
	
	/**
	 * Create the dialog.
	 */
	public ConsultaRegistroDocente(String u) {
		username=u;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Anno Classe");
		lblNewLabel.setBounds(25, 138, 81, 14);
		getContentPane().add(lblNewLabel);
		
		JTextArea anno = new JTextArea();
		anno.setBounds(116, 133, 76, 22);
		getContentPane().add(anno);
		anno.setEditable(false);
		
		JLabel lblNewLabel_1 = new JLabel("Sezione Classe");
		lblNewLabel_1.setBounds(25, 168, 93, 14);
		getContentPane().add(lblNewLabel_1);
		
		JTextArea sezione = new JTextArea();
		sezione.setBounds(116, 163, 76, 22);
		getContentPane().add(sezione);
		sezione.setEditable(false);
		
		JTextArea soluzioni = new JTextArea();
		soluzioni.setBounds(213, 23, 197, 207);
		getContentPane().add(soluzioni);
		soluzioni.setEditable(false);
		soluzioni.setLineWrap(true);
		soluzioni.setWrapStyleWord(true);
		
		JButton btnNewButton = new JButton("Stampa Classi e Materie");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				anno.setText("");
				sezione.setText("");
				GestioneIstitutoScolastico g = new GestioneIstitutoScolastico();
				String str=g.stampaClassiEMaterie(username);
				soluzioni.setText(str);
				anno.setEditable(true);
				sezione.setEditable(true);
			}
		});
		btnNewButton.setBounds(10, 59, 193, 23);
		getContentPane().add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Stampa Alunni");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ann=anno.getText();
				String sez=sezione.getText();
				GestioneIstitutoScolastico g = new GestioneIstitutoScolastico();
				String s=g.stampaAlunni(ann,sez);
				soluzioni.setText(s);
				anno.setEditable(false);
				sezione.setEditable(false);
			}
		});
		btnNewButton_1.setBounds(25, 193, 167, 23);
		getContentPane().add(btnNewButton_1);
	}
}