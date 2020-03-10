package com.dh.proyectointegrador.Open.Sport.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



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
	private Integer id;
	
	private String nombre;
	private String apellido;
	private String dni;
	private String fechaDeNacimiento;
	private String email;
	private String password;
	private String telefono;
	private String domicilio;
	private String localidad;
	private Integer codigoPostal;
	private String provincia;
	
		
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_productos",
    joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "productos_id"))
	private List<Producto> listaProductos;
		
	public Usuario() {
	}

	public Usuario(Integer id, String nombre, String apellido, String dni, String fechaDeNacimiento, String email,
			String password, String telefono, String domicilio, String localidad, Integer codigoPostal,
			String provincia, List<Producto> listaProductos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.localidad = localidad;
		this.codigoPostal = codigoPostal;
		this.provincia = provincia;
		this.listaProductos = listaProductos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
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
