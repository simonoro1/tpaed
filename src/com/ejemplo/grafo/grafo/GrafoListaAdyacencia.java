package com.ejemplo.grafo.grafo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;

import com.ejemplo.grafo.arista.AristaLista;
import com.ejemplo.grafo.vertice.VerticeLista;

public class GrafoListaAdyacencia {
	
	private static final int TAMANIO_MATRIZ=50;
	private static final int VERTICE_NULO=-1;
	private static final int INFINITO=Integer.MAX_VALUE/3;
	
	private HashMap<Integer, VerticeLista> tabla;
	private Integer indexTabla=0;
	private int cantiadSaltos=0;
	
	public GrafoListaAdyacencia() {
		super();
		tabla=new HashMap<Integer, VerticeLista>();
	}
	
	public void insertarArista(String origen,String destino,int costo) {
		
		insertarAristaInterna(esNodo(origen),esNodo(destino), costo);
	}
	
	private void insertarAristaInterna(int origen,int destino,int costo) {
	
		AristaLista aristaLista= new AristaLista(destino, costo);
		tabla.get(origen).listAdyacencia.add(aristaLista);
	}

	private VerticeLista createVertice(String origen) {
		return new VerticeLista(origen);
	}
	
	private int esNodo(String nodo) {
		
		VerticeLista verticeLista=createVertice(nodo);
		int index=buscarNodo(verticeLista);
		if(index==-1) {
			index=indexTabla;
			tabla.put(index,verticeLista );
			indexTabla++;
		}
		return index;
	}
	
	private int buscarNodo(VerticeLista verticeLista) {
		if(!tabla.isEmpty()) {
			for (Entry<Integer, VerticeLista> entry : tabla.entrySet()) {
				if(entry.getValue().nombre.equals(verticeLista.nombre)) {
					return entry.getKey(); 
				}
			}
		}
		return -1;
	}
	
	private void limpiarTabla() {

		if(!tabla.isEmpty()) {
			for(int i=0;i<tabla.size();i++) {
				tabla.get(i).ant=VERTICE_NULO;
				tabla.get(i).distancia=INFINITO;
				tabla.get(i).extra=0;
			}
		}
	}
	
	public void caminoMinimoSinPeso(int origen) {
		Queue<VerticeLista> cola=new LinkedList<VerticeLista>();
		int v;
		limpiarTabla();
		tabla.get(origen).distancia=0;
		cola.add(tabla.get(origen));
		while(!cola.isEmpty()) {
			VerticeLista verticeLista=cola.remove();
			v=buscarNodo(verticeLista);
			for (AristaLista aristaLista : verticeLista.listAdyacencia) {
				if(tabla.get(aristaLista.destino).distancia==INFINITO) {
					tabla.get(aristaLista.destino).distancia=tabla.get(v).distancia+1;
					tabla.get(aristaLista.destino).ant=v;
					cola.add(tabla.get(aristaLista.destino));
				}
			}
		}
	}
	
	//Esta es la funcion de Dijkstra
	public boolean caminoConPeso(int origen) {
		Queue<AristaLista> caminos=new LinkedList<AristaLista>();
		AristaLista verticeRec;
		int v;
		limpiarTabla();
		tabla.get(origen).distancia=0;
		caminos.add(new AristaLista(origen, 0));
		for(int vert=0;vert<indexTabla;vert++) {
			do {
				
				if(caminos.isEmpty()) {
					return true;
				}
				verticeRec=caminos.remove();
			}while(tabla.get(verticeRec.destino).extra!=0);
			v=verticeRec.destino;
			tabla.get(v).extra=1;
			VerticeLista verticeLista=tabla.get(v);
			for (AristaLista aristaLista : verticeLista.listAdyacencia) {
				int cvw=aristaLista.costo;
				if(cvw<0)
					return false;
				if(tabla.get(aristaLista.destino).distancia>tabla.get(v).distancia+cvw) {
					tabla.get(aristaLista.destino).distancia=tabla.get(v).distancia+cvw;
					tabla.get(aristaLista.destino).ant=v;
					caminos.add(new AristaLista(aristaLista.destino,tabla.get(aristaLista.destino).distancia));
				}
			}
		}
		return true;
	}
	
	public void imprimirCaminoRecorrido(int nodoDestino) {
		
		if(tabla.get(nodoDestino).ant!=VERTICE_NULO) {
			imprimirCaminoRecorrido(tabla.get(nodoDestino).ant);
		}
		System.out.println(tabla.get(nodoDestino).nombre);
	}
	
	public void imprimirCamino(int nodoDestino) {
		if(tabla.get(nodoDestino).distancia==INFINITO) {
			System.out.println(tabla.get(nodoDestino).nombre +" es incalcansable");
		}else {
			imprimirCaminoRecorrido(nodoDestino);
			System.out.println("El costo es: "+tabla.get(nodoDestino).distancia);
		}
		
	}
	
	public void imprimirCaminiRecorrido2(int nodoDestino) {
		
		Stack<String> pila= new Stack<String>();
		do {
			pila.push(tabla.get(nodoDestino).nombre);
			nodoDestino=tabla.get(nodoDestino).ant;
		}while(nodoDestino!=VERTICE_NULO);
		
		do {
			System.out.println("Destino: "+ pila.pop());
		}while(!pila.isEmpty());
	}
	
	public void imprimirTabla() {
		StringBuffer buffer= new StringBuffer();
		for (Entry entry : tabla.entrySet()) {
			buffer.append("Origen: "+entry.getKey());
			VerticeLista verticeLista=(VerticeLista)entry.getValue();
			buffer.append(" "+verticeLista.nombre + " Distanncia: "+verticeLista.distancia+" Anterior: "+verticeLista.ant);
			for (AristaLista ari : verticeLista.listAdyacencia) {
				buffer.append(" Destino: "+ari.destino + "-->");
			}
			buffer.append("\r\n");
		}
		System.out.println(buffer.toString());
	}
	
	public void imprimitDistancias() {
		StringBuffer buffer= new StringBuffer();
		for (Entry entry : tabla.entrySet()) {
			VerticeLista  verticeLista=(VerticeLista)entry.getValue();
			buffer.append("Distancias: "+verticeLista.distancia +"\r\n");
			buffer.append("Anterior: "+verticeLista.ant +"\r\n");
		}	
		System.out.println(buffer.toString());
	}
}
