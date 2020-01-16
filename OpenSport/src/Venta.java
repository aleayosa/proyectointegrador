
public class Venta {
	private Carrito unCarrito;
	
	public Venta(Carrito unCarrito) {
		this.unCarrito = unCarrito;
	}

	@Override
	public String toString() {
		return "Venta [unCarrito=" + unCarrito + "]";
	}

	public Carrito getUnCarrito() {
		return unCarrito;
	}
	
	/*
	public void unaInvento(Carrito unCarrito) {
		actualizarStock(unCarrito.getListaDeProductos().size());
		
	}*/
}
