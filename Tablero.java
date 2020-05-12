package Buscaminas;

public class Tablero {
		
		
		 private Casilla[][] matriz ;
		 private int ancho;
		 private int alto;
	
		 
		 public Tablero(int pAncho ,int pAlto, int pX, int pY) {
			 this.ancho= pAncho;
			 this.alto = pAlto;
			 this.matriz = new Casilla [pAncho][pAlto];
			 this.generarCasillas(alto , pX, pY);
			
		 }
		 
		public int getAlto() {
			return this.alto;
		}
		 public void generarCasillas (int numBombas, int pX, int pY) {
			 for(int h = 0 ; h<numBombas ; h++) {
				 this.generarBomba(pX, pY);
			 }
			 
			 this.rellenar();
			 this.comprobar();
		 }
		 private void generarBomba(int px, int py) {
			 int i = (int) Math.floor(Math.random()*(ancho)+0);
			 int z = (int) Math.floor(Math.random()*(alto)+0);
			 
			 //Comprueba que las coordenadas entren en la matriz y no sean la primera casilla clicada ni sus adyacentes
			 //Si no cumple las condiciones se hace una llamada recursiva hasta que las cumpla
			 if(z>=0 && i>=0 && z<alto && i<ancho && ((i!=px-1 && z!=py-1)&&(i!=px-1 && z!=py)&&(i!=px-1 && z!=py+1)&&(i!=px && z!=py-1)&&(i!=px && z!=py)&&(i!=px && z!=py+1)&&(i!=px+1 && z!=py-1)&&(i!=px+1 && z!=py)&&(i!=px+1 && z!=py+1))) {
				 if(matriz[i][z]==null) {
					 matriz[i][z] = new Casilla(-1);}
				 else {
					 this.generarBomba(px,py);
				 }
			 }
			 else {
				 this.generarBomba(px,py);
			 }
				 
		 }
		
		private void rellenar() { //Genera las casillas que no son bomba
			 for (int i=0;i<ancho;i++){
			       for (int z=0;z<alto;z++){
			    	 if(matriz[i][z]==null) {
			    	   matriz[i][z] = new Casilla(0); 
			    			   }
			       	}
			       }
		}
		 private void comprobar() { //Pone los numeros correspondientes en cada casilla
			 
			 for (int i=0;i<ancho;i++){
			       for (int z=0;z<alto;z++){
			        
			       if (matriz[i][z].getInfoCasilla() == -1){//Cuando encuentra una bomba
			        if  (z>=0 && i>=0 && z<alto && i<ancho){//Si las coordenadas entran en la matriz
			        	// Para cada casilla adyacente, si no es bomba y si entra en la matriz, se incrementa en 1 su numero
			           		if ((z-1>=0) &&  matriz[i][z-1].getInfoCasilla() != -1){
			                  matriz[i][z-1].incrementar();
			                 }
			                 if ((z-1>=0) && (i-1>=0) && matriz[i-1][z-1].getInfoCasilla() != -1 ){
			                	 matriz[i-1][z-1].incrementar();
			                 }
			                 if ((z-1>=0) && (i+1 < ancho) && matriz[i+1][z-1].getInfoCasilla() != -1){
			                	 matriz[i+1][z-1].incrementar();
			                 }
			                 if ((z+1 < alto) && matriz[i][z+1].getInfoCasilla() != -1){
			                	 matriz[i][z+1].incrementar();
			                 }
			                 if ((z+1 < alto) && (i+1 < ancho) && matriz[i+1][z+1].getInfoCasilla() != -1){
			                	 matriz[i+1][z+1].incrementar();
			                 }
			                 if ((z+1 < alto) && (i-1 >=0) && matriz[i-1][z+1].getInfoCasilla() != -1){
			                	 matriz[i-1][z+1].incrementar();
			                 }
			                 if ((i+1 < ancho) && matriz[i+1][z].getInfoCasilla() != -1){
			                	 matriz[i+1][z].incrementar();
			                 }
			                 if ((i-1 >=0) && matriz[i-1][z].getInfoCasilla() != -1){
			                	 matriz[i-1][z].incrementar();
			                 }
			             
			  			    	   
			  			       }
			  		    }
								          
			        	}         
			        }  
			
		 }
		 public Casilla[][] getTablero(){
			 return this.matriz;
		 }
		 
		 public int clicar(int x, int y , int click) { //Propaga la llamada a la casilla correspondiente y devuelve su mismo output
			Casilla c = this.matriz[x][y];
			if(click == 1) {
				return c.clickIzq();
			}else {
				
				return c.clickDer();
			}
			 				 
		 }
		
		public int dimX() {
			return this.ancho;
		}
		
		public int dimY() {
			return this.alto;
		}
		
		public boolean ganado() {//Comprueba que todas las casillas que no sean bomba estén desveladas y que todas las casillas bomba esten tapadas o marcadas
			boolean ganar=true;
			for (int i= 0;i<this.matriz.length;i++) {
				for (int j =0;j<this.matriz[0].length;j++) {
					ganar=ganar&&((this.matriz[i][j].getInfoCasilla()==-1&&!this.matriz[i][j].clear())||(this.matriz[i][j].getInfoCasilla()!=-1&&this.matriz[i][j].clear()));
				}
			}
			return ganar;
		}
		
}
