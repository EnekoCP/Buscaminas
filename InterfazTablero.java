package Buscaminas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Insets;

public class InterfazTablero extends JFrame implements Observer, ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private cronometro c ;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JPanel panel_2;
	private int alto;
	private int ancho;
	public  JButton [][] Botones; //Matriz de botones
	public  Integer [][] elArray; //Matriz de String subyacente a la matriz de botones
	private String dificultad;
	private JButton reset;
	private JButton marcados;
	
	public InterfazTablero(String pdificultad) {
		
		c = new cronometro();
		this.añadirmeObserver(); // Se anade esta interfaz a la lista de observadores en Partida
		this.dificultad = pdificultad;
		this.setDimensiones(); //Se crea la matriz de botones correspondiente a la dificultad escogida
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Crea la ventana para mostrar la matriz de botones
		setBounds(100, 100, 635, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{422, 0};
		gbl_contentPane.rowHeights = new int[]{24, 197, 35, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(getPanel(), gbc_panel);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		contentPane.add(getPanel_2(), gbc_panel_2);
		panel.add(reset());
		panel.add(c.tiempo);
		panel.add(marcados());
		
		
		this.setVisible(true); //La ventana ahora se puede ver
		
	}
	private JButton reset() {
		if (reset == null) {
			reset = new JButton();
			ImageIcon t = new ImageIcon("cocos.png");
			reset.setIcon(t);
			reset.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			reset.setBackground(Color.yellow);
			reset.addActionListener(this);
			
		}
		return reset;
	}
	private JButton marcados() {
		if (marcados == null) {
			marcados = new JButton();
			marcados.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			marcados.setBackground(Color.red);
			marcados.setText(Partida.getMiPartida().getMarcados());
			marcados.setForeground(Color.white);
		}
		else {
			marcados.setText(Partida.getMiPartida().getMarcados());
			marcados.setForeground(Color.white);
		}
		return marcados;
	}
public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(reset)){
			Partida.getMiPartida().reset();
			}
		}
	public void setDimensiones (){ //Establece las dimensiones de la matriz de JButtons teniendo en cuenta la dificultad
		
		if (dificultad.equals("Facil")){
			this.ancho=7;
		    this.alto=10;
		}else if(dificultad.equals("Media")){
			this.ancho=10;
		    this.alto=15;
		}else{
			this.ancho=12;
		    this.alto=25;
		}
	    Botones = new JButton[alto][ancho];
	    elArray = new Integer [alto][ancho];
		
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getLblNewLabel());
			panel.setBackground(Color.black);
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("BUSCAMINAS V1                  " );
			lblNewLabel.setForeground(Color.white);
		}
		return lblNewLabel;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new GridLayout(alto, ancho, 0, 0));
		}
		
		for(int x =0; x<alto; x++){
			for(int y=0 ; y<ancho; y++){
			JButton but = new JButton();
			Botones[x][y]= but;
			panel_2.add(but);
			Integer x1 = x;
			Integer y1 = y;
			Botones[x][y].addMouseListener(new MouseListener() {


				@Override
				public void mouseClicked(MouseEvent e) {
					
				
				    Partida.getMiPartida().setTablero(alto,ancho,x1,y1);
					if (e.getButton()==1) {
						Partida.getMiPartida().clicar(x1,y1,1);
  				  	}
  				  	else if (e.getButton()==3) {	
  					  Partida.getMiPartida().clicar(x1,y1,3);
  				  }
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			
		}
	}
		panel_2.setBackground(Color.black);
	return panel_2;
}
	public void mostrarCasilla(int x,int y){
	    Botones[x][y].setText(elArray[x][y].toString());
	   Botones[x][y].setEnabled(false);
	 
	    
	 }

	@Override
	public void update(Observable o, Object arg) {
		Coordenadas coordenadas =  (Coordenadas) arg;
		if (coordenadas.res==10) {
			 Botones[coordenadas.x][coordenadas.y].setIcon(null);
			 this.marcados();
			  //Mostrar casilla vacia
		}
		else if (coordenadas.res==11) {
			 ImageIcon t = new ImageIcon("1.jpeg");
			 Botones[coordenadas.x][coordenadas.y].setIcon(t);
			 this.marcados();
			//Poner banderin en coordenadas especificadas
		}
		else if (coordenadas.res==-1) {
			Partida.getMiPartida().setAcabado();
			ImageIcon t = new ImageIcon("bomba.png");
			elArray[coordenadas.x][coordenadas.y]=coordenadas.res;
			Botones[coordenadas.x][coordenadas.y].setIcon(t);
			c.pararCrono();
			//Has perdido
			
		}
		else if (coordenadas.res==0){
			//Mostrar casilla vacia
			Botones[coordenadas.x][coordenadas.y].setEnabled(false);
			
		}

		else {
			
			elArray[coordenadas.x][coordenadas.y]=coordenadas.res;
			this.mostrarCasilla(coordenadas.x, coordenadas.y);
		}
		Partida.getMiPartida().setPuntu(1000/(c.segundos + (c.minutos * 60)));
	}
	
	private void añadirmeObserver() {
		Partida.getMiPartida().añadirObserver(this);
	}

	public String getDificultad() {
		return this.dificultad;
	}
	

}
