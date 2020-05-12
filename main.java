package Buscaminas;

import java.awt.EventQueue;

public class main {
	private static main miMain=new main();
	
private main(){
		
	}

public static main getMain(){

		return miMain;
	}
	
public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaInicial frame = Partida.getMiPartida().empezar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
