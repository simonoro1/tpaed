package arbol.nodo;

public class NodoArbol {
	
	public Producto producto;
	public NodoArbol izq;
	public NodoArbol der;
	
	
	public NodoArbol(Producto producto, NodoArbol izq, NodoArbol der) {
		super();
		this.producto = producto;
		this.izq = izq;
		this.der = der;
	}
	
	
}
