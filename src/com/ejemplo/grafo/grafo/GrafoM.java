package com.ejemplo.grafo.grafo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GrafoM {
	
	private static final int INFINITO=Integer.MAX_VALUE/3;
	
	private int [][] matrizAdy=new int[5][5];
	private int [][] matrizCaminos=new int[5][5];
	private String[] vectProv= {"Bs.As","COR","SAN.L","MEND","TUCU"};
	private Queue<Integer>cola;
	
	public GrafoM() {
		super();
		
	}
	
	public void inicializarMatriz() {
		for(int f=0;f<5;f++) {
			for(int c=0;c<5;c++) {
				matrizAdy[f][c]=0;
			}
		}
	}
	
	public void insertarArista(String origen,String destino ) {
		matrizAdy[buscarNodo(origen)][buscarNodo(destino)]=1;
	}
	
	public int buscarNodo(String nodo) {
		for(int i=0;i<vectProv.length-1;i++) {
			if(vectProv[i]==nodo) {
				return i;
			}
		}
		return 0;
	}
	
	public String imprimirMatriz() {
		StringBuffer buffer= new StringBuffer();
		
		for(int f=0;f<5;f++) {
			for(int i=0;i<5;i++) {
				buffer.append(" "+ matrizAdy[f][i]+ " ");
			}
			buffer.append("\r\n");
		}
		return buffer.toString();
	}
	
	public Boolean tieneBucle() {
		
		for(int i=0;i<vectProv.length;i++) {
			if(matrizAdy[i][i]==1) {
				return true;
			}
		}
		return false;
	}
	
	public Boolean tieneCiclos() {
		for(int f=0;f<vectProv.length;f++) {
			for(int c=0;c<vectProv.length;c++) {
				if(matrizAdy[f][c]==1 && f!=c) {
					if(matrizAdy[c][f]==1) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
}
