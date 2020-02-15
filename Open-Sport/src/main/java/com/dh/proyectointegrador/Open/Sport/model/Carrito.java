package com.dh.proyectointegrador.Open.Sport.model;

import java.util.List;
import java.util.ArrayList;

/**
 * POJO CARRITO.
 * 
 * @author Sil
 *  
 *
 */

public class Carrito {
	private Cliente unCliente;
	private List<Producto> listaDeProductos;
	
	
	public Carrito() {
		super();
	}

	public Carrito(Cliente nombreCliente) {
		this.unCliente = nombreCliente;
		this.listaDeProductos = new ArrayList<>();
	}
	
	public Cliente getUnCliente() {
		return unCliente;
	}
	
	public List<Producto> getListaDeProductos() {
		return listaDeProductos;
	}

	public void setUnCliente(Cliente unCliente) {
		this.unCliente = unCliente;
	}

	public void setListaDeProductos(List<Producto> listaDeProductos) {
		this.listaDeProductos = listaDeProductos;
	}
	
}
