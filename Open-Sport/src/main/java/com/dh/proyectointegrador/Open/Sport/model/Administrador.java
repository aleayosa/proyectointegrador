package com.dh.proyectointegrador.Open.Sport.model;

/**
 * POJO ADMINISTRADOR.
 * 
 * @author Sil
 * No funciona porque no tengo inventario, pero... tengo que hacer el objeto inventario o sera la BBDD? 
 *
 */

public class Administrador extends Usuario{
	private Inventario elInventario;
	
	public Administrador() {
		super();
	}

	public Administrador(Integer unId, String nombre, String apellido, String email, String contrasenia, Inventario elInventario) {
		super(unId, nombre, apellido, email, contrasenia);
		this.elInventario = elInventario;
	}

	public Inventario getElInventario() {
		return elInventario;
	}

	public void setElInventario(Inventario elInventario) {
		this.elInventario = elInventario;
	}

}