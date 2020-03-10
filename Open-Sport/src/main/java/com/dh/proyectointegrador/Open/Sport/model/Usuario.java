package com.dh.proyectointegrador.Open.Sport.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.sun.istack.NotNull;

/**
 * POJO USUARIO.
 * 
 * @author Sil
 *
 */

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id	
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer ID;
	
	@Min(3)
	@NotEmpty(message="El apellido ES obligatorio")
	@Pattern(regexp = "^[a-zA-Z]")
	private String apellido;
	
	@Min(2)
	@NotBlank(message="El nombre es obligatorio")
	@Pattern(regexp = "^[a-zA-Z]")
	private String nombre;
	
	@NotNull
	@Max(8)
	private Integer dni;
	
	private String fechaDeNacimiento;
	
	@NotBlank(message="El email es obligatorio")
	@Pattern(regexp= "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")
	private String email;
	
	@Min(6)
	@Max(30)
	@NotBlank(message="La contraseña es obligatoria. Debe tener mínimo 6 y máximo 30 caracteres.")
	private String password;
	
	private String domicilio;
	private String localidad;
	private String provincia;
	private String telefono;
	private String codigoPostal;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_productos",
    joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "productos_id"))
	private List<Producto> listaProductos;
		
	public Usuario() {
		
	}
	
	
	
	public Usuario(Integer iD, @NotEmpty(message = "El apellido ES obligatorio") String apellido, String nombre,
			Integer dni, String fechaDeNacimiento, String email, String password, String domicilio, String localidad,
			String provincia, String telefono, String codigoPostal) {
		ID = iD;
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.email = email;
		this.password = password;
		this.domicilio = domicilio;
		this.localidad = localidad;
		this.provincia = provincia;
		this.telefono = telefono;
		this.codigoPostal = codigoPostal;
	}



	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	} 
	
	public void agregarProductos(Producto producto) {
		if(this.listaProductos == null) {
			this.listaProductos = new ArrayList<>();
		}
		this.listaProductos.add(producto);
	}
	

	public List<Producto> verCarrito() {
		return this.listaProductos;
	}
	
	public Double getTotalDeCompra() {
		Double totalDePrecios = 0.00;
		for(int i = 0; i < listaProductos.size();i++) {
			totalDePrecios = totalDePrecios + listaProductos.get(i).getPrecio();
		};

		return totalDePrecios;
	}
	
}
