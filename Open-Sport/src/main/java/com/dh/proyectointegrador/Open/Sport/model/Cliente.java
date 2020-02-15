package com.dh.proyectointegrador.Open.Sport.model;

import java.util.ArrayList;
import java.util.List;

/**
 * POJO CLIENTE.
 * 
 * @author Sil
 *  
 *
 */

public class Cliente extends Usuario{
	private List<Carrito> listaDeCarritos;
	private Integer dni;
	
	public Cliente() {
	super();
	}

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

	public void setListaDeCarritos(List<Carrito> listaDeCarritos) {
		this.listaDeCarritos = listaDeCarritos;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}
		
}