
public class Administrador extends Usuario{
	private Inventario elInventario;
	

	public Administrador(Integer unId, String nombre, String apellido, String email, String contrasenia, Inventario elInventario) {
		super(unId, nombre, apellido, email, contrasenia);
		this.elInventario = elInventario;
	}


	public Inventario getElInventario() {
		return elInventario;
	}

	@Override
	public String toString() {
		return "Administrador [elInventario=" + elInventario + "]";
	}


	public void actualizarStock(Integer cantidadDeProductos, Producto elProducto) {
		elInventario.modificaCantidad(cantidadDeProductos, elProducto);
	}

}
