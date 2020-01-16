
public class Cliente extends Usuario{
	private Venta unaVenta;
	private Integer dni;
	
	public Cliente(Integer unId, String nombre, String apellido, String email, String contrasenia, Venta unaVenta,
			Integer dni) {
		super(unId, nombre, apellido, email, contrasenia);
		this.unaVenta = unaVenta;
		this.dni = dni;
	}

	public Venta getUnaVenta() {
		return unaVenta;
	}

	public Integer getDni() {
		return dni;
	}

	@Override
	public String toString() {
		return "Cliente [unaVenta=" + unaVenta + ", dni=" + dni + "]";
	}
	
	public boolean equals(Object compara) {
		Cliente algoAComparar = (Cliente) compara;
		Boolean esIgual = false;
		if(this.dni.equals(algoAComparar.dni)) {
			esIgual = true;
		} return esIgual;
	}
	
	
}
