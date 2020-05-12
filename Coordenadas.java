package Buscaminas;

public class Coordenadas {  //Esta clase existe para poder mandar varios valores mediante un notify/update
	public int x;
	public int y;
	public Integer res;
	
	public Coordenadas(Integer res ,int x ,int y) {
		this.res = res;
		this.x = x;
		this.y = y;
	}
}
