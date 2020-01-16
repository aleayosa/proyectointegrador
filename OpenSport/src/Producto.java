
public class Producto {
	private String marca;
	private String nombre;
	private Integer id;
	private Double precio;
	private String categoria;
	private Integer cantidad;
	
	public Producto(String marca, String nombre, Integer unId, Double precio, String categoria, Integer cantidad) {
		this.categoria = categoria;
		this.id = unId;
		this.marca = marca;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Producto [marca=" + marca + ", nombre=" + nombre + ", id=" + id + ", precio=" + precio + ", categoria="
				+ categoria + ", cantidad=" + cantidad + "]";
	}



	public String getMarca() {
		return marca;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getId() {
		return id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public String getCategoria() {
		return categoria;
	}
	
	public void setPrecio(Double unPrecio) {
		this.precio = unPrecio;
	}
	
	public void setCantidad(Integer unaCantidad) {
		this.cantidad = unaCantidad;
	}
	
	public boolean equals(Object compara) {
		Producto algoAComparar = (Producto) compara;
		Boolean esIgual = false;
		if(this.id.equals(algoAComparar.id)) {
			esIgual = true;
		} return esIgual;
	}
}
