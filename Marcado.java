package Buscaminas;

public class Marcado implements Estado{
	public Marcado() {
		
	}
	public int clickIzq(Casilla pCasilla) {
		
		
		return 9;
		
	}
	
	public int clickDer(Casilla pCasilla) {
		pCasilla.cambiarEstado(new Tapado());
		return 10;
		
	}
}

