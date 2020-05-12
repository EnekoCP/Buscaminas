package Buscaminas;

import java.util.*;

public class Partida extends Observable{
	private PantallaInicial p;
	private static Partida miPartida;
	private String nombre;
	private int puntuacion;
	private Tablero tablero;
	private Integer marcados = 0;
	private ArrayList <Observer> listObservadores ;
	private boolean acabado;
	private int cont;
	
	private Partida(){ //Inicializa el contador de banderas, el tiempo, crea la lista de observers y se declara como no acabado
		this.cont = 1;
		this.acabado = false;
		this.listObservadores = new ArrayList<Observer>();
		
		
	}
 
	public static Partida getMiPartida(){
		if (miPartida == null){
			miPartida = new Partida();
		}
		return miPartida;
		}
 
	public PantallaInicial empezar() {  //Crea una nueva pantalla inicial
		 p = new PantallaInicial();
		 return p;
		
	}
	public void setNombre(String pnombre) { //Establece el nombre del jugador
		this.nombre = pnombre;
	}
	public void setPuntu(int ppuntu) { //Establece la puntuacion del jugador
		this.puntuacion = ppuntu;
	}
	
	private void terminar(boolean pB){ //pB indica si la partida se ha ganado o no
		
		if (pB) {
			if (cont == 1) {
			new PantallaFinal("Victoria",this.puntuacion);
			Ranking.getMiRanking().annadirOrdenado(new Usuario(this.nombre , this.puntuacion));
			cont++;
			}
		}
		else {
			new PantallaFinal("Derrota",this.puntuacion);
		}
		
	}
	
	public void reset(){		//Devuelve los valores basicos a su estado por defecto, vacia y llena la lista de observers y pone el tablero a null
		this.marcados=0; 		//para que al siguiente click se genere uno nuevo al llamar a setTablero desde InterfazTablero
		this.cont = 1;
		this.acabado= false;
		this.tablero=null;
		InterfazTablero i=(InterfazTablero) listObservadores.get(0);
		Iterator<Observer> itr=listObservadores.iterator();
		while(itr.hasNext()) {
			InterfazTablero o=(InterfazTablero) itr.next();
			o.setVisible(false);
		}
		listObservadores=new ArrayList<Observer>();
		listObservadores.add(new InterfazTablero(i.getDificultad()));
	}
	
	public void clicar(int pX, int pY, int pClick){
		if (acabado == false) {
		int res=this.tablero.clicar(pX,pY,pClick);   //Pasa la llamada a la clase tablero y recoge el output
		if (res == 11 && marcados == this.tablero.getAlto()) {
			this.tablero.clicar(pX,pY,3);
			res = 9;
		}
		if((res != 9)) { //9 es el codigo de inaccion
			Coordenadas d = new Coordenadas(res , pX ,pY);
			
			if (res==0) { //No hay ninguna bomba en un cuadrado de 3x3
			this.expandir(pX, pY, pClick);
			}
				
			else if(res==-1) {//La casilla clicada es bomba
				this.notify(d);
				this.terminar(false);
			}
			else if(res == 11) {//Se pone banderin
				if (marcados >  this.tablero.getAlto()) {
					marcados =  this.tablero.getAlto()-1;
				}else {
				marcados++;}
			}
			else if(res == 10 ) {
				if (marcados < 0) {
					marcados = 0;
				}
				else {
				marcados--;}
			}
			//Se notifica de las operaciones realizadas a la interfaz grafica
			
			if(res == 11 && marcados <= this.tablero.getAlto()) {
				this.notify(d);
			}
			if (res != 11) {
				this.notify(d);
			}
			if (this.tablero.ganado()) {
				this.terminar(true);}
		}
		}
		
	}
	private void expandir(int pX, int pY, int pClick){ //Desvela recursivamente casillas hasta encontrar la frontera con alguna bomba
		
		if(pX==0 && pY==0) {
			this.clicar(pX+1, pY, pClick);
			this.clicar(pX, pY+1, pClick);
			this.clicar(pX+1, pY+1, pClick);
		}
		else if(pX==0 && pY==this.tablero.dimY()-1) {
			this.clicar(pX+1, pY, pClick);
			this.clicar(pX, pY-1, pClick);
			this.clicar(pX+1, pY-1, pClick);
		}
		else if(pX==this.tablero.dimX()-1 && pY==0) {
			this.clicar(pX-1, pY, pClick);
			this.clicar(pX, pY+1, pClick);
			this.clicar(pX-1, pY+1, pClick);
		}
		else if(pX==this.tablero.dimX()-1 && pY==this.tablero.dimY()-1) {
			this.clicar(pX, pY-1, pClick);
			this.clicar(pX-1, pY, pClick);
			this.clicar(pX-1, pY-1, pClick);
		}
		else if(pX==0) {
			this.clicar(pX, pY-1, pClick);
			this.clicar(pX+1, pY, pClick);
			this.clicar(pX, pY+1, pClick);
			this.clicar(pX+1, pY-1, pClick);
			this.clicar(pX+1, pY+1, pClick);
		}
		else if(pX==this.tablero.dimX()-1) {
			this.clicar(pX, pY-1, pClick);
			this.clicar(pX-1, pY, pClick);
			this.clicar(pX, pY+1, pClick);
			this.clicar(pX-1, pY-1, pClick);
			this.clicar(pX-1, pY+1, pClick);
		}
		else if(pY==0) {
			this.clicar(pX-1, pY, pClick);
			this.clicar(pX, pY+1, pClick);
			this.clicar(pX+1, pY, pClick);
			this.clicar(pX+1, pY+1, pClick);
			this.clicar(pX-1, pY+1, pClick);
		}
		else if(pY==this.tablero.dimY()-1) {
			this.clicar(pX-1, pY, pClick);
			this.clicar(pX, pY-1, pClick);
			this.clicar(pX+1, pY, pClick);
			this.clicar(pX+1, pY-1, pClick);
			this.clicar(pX-1, pY-1, pClick);
		}
		else {
			this.clicar(pX-1, pY-1, pClick);
			this.clicar(pX-1, pY, pClick);
			this.clicar(pX-1, pY+1, pClick);
			this.clicar(pX, pY-1, pClick);
			this.clicar(pX, pY+1, pClick);
			this.clicar(pX+1, pY-1, pClick);
			this.clicar(pX+1, pY, pClick);
			this.clicar(pX+1, pY+1, pClick);
		
		}
	}

	private void notify( Coordenadas d) {
		
		Iterator<Observer> it = this.listObservadores.iterator();
	
		
		while(it.hasNext()) {
			Observer o = it.next();
			o.update(this, d);
		}
	}
	public void setTablero(int pAncho, int pAlto, int pX, int pY) { //Llamado en cada click, se activa solo cuando el tablero es null,
		//generando un nuevo tablero con una nueva distribucion
		if (this.tablero==null) {
			this.tablero = new Tablero(pAncho, pAlto, pX, pY);
		}
	}
	public void añadirObserver(Observer o) {
		this.listObservadores.add(o);
	}
	public Tablero getTablero() {
		return this.tablero;
	}
	public void setAcabado() {
		this.acabado=true;
	}
	public String getMarcados() { //Para que no se pueda seguir clicando una vez terminado el juego
		return this.marcados.toString();
	}
}
