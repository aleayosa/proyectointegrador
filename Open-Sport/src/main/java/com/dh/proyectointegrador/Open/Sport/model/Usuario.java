package com.dh.proyectointegrador.Open.Sport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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
	private Integer ID;
	
	@Min(3)
	@NotBlank(message="El apellido es obligatorio")
	@Pattern(regexp = "^[a-zA-Z]")
	private String apellido;
	
	@Min(2)
	@NotBlank(message="El nombre es obligatorio")
	@Pattern(regexp = "^[a-zA-Z]")
	private String nombre;
	
	@NotBlank(message="El DNI es obligatorio")
	@Max(8)
	@Pattern(regexp= "^[0-9]")
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
	
	@Pattern(regexp= "^[0-9]")
	private String telefono;
	
	@Pattern(regexp= "^[0-9]")
	private String codigoPostal;
	
	public Usuario(Integer iD, String apellido, String nombre, Integer dni, String fechaDeNacimiento, String email,
			String password, String domicilio, String localidad, String provincia, String telefono,
			String codigoPostal) {
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
	
	
	
	
}
