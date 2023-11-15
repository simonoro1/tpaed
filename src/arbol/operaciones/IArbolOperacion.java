package arbol.operaciones;

import arbol.nodo.NodoArbol;
import arbol.nodo.Producto;

public interface IArbolOperacion {

	public static int RECORRIDO_IN_ORDEN = 1;

	public static int RECORRIDO_PRE_ORDEN = 2;

	public static int RECORRIDO_POST_ORDEN = 3;

	public Producto crearProducto(int cod, String descripcion);

	public NodoArbol crearNodo(Producto prod);
	
	public int altura(NodoArbol nodo);

	public NodoArbol insertarNodo(NodoArbol nodo,NodoArbol nodNuevo);

	public void recorrerArbol(int tipoRecorrido);
	
	public NodoArbol balancearArbol(NodoArbol nodo);

}
