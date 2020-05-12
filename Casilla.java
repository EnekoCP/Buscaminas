package Buscaminas;

public class Casilla {
	private Estado estado;
	private int infoCasilla ;
	
	public Casilla(int info) {
		this.estado=new Tapado();
		this.infoCasilla=info;
	}
	public int clickIzq() {
		return this.estado.clickIzq(this);
	}
	public int clickDer() {
		return this.estado.clickDer(this);
	}
	public void cambiarEstado(Estado pEstado) {
		this.estado=pEstado;
	}
	public int getInfoCasilla() {
		return this.infoCasilla;
	}
	public void incrementar(){ this.infoCasilla++;}
	
	public boolean clear() {
		return (this.estado instanceof Destapado);
	}
}
