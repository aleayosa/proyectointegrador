package com.dh.proyectointegrador.Open.Sport.model;

/**
 * POJO USUARIO.
 * 
 * @author Sil
 * ID,nombre,apellido,email,contraseña
 *
 */

public class Usuario {

	private Integer ID;
	private String nombre;
	private String apellido;
	private String email;
	private String contrasenia;


	public Usuario() {
		
	}

	public Usuario(Integer unId, String nombre, String apellido, String email, String contrasenia) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.email = email;
		this.contrasenia = contrasenia;
		this.ID = unId;
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

	public void setID(Integer iD) {
		ID = iD;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
		
}
