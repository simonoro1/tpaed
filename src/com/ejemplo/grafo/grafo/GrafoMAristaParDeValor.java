package com.ejemplo.grafo.grafo;

import com.ejemplo.grafo.arista.AristaParValor;

public class GrafoMAristaParDeValor  {
	
	private AristaParValor [][] matrizAdy=new AristaParValor[5][5];
	private String[] vectProv= {"Bs.As","COR","SAN.L","MEND","TUCU"};
	private AristaParValor aristaParValor;
	
	public GrafoMAristaParDeValor() {
		super();
	}
	
	public void inicializarMatriz() {
		for(int f=0;f<5;f++) {
			for(int c=0;c<5;c++) {
				int [] cost= {};
				matrizAdy[f][c]=new AristaParValor(0,cost );
			}
		}
	}
	
	public void insertarArista(String origen,String destino,int costo ) {
		int f=buscarNodo(origen);
		int c=buscarNodo(destino);
		AristaParValor aristaParValorTemp=matrizAdy[f][c];
		aristaParValor=new AristaParValor();
		
		if(aristaParValorTemp.costos.length==0) {
			int[] cost= {costo};
			aristaParValor.costos=cost;
		}else {
			aristaParValor.costos=cargarCostosArista(aristaParValorTemp.costos.length+1, aristaParValorTemp.costos, costo);
		}
		aristaParValor.countDestino=aristaParValor.costos.length;
		matrizAdy[f][c]=aristaParValor;
	}
	
	private int[] cargarCostosArista(int tamanio,int[] costosViejo,int costoNuevo) {
		int[] cost=new int[tamanio];
		
		for(int f=0;f<costosViejo.length;f++) {
			cost[f]=costosViejo[f];
		}
		cost[tamanio-1]=costoNuevo;
		return cost;
	}
	
	public int buscarNodo(String nodo) {
		for(int i=0;i<vectProv.length;i++) {
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
				buffer.append(" "+ matrizAdy[f][i].toString()+ " ");
			}
			buffer.append("\r\n");
		}
		return buffer.toString();
	}
	
	public String calcularCaminiMinimo() {
		return "";
	}
}
