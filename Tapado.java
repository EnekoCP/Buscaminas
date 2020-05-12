package Buscaminas;

public class Tapado implements Estado{
	public Tapado() {
		
	}
	public int clickIzq(Casilla pCasilla) {
		pCasilla.cambiarEstado(new Destapado());
		return pCasilla.getInfoCasilla();
	}
	
	public int clickDer(Casilla pCasilla) { //Devuelve 11, colocar banderin
		pCasilla.cambiarEstado(new Marcado());
		return 11;
	}
}
