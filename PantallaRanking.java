package Buscaminas;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;

import java.awt.Color;
import javax.swing.SwingConstants;

import javax.swing.border.LineBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaRanking extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAceptar;



	public PantallaRanking() {
		setTitle("RANKING");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("L@S DIEZ MEJORES");
		lblNewLabel.setBounds(11, 11, 213, 24);
		lblNewLabel.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JTextPane txtpnPdatosPdatosPdatos = new JTextPane();
		txtpnPdatosPdatosPdatos.setBounds(11, 46, 213, 218);
		contentPane.add(txtpnPdatosPdatosPdatos);
		txtpnPdatosPdatosPdatos.setForeground(Color.BLACK);
		txtpnPdatosPdatosPdatos.setBackground(Color.WHITE);
		txtpnPdatosPdatosPdatos.setEditable(false);
		txtpnPdatosPdatosPdatos.setFont(new Font("Arial", Font.BOLD, 18));
		txtpnPdatosPdatosPdatos.setText(Ranking.getMiRanking().jugadorYPuntuacion());
		
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(10, 291, 214, 59);
		contentPane.add(btnAceptar);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAceptar)) {
			this.setVisible(false);
			
	}
	}
}
