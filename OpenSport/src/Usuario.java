
public class Usuario {
	private Integer ID;
	private String nombre;
	private String apellido;
	private String email;
	private String contrasenia;
	
	public Usuario(Integer unId, String nombre, String apellido, String email, String contrasenia) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.email = email;
		this.contrasenia = contrasenia;
		this.ID = unId;
	}

	@Override
	public String toString() {
		return "Usuario [ID=" + ID + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", contrasenia=" + contrasenia + "]";
	}

	public Integer getID() {
		return ID;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEmail() {
		return email;
	}

	public String getContrasenia() {
		return contrasenia;
	}
	
	public boolean equals(Object compara) {
		Usuario algoAComparar = (Usuario) compara;
		Boolean esIgual = false;
		if(this.email.equals(algoAComparar.email)) {
			esIgual = true;
		} return esIgual;
	}
	
	public boolean iniciarSesion(String email, String contrasenia) {
		return (email.equals(this.getEmail()) && contrasenia.equals(this.getContrasenia()));
	}
}
