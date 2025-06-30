package boundary;

import java.awt.EventQueue;
import control.GestioneIstitutoScolastico;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea pagelle = new JTextArea();
		pagelle.setBounds(83, 217, 261, 22);
		contentPane.add(pagelle);
		pagelle.setEditable(false);
		
		JButton btnNewButton = new JButton("Segreteria");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Segreteria().setVisible(true);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(44, 50, 164, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Fine Quadrimestre");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestioneIstitutoScolastico is = new GestioneIstitutoScolastico();
				is.generazionePagelle();
				pagelle.setText("Tutte le pagelle sono state generate.");
				
			}
		});
		btnNewButton_1.setBounds(221, 50, 164, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Preside");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Preside().setVisible(true);
			}
		});
		btnNewButton_2.setBounds(221, 108, 164, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Docente");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Docente().setVisible(true);
			}
		});
		btnNewButton_3.setBounds(44, 108, 164, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Alunno");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Alunno().setVisible(true);
			}
		});
		btnNewButton_4.setBounds(44, 170, 164, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Genitore");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Genitore().setVisible(true);
			}
		});
		btnNewButton_5.setBounds(221, 170, 164, 23);
		contentPane.add(btnNewButton_5);
		
	}
}