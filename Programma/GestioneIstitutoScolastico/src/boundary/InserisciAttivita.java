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

public class InserisciAttivita extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InserisciAttivita dialog = new InserisciAttivita();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InserisciAttivita() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("INSERIMENTO ATTIVITA'");
			lblNewLabel.setBounds(38, 23, 168, 14);
			getContentPane().add(lblNewLabel);
		
			JLabel lblNewLabel_1 = new JLabel("Materia");
			lblNewLabel_1.setBounds(38, 69, 84, 14);
			getContentPane().add(lblNewLabel_1);
		
			JTextArea materia = new JTextArea();
			materia.setBounds(94, 64, 84, 22);
			getContentPane().add(materia);
		
			JLabel lblNewLabel_2 = new JLabel("Data");
			lblNewLabel_2.setBounds(38, 104, 46, 14);
			getContentPane().add(lblNewLabel_2);
		
			JTextArea data = new JTextArea();
			data.setBounds(94, 99, 84, 22);
			getContentPane().add(data);
		
			JLabel lblNewLabel_3 = new JLabel("Anno Classe");
			lblNewLabel_3.setBounds(219, 69, 92, 14);
			getContentPane().add(lblNewLabel_3);
		
			JTextArea anno = new JTextArea();
			anno.setBounds(317, 64, 84, 22);
			getContentPane().add(anno);
		
			JLabel lblNewLabel_4 = new JLabel("Sezione Classe");
			lblNewLabel_4.setBounds(219, 104, 92, 14);
			getContentPane().add(lblNewLabel_4);
		
			JTextArea sezione = new JTextArea();
			sezione.setBounds(317, 99, 84, 22);
			getContentPane().add(sezione);
		
			JLabel lblNewLabel_5 = new JLabel("Descrizione");
			lblNewLabel_5.setBounds(38, 142, 84, 14);
			getContentPane().add(lblNewLabel_5);
		
			JTextArea descrizione = new JTextArea();
			descrizione.setBounds(132, 137, 269, 22);
			getContentPane().add(descrizione);
		
			JTextArea soluzioni = new JTextArea();
			soluzioni.setBounds(38, 215, 363, 22);
			getContentPane().add(soluzioni);
			soluzioni.setEditable(false);
			soluzioni.setLineWrap(true);
			soluzioni.setWrapStyleWord(true);
		
			JButton btnNewButton = new JButton("Inserisci");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					soluzioni.setText("");
					String m=materia.getText();
					String des=descrizione.getText();
					String dat=data.getText();
					String a=anno.getText();
					String s=sezione.getText();
					GestioneIstitutoScolastico g=new GestioneIstitutoScolastico();
					String ris=g.inserimentoAttivita(m, des, dat, a, s);
					soluzioni.setText(ris);
					materia.setText("");
					descrizione.setText("");
					data.setText("");
					anno.setText("");
					sezione.setText("");					
				}
			});
			btnNewButton.setBounds(153, 181, 114, 23);
			getContentPane().add(btnNewButton);
	}
	}
}