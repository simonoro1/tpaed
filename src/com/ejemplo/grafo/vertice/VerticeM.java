package com.ejemplo.grafo.vertice;

import java.util.ArrayList;
import java.util.List;

public class VerticeM {

	public String nombre;
	public List<String> adyacente;
	
	public int dist;
	public int ant;
	public int aux;
	
	public VerticeM(String nombre) {
		super();
		this.nombre = nombre;
		this.adyacente= new ArrayList<String>();
	}
	
	
}
