
public class Administrador extends Usuario{

	public void actualizarStock(Integer cantidadDeProductos) {
		this.setCantidad(this.getCantidad()-cantidadDeProductos); 
	}

}
