package com.ejemplo.grafo.arista;

public class AristaLista implements Comparable<Integer> {
	
	public int destino;
	public int costo;
	
	public AristaLista(int destino, int costo) {
		super();
		this.destino = destino;
		this.costo = costo;
	}

	@Override
	public int compareTo(Integer o) {
		
		return (this.costo<o)?-1:((this.costo>o)?1:0);
	}
	
	
}
