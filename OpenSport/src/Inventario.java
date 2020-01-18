import java.util.ArrayList;
import java.util.List;

public class Inventario {
	private List<Producto> stock;
	private String nombre;
	
	public Inventario(String elNombre) {
		this.stock = new ArrayList<>();
		this.nombre = elNombre;
	}

	@Override
	public String toString() {
		return "Inventario [stock=" + stock + ", nombre=" + nombre + "]";
	}


	public List<Producto> getStock() {
		return stock;
	}

	public String getNombre() {
		return nombre;
	}
	public void setStock(List<Producto> stock) {
		this.stock = stock;
	}

	public void agregarUnProducto(Producto unProducto) {
		this.stock.add(unProducto);
	}
	
	public void quitarUnProducto(Producto unProducto) {
		this.stock.remove(unProducto);
	}

	public void modificaCantidad(Integer unaCantidad, Producto elProducto) {
		if(stock.contains(elProducto)){
			elProducto.setCantidad(elProducto.getCantidad()+unaCantidad);
		}else {
			System.out.println("El producto no está inventariado");
		}
	}
	
}