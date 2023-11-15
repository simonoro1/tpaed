package com.ejemplo.grafo.arista;

import java.util.Arrays;

public class AristaParValor {
	
	public int countDestino;
	public int[] costos;
	
	public AristaParValor() {
		super();
	}
	
	public AristaParValor(int destinos, int[] costos) {
		super();
		this.countDestino = destinos;
		this.costos = costos;
	}
	
	
	public String toString() {
		return "( "+this.countDestino+ ","+Arrays.toString(costos)+" )";
	}
}
