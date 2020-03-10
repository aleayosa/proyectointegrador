package com.dh.proyectointegrador.Open.Sport.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compra {
	private Integer nroFactura;
	private Usuario cliente;
  	private List<Producto> listadoProductos;
	private Date fechaDeCompra;
	private Double totalDeCompra;
	
	public Compra() {
		this.listadoProductos = new ArrayList<Producto>();
	}
	public Compra(Integer nroFactura, Usuario cliente, List<Producto> productos, Date fechaDeCompra,
			Double totalDeCompra) {
		this.nroFactura = nroFactura;
		this.cliente = cliente;
		this.listadoProductos = productos;
		this.fechaDeCompra = fechaDeCompra;
		this.totalDeCompra = totalDeCompra;
	}

	public Integer getNroFactura() {
		return nroFactura;
	}

	public void setNroFactura(Integer nroFactura) {
		this.nroFactura = nroFactura;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}



	public Date getFechaDeCompra() {
		return fechaDeCompra;
	}

	public void setFechaDeCompra(Date fechaDeCompra) {
		this.fechaDeCompra = fechaDeCompra;
	}

	public Double getTotalDeCompra() {
		Double totalDePrecios = 0.00;
		for(int i = 0; i < listadoProductos.size();i++) {
			totalDePrecios = totalDePrecios + listadoProductos.get(i).getPrecio();
		};

		return totalDeCompra;
	}

	public void setTotalDeCompra(Double totalDeCompra) {
		this.totalDeCompra = totalDeCompra;
	}
	
	public void agregarProductos(Producto producto) {
		if(this.listadoProductos == null) {
			this.listadoProductos = new ArrayList<>();
		}
		this.listadoProductos.add(producto);
	}
	

	public List<Producto> verCarrito() {
		return this.listadoProductos;
	}
	
	
}
