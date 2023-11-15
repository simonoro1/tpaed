package com.ejemplo.grafo.vertice;

import java.util.ArrayList;
import java.util.List;

import com.ejemplo.grafo.arista.AristaLista;

public class VerticeLista implements Comparable<String>{

	public String nombre;
	public List<AristaLista> listAdyacencia;
	public int distancia;
	public int ant;
	public int extra;
	
	public VerticeLista(String nombre) {
		super();
		this.nombre = nombre;
		this.listAdyacencia= new ArrayList<AristaLista>();
	}

	@Override
	public int compareTo(String o) {
		
		return (this.nombre==o)?1:0;
	}
	
}
