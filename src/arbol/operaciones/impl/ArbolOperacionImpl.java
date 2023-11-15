package arbol.operaciones.impl;

import arbol.nodo.NodoArbol;
import arbol.nodo.Producto;
import arbol.operaciones.IArbolOperacion;

public class ArbolOperacionImpl implements IArbolOperacion {
	public NodoArbol raiz;

	public ArbolOperacionImpl() {
		super();
		this.raiz = null;
	}

	@Override
	public Producto crearProducto(int cod, String descripcion) {
		return new Producto(cod, descripcion);
	}

	@Override
	public NodoArbol insertarNodo(NodoArbol nodo, NodoArbol nodoNuevo) {
		if (nodo == null)
			nodo = nodoNuevo;
		else {
			if (nodo.producto.cod > nodoNuevo.producto.cod)
				nodo.izq = insertarNodo(nodo.izq, nodoNuevo);
			else
				nodo.der = insertarNodo(nodo.der, nodoNuevo);
		}
		return nodo;
	}

	@Override
	public void recorrerArbol(int tipoRecorrido) {
		switch (tipoRecorrido) {
		case IArbolOperacion.RECORRIDO_IN_ORDEN:
			inOrden(this.raiz);
			break;
		case IArbolOperacion.RECORRIDO_PRE_ORDEN:
			preOrden(this.raiz);
			break;
		case IArbolOperacion.RECORRIDO_POST_ORDEN:
			postOrden(this.raiz);
			break;
		}
	}

	@Override
	public NodoArbol crearNodo(Producto prod) {
		return new NodoArbol(prod, null, null);
	}
	
	@Override
	public int altura(NodoArbol nodo) {
		if(nodo==null) 
			return -1;
		else
			return 1+Math.max(altura(nodo.izq), altura(nodo.der));
	}
	
	public void inOrden(NodoArbol nodo) {
		if(nodo == null)
			System.out.println("vacio");

		if (nodo.izq != null)
			inOrden(nodo.izq);

		System.out.println(nodo.producto.cod + " " + nodo.producto.descripcion);

		if (nodo.der != null)
			inOrden(nodo.der);
	}

	private void preOrden(NodoArbol nodo) {

		System.out.println(nodo.producto.cod + " " + nodo.producto.descripcion);

		if (nodo.izq != null)
			inOrden(nodo.izq);

		if (nodo.der != null)
			inOrden(nodo.der);
	}

	private void postOrden(NodoArbol nodo) {

		if (nodo.izq != null)
			inOrden(nodo.izq);

		if (nodo.der != null)
			inOrden(nodo.der);

		System.out.println(nodo.producto.cod + " " + nodo.producto.descripcion);
	}
	
	public NodoArbol balancearArbol(NodoArbol nodo) {
		if(nodo!=null) {
			if((altura(nodo.izq)-altura(nodo.der))==2) {
				if(altura(nodo.izq.izq)>= altura(nodo.izq.der)) 
					return rotacionSimpleIzquierda(nodo);
				else
					return rotacionDobleIzqDer(nodo);
			}else {
				if((altura(nodo.der)-altura(nodo.izq))==2) {
					if(altura(nodo.der.der)>= altura(nodo.der.izq)) 
						return rotacionSimpleDerecha(nodo);
					else
						return rotacionDobleDerIzq(nodo);
				}
			}
		}
		return nodo;
	}
	
	private NodoArbol rotacionSimpleIzquierda(NodoArbol k2) {
		NodoArbol k1=k2.izq;
		k2.izq=k1.der;
		k1.der=k2;
		return k1;
	}
	
	private NodoArbol rotacionSimpleDerecha(NodoArbol k1) {
		NodoArbol k2=k1.der;
		k1.der=k2.izq;
		k2.izq=k1;
		return k2;
	}
	
	private NodoArbol rotacionDobleDerIzq(NodoArbol k3) {
		k3.der=rotacionSimpleIzquierda(k3.izq);
		return rotacionSimpleDerecha(k3);
	}
	
	private NodoArbol rotacionDobleIzqDer(NodoArbol k3) {
		k3.izq=rotacionSimpleDerecha(k3.der);
		return rotacionSimpleIzquierda(k3);
	}
}
