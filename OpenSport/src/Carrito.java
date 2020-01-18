import java.util.List;
import java.util.ArrayList;

public class Carrito {
	private Cliente unCliente;
	private List<Producto> listaDeProductos;
	
	public Carrito(Cliente nombreCliente) {
		this.unCliente = nombreCliente;
		this.listaDeProductos = new ArrayList<>();
	}
	
	public Cliente getUnCliente() {
		return unCliente;
	}
	
	public List<Producto> getListaDeProductos() {
		return listaDeProductos;
	}
	
	@Override
	public String toString() {
		return "Carrito [unCliente=" + unCliente + ", listaDeProductos=" + listaDeProductos + "]";
	}

	public void agregarUnProducto(Producto unProducto) {
		this.listaDeProductos.add(unProducto);
	}
	
	public void quitarUnProducto(Producto unProducto) {
		this.listaDeProductos.remove(unProducto);
	}
	
	public Double iniciarCompra() {
		Double totalDePrecios = 0.00;
				for(int i = 0; i < listaDeProductos.size();i++) {
					totalDePrecios = totalDePrecios + listaDeProductos.get(i).getPrecio();
				};
		return totalDePrecios;
	}
	
}
