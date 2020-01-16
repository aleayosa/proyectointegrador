import java.util.List;

public class Inventario {
	private List<Producto> stock;
	
	public Inventario(List<Producto> stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Inventario [stock=" + stock + "]";
	}

	
	public List<Producto> getStock() {
		return stock;
	}


	public void setStock(List<Producto> stock) {
		this.stock = stock;
	}


	
}
