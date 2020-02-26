package com.dh.proyectointegrador.Open.Sport.model;



import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
	private String apellido;
	private String nombre;
	private Integer dni;
	@ManyToMany
	private List<Producto> productos;
	
	public Usuario(Integer iD, String apellido, String nombre, Integer dni, List<Producto> productos) {
		this.ID = iD;
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.productos = productos;
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
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	
}
