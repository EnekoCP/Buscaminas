package Buscaminas;

import java.awt.Color;

public class cronometro implements Runnable{

Thread crono;
javax.swing.JLabel tiempo = new javax.swing.JLabel();
int minutos=0, segundos=0, horas=0;

public cronometro() {

	crono = new Thread(this);
	crono.start();

}

public void run()
	{ try {
		for(;;) {
			if(segundos==59) { segundos=0; minutos++; }
			if(minutos==59) { minutos=0; horas++; }
			segundos++;
			tiempo.setText("                              TIEMPO DE JUEGO : " + horas+":"+minutos+":"+segundos +"            ");
			tiempo.setForeground(Color.white);
			crono.sleep(1000); }
	}
	catch (InterruptedException e) { System.out.println(e.getMessage()); }
	}
public void pararCrono() {
	crono.stop();
}
}