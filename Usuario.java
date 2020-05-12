package Buscaminas;

public class Usuario {
	//atributos
	private String nombre;
	private int puntuacion;
	
	
	//constructora
	public Usuario (String pNombre, int pPuntuacion){
		this.nombre=pNombre;
		this.puntuacion=pPuntuacion;
	}
	
	
	//otros metodos
	public String getNombre(){
		return this.nombre;
	}
	
	public int getPuntuacion(){
		return this.puntuacion;
	}
}
