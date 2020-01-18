import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario{
	private List<Carrito> listaDeCarritos;
	private Integer dni;
	
	public Cliente(Integer unId, String nombre, String apellido, String email, String contrasenia, Integer dni) {
		super(unId, nombre, apellido, email, contrasenia);
		this.listaDeCarritos = new ArrayList<>();
		this.dni = dni;
	}

	public List<Carrito> getUnCarrito() {
		return listaDeCarritos;
	}

	public Integer getDni() {
		return dni;
	}
	
	@Override
	public String toString() {
		return "Cliente [listaDeCarritos=" + listaDeCarritos + ", dni=" + dni + "]";
	}

	public boolean equals(Object compara) {
		Cliente algoAComparar = (Cliente) compara;
		Boolean esIgual = false;
		if(this.dni.equals(algoAComparar.dni)) {
			esIgual = true;
		} return esIgual;
	}
	
}
