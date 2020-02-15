package com.dh.proyectointegrador.Open.Sport.model;

/**
 * POJO VENTA.
 * 
 * @author Sil
 *  
 *
 */
	

public class Venta {
	private Carrito unCarrito;
	
	public Venta() {
		super();
	}

	public Venta(Carrito unCarrito) {
		this.unCarrito = unCarrito;
	}

	public Carrito getUnCarrito() {
		return unCarrito;
	}

	public void setUnCarrito(Carrito unCarrito) {
		this.unCarrito = unCarrito;
	}
	
}

