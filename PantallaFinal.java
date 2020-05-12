package Buscaminas;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PantallaFinal extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblFinDeLa;
	private JButton btnReset;
	private JPanel panel_3;
	private JButton btnSalir;
	private JButton btnRanking;
	private JPanel panel_4;
	private JPanel panel_5;
	private JLabel victoriaODerrota;
	private JLabel puntuacion;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private String partida;
	private Integer puntos;


	public PantallaFinal(String pPartida, int pPuntos) {
		this.partida=pPartida;
		this.puntos=(Integer) pPuntos;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		contentPane.add(getPanel_10());
		contentPane.add(getPanel_2());
		this.setVisible(true);
		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		if (frameSize.height > screenSize.height) {
		frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
		frameSize.width = screenSize.width;
		}
		setLocation((screenSize.width - frameSize.width) / 2,
		(screenSize.height - frameSize.height) / 2);
	}
	
	
	private JLabel getVictoriaODerrota() {
		if (victoriaODerrota == null) {
			if (this.partida == ("Victoria")){
				victoriaODerrota = new JLabel("Victoria");
			}else if(this.partida == ("Derrota")){
				victoriaODerrota = new JLabel("Derrota");
			}
		}
		return victoriaODerrota;
	}
	private JLabel getPuntuacion() {
		if (puntuacion == null) {
			if (this.partida == ("Derrota")){
				puntuacion = new JLabel("GAME OVER");
			}else if (this.partida == ("Victoria")){
				puntuacion = new JLabel("Enorabuena tu puntuacion es:      " + puntos);
			}
		}
		return puntuacion;
	}
		
	private JPanel getPanel_10() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(3, 0, 0, 0));
			panel.add(getPanel_1_1());
			panel.add(getPanel_4());
			panel.add(getPanel_5());
		}
		return panel;
	}
	private JPanel getPanel_1_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.add(getLblFinDeLa());
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new GridLayout(0, 3, 0, 0));
			panel_2.add(getPanel_7());
			panel_2.add(getPanel_8());
			panel_2.add(getPanel_9());
			panel_2.add(getBtnReset());
			panel_2.add(getPanel_3());
			panel_2.add(getBtnSalir());
			panel_2.add(getBtnRanking());
		}
		return panel_2;
	}
	private JLabel getLblFinDeLa() {
		if (lblFinDeLa == null) {
			lblFinDeLa = new JLabel("FIN DE LA PARTIDA");
			lblFinDeLa.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 23));
		}
		return lblFinDeLa;
	}
	private JButton getBtnReset() {
		if (btnReset == null) {
			btnReset = new JButton("RESET");
			btnReset.addActionListener(this);
		}
		return btnReset;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
		}
		return panel_3;
	}
	private JButton getBtnRanking() {
		if (btnRanking == null) {
			btnRanking = new JButton("Ranking");
			btnRanking.addActionListener(this);
		}
		return btnRanking;
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("SALIR");
			btnSalir.addActionListener(this);
		}
		return btnSalir;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.add(getVictoriaODerrota());
		}
		return panel_4;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			if (getPuntuacion() != null){
				panel_5.add(getPuntuacion());
			}
		}
		return panel_5;
	}
	
	private JPanel getPanel_7() {
		if (panel_7 == null) {
			panel_7 = new JPanel();
		}
		return panel_7;
	}
	private JPanel getPanel_8() {
		if (panel_8 == null) {
			panel_8 = new JPanel();
		}
		return panel_8;
	}
	private JPanel getPanel_9() {
		if (panel_9 == null) {
			panel_9 = new JPanel();
		}
		return panel_9;
	}
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(btnReset)){
			Partida.getMiPartida().reset();
			this.setVisible(false);
			Partida.getMiPartida().reset();
			
			
		}
		if (e.getSource().equals(btnSalir)){
			if (JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro de que quieres salir?") == 0){
				System.exit(0);
			}
		}
		
		if (e.getSource().equals(btnRanking)) {
			PantallaRanking r = new PantallaRanking();
			r.setVisible(true);
			
		}
	}
	
}