package Buscaminas;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ranking {
	

	
	//atributos
	private ArrayList<Usuario> lista;
	private static Ranking miRanking;
	
	//constructora
	
	private Ranking() {
		this.lista=new ArrayList<Usuario>();
		this.cargarDatos();
	}
	
	public static Ranking getMiRanking() {
		if (miRanking == null) {
			miRanking = new Ranking();
		}
		return miRanking;
	}
	
	//otros metodos
	public void annadirUsuario (Usuario pUsuario){
		this.lista.add(pUsuario);
	}
	
	
	
	private Iterator<Usuario> getIterador()
	{
		return this.lista.iterator();
	}

	
	public void mostrar(){
		Usuario u=null;
		Iterator<Usuario> itr=this.getIterador();
		while (itr.hasNext()){
			u=itr.next();
			System.out.println(u.getNombre()+u.getPuntuacion());
			
		}
	}
	
	
		//Metodo anadido para visualizar los datos en ranking
		//Va enlazando todos los datos de uno en uno y los devuelve para mostrar en RankingPantalla
	public String jugadorYPuntuacion(){
		String ranking=""; 
		int i = 0;
		Usuario u=null;
		Iterator<Usuario> itr=this.getIterador();
		while (itr.hasNext() && i<10){
			u=itr.next();
			i++;
			ranking=ranking+(i+ ". " + u.getNombre()+" "+u.getPuntuacion()+"\n");
				
		}
		return ranking;
		
	}
	//Necesitamos un metodo para cargar desde un archivo de texto los nombres y otro para escribirlos
	//Para que se queden guardados

	private void escribirDatos () {
		try (FileWriter fileWriter = new FileWriter("C:\\TEMP\\Ranking.txt" , false)) {
			Usuario u=null;
			Iterator<Usuario> itr=this.getIterador();
			while (itr.hasNext()) {
					u=itr.next();
					fileWriter.write(u.getNombre()+" "+u.getPuntuacion()+"\n");
				}
		}catch (IOException e) {
			System.out.println("Error " + e);
		}
	}
	
	public void cargarDatos() {
        try (FileReader fileReader = new FileReader("C:\\TEMP\\Ranking.txt")) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
            	String linea = scanner.nextLine();
            	String[] lineaSeparada = linea.split(" ");
            	String usuario = lineaSeparada[0];
            	int puntuacion = Integer.parseInt(lineaSeparada[1]);
            	Usuario u = new Usuario(usuario , puntuacion);
            	this.lista.add(u);
            	System.out.println("Leyendo...");
			}
            scanner.close();
            }
        catch (IOException e) {
            System.out.println("Error " + e);
        }
    }
	
	//Aqui tiene que ser añadir ordenado
	//Cargar los datos al arraylist
	//mirar la posicion
	//y añadir ordenado
	public void annadirOrdenado(Usuario pUsuario){
		//FALTA MIRAR SI ES EL MISMO USUARIO CAMBIARLE LA PUNTUACION Y NO AÑADIR EL MISMO NOMBRE
		Usuario aux=null;
		boolean salir=false;
		int cont=0;
		Iterator<Usuario> itr=this.getIterador();
		if (this.lista.size()==0){
			this.annadirUsuario(pUsuario);
			}
		else {
		
		while (itr.hasNext() && !salir){
			aux=itr.next();
			if (pUsuario.getPuntuacion()>aux.getPuntuacion()){
				salir=true;
			}else {
				cont=cont+1;
			}
			
		}
		this.lista.add(cont, pUsuario);
		}
		escribirDatos();
		}
	}
