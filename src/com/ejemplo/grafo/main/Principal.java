package com.ejemplo.grafo.main;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.ejemplo.grafo.grafo.GrafoListaAdyacencia;
import com.ejemplo.grafo.grafo.GrafoM;
import com.ejemplo.grafo.grafo.GrafoMAristaParDeValor;

import arbol.nodo.NodoArbol;
import arbol.nodo.Producto;
import arbol.operaciones.impl.ArbolOperacionImpl;
import menus.menus;

public class Principal {
	private static GrafoM grafoM=new GrafoM();
	private static GrafoMAristaParDeValor grafoMAristaParDeValor= new GrafoMAristaParDeValor();
	private static GrafoListaAdyacencia grafoListaAdyacencia= new GrafoListaAdyacencia();
	
	private static ArbolOperacionImpl consultas  = new ArbolOperacionImpl();
	
    	
	public static void main(String [] args) {
		
		//INICIALIZAMOS VARIABLES CONSULTA
		
		String[] consulta;
		String nombre, apellido, origen, fecha, destino;
		 
		consulta = menus.menuConsulta();
		LocalDateTime now = LocalDateTime.now();
		nombre = consulta[0];
		apellido = consulta[1];
		fecha = consulta[2];
		origen = consulta [3];
		destino = consulta[4];
		
		System.out.println(consulta[0]);
		
		
		//INSERTAR CONSULTA EN ARBOL BINARIO
		
		Producto producto = consultas.crearProducto(1,nombre);
		NodoArbol nodo = consultas.crearNodo(producto);

		consultas.insertarNodo(consultas.raiz, nodo); //Raiz?
		System.out.println(consultas.raiz);

		
		// BALANCEAR ARBOL

				
		
		
		
		/*
		grafoM.inicializarMatriz();
		System.out.println("Se imprime la matriz inicializada");
		System.out.println(grafoM.imprimirMatriz());
		//"Bs.As","COR","SAN.L","MEND","TUCU"
		grafoM.insertarArista("Bs.As", "COR");
		grafoM.insertarArista("Bs.As", "SAN.L");
		grafoM.insertarArista("Bs.As", "MEND");
		grafoM.insertarArista("COR", "SAN.L");
		grafoM.insertarArista("COR", "TUCU");
		grafoM.insertarArista("SAN.L", "MEND");
		grafoM.insertarArista("MEND", "COR");
		grafoM.insertarArista("MEND", "TUCU");
		System.out.println("Se imprime la matriz de adyacencia");
		System.out.println(grafoM.imprimirMatriz());
		System.out.println("Tiene Bucle: " +grafoM.tieneBucle());
		System.out.println("Tiene ciclos: " +grafoM.tieneCiclos());
		
		grafoMAristaParDeValor.inicializarMatriz();
		System.out.println("Se imprime la matriz inicializada");
		System.out.println(grafoMAristaParDeValor.imprimirMatriz());
		grafoMAristaParDeValor.insertarArista("Bs.As", "COR",700);
		grafoMAristaParDeValor.insertarArista("Bs.As", "COR",750);
		grafoMAristaParDeValor.insertarArista("Bs.As", "SAN.L",800);
		grafoMAristaParDeValor.insertarArista("Bs.As", "MEND",1500);
		grafoMAristaParDeValor.insertarArista("COR", "SAN.L",150);
		grafoMAristaParDeValor.insertarArista("COR", "TUCU",450);
		grafoMAristaParDeValor.insertarArista("SAN.L", "MEND",120);
		grafoMAristaParDeValor.insertarArista("MEND", "COR",500);
		grafoMAristaParDeValor.insertarArista("MEND", "TUCU",500);
		System.out.println("Se imprime la matriz de adyacencia Por par de Valor");
		System.out.println(grafoMAristaParDeValor.imprimirMatriz());
		*/
		
		System.out.println("Insertando Aristas");
		grafoListaAdyacencia.insertarArista("BS.AS", "COR", 700);
		//grafoMAristaParDeValor.insertarArista("Bs.As", "COR",750);
		grafoListaAdyacencia.insertarArista("BS.AS", "SAN.L",800);
		grafoListaAdyacencia.insertarArista("BS.AS", "MEND",1500);
		grafoListaAdyacencia.insertarArista("COR", "SAN.L",50);
		grafoListaAdyacencia.insertarArista("COR", "TUCU",450);
		grafoListaAdyacencia.insertarArista("SAN.L", "MEND",120);
		grafoListaAdyacencia.insertarArista("MEND", "COR",500);
		grafoListaAdyacencia.insertarArista("MEND", "TUCU",500);
		grafoListaAdyacencia.imprimirTabla();
		System.out.println("=================== Consulta de Viajes ====================");
		System.out.print("Fecha de la consulta: " + now );
		System.out.println("Nombre: " + nombre );
		System.out.println("Apellido: " + apellido );
		System.out.println("Fecha de partida: " +  fecha );
		System.out.println("============================================================");
		System.out.printf("Origen: " + origen );
		System.out.println("Destino: "+ destino);
		System.out.println("============================================================");
		System.out.println("calculando Camino M�nimo sin Peso");
		//grafoListaAdyacencia.caminoMinimoSinPeso(0);
		//grafoListaAdyacencia.caminoConPeso(0);
		grafoListaAdyacencia.caminoConPeso(0);
		grafoListaAdyacencia.imprimirCamino(2);
		System.out.println("============");
		grafoListaAdyacencia.imprimirCaminiRecorrido2(3);
		System.out.println("Imprimiendo Camino M�nimo sin Peso");
		//grafoListaAdyacencia.imprimirCaminoRecorrido(3);
		//grafoListaAdyacencia.imprimirCamino(3);
		grafoListaAdyacencia.imprimitDistancias();
		System.out.println("============================FIN CONSULTA====================");
		
	}
}

