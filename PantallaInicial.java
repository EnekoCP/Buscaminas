package Buscaminas;

import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;


import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class PantallaInicial extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblHappyMineswiping;
	private JLabel lblNombre;
	private JTextField textField;
	private JLabel lblDificultad;
	private JRadioButton rdbtnFacil;
	private JRadioButton rdbtnMedio;
	private JPanel panel_4;
	private JButton btnJugar;
	private JPanel panel_5;
	private JRadioButton rdbtnAvanzado;
	private JPanel panel_6;
	private String dificultad;



	public PantallaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 0, 0, 0));
		contentPane.add(getPanel_1());
		contentPane.add(getPanel_2());
		contentPane.add(getPanel_3());
		contentPane.add(getPanel());
		ButtonGroup g = new ButtonGroup();
		g.add(rdbtnFacil);
		g.add(rdbtnMedio);
		g.add(rdbtnAvanzado);
		
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

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(0, 3, 0, 0));
			panel.add(getPanel_4());
			panel.add(getBtnJugar());
			panel.add(getPanel_5());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
			flowLayout.setHgap(3);
			flowLayout.setVgap(3);
			panel_1.add(getLblHappyMineswiping());
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new GridLayout(2, 4, 0, 0));
			panel_2.add(getLblNombre());
			panel_2.add(getTextField());
			panel_2.add(getPanel_6());
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(new GridLayout(0, 4, 0, 0));
			panel_3.add(getLblDificultad());
			panel_3.add(getRdbtnFacil());
			panel_3.add(getRdbtnMedio());
			panel_3.add(getRdbtnAvanzado());
		}
		return panel_3;
	}
	private JLabel getLblHappyMineswiping() {
		if (lblHappyMineswiping == null) {
			lblHappyMineswiping = new JLabel("Happy Mineswiping BETA");
			lblHappyMineswiping.setVerticalAlignment(SwingConstants.BOTTOM);
			lblHappyMineswiping.setHorizontalAlignment(SwingConstants.CENTER);
			lblHappyMineswiping.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 22));
		}
		return lblHappyMineswiping;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre:");
			lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
			lblNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		}
		return lblNombre;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
			textField.setColumns(10);
		}
		return textField;
	}
	public JLabel getLblDificultad() {
		if (lblDificultad == null) {
			lblDificultad = new JLabel("Dificultad:");
			lblDificultad.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		}
		return lblDificultad;
	}
	private JRadioButton getRdbtnFacil() {
		if (rdbtnFacil == null) {
			rdbtnFacil = new JRadioButton("Facil");
			rdbtnFacil.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			rdbtnFacil.addActionListener(this);
		}
		return rdbtnFacil;
	}
	private JRadioButton getRdbtnMedio() {
		if (rdbtnMedio == null) {
			rdbtnMedio = new JRadioButton("Medio");
			rdbtnMedio.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			rdbtnMedio.addActionListener(this);
		}
		return rdbtnMedio;
	}
	private JRadioButton getRdbtnAvanzado() {
		if (rdbtnAvanzado == null) {
			rdbtnAvanzado = new JRadioButton("Avanzado");
			rdbtnAvanzado.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			rdbtnAvanzado.addActionListener(this);
		}
		return rdbtnAvanzado;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
		}
		return panel_4;
	}
	public void actionPerformed(ActionEvent e) {
		
		if (getNombreJugador().equals("") && e.getSource().equals(btnJugar)){
			JOptionPane.showMessageDialog(rootPane, "Tienes que meter un nombre de usuario antes de escoger la dificultad.");
		}else{
				if (rdbtnFacil.isSelected() && e.getSource().equals(btnJugar)){
					this.setVisible(false);
					dificultad = "Facil";
					 new InterfazTablero(dificultad);
				}else if(rdbtnMedio.isSelected() && e.getSource().equals(btnJugar)){
					this.setVisible(false);
					dificultad = "Media";
					 new InterfazTablero(dificultad);
				}else if(rdbtnAvanzado.isSelected() && e.getSource().equals(btnJugar)){
					this.setVisible(false);
					dificultad = "Avanzada";
					new InterfazTablero(dificultad);
					}
				
				this.getNomJugador();
			}
			
		}
	
	private JButton getBtnJugar() {
		if (btnJugar == null) {
			btnJugar = new JButton("Jugar!");
			btnJugar.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			btnJugar.addActionListener(this);
			
		}
		return btnJugar;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
		}
		return panel_5;
	}
	
	public String getNombreJugador(){
		return getTextField().getText();
	}
	
	public void getNomJugador(){
		Partida.getMiPartida().setNombre(getTextField().getText());
	}
	
	private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
		}
		return panel_6;
	}

	}

