package com.dh.proyectointegrador.Open.Sport.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="compra")
public class Compra {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer nroFactura;
	@ManyToOne
	private Usuario cliente;
	@ManyToMany
	private List<Producto> productos;
	private Date fechaDeCompra;
	private Double totalDeCompra;
	
	public Compra(Integer nroFactura, Usuario cliente, List<Producto> productos, Date fechaDeCompra,
			Double totalDeCompra) {
		this.nroFactura = nroFactura;
		this.cliente = cliente;
		this.productos = productos;
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

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Date getFechaDeCompra() {
		return fechaDeCompra;
	}

	public void setFechaDeCompra(Date fechaDeCompra) {
		this.fechaDeCompra = fechaDeCompra;
	}

	public Double getTotalDeCompra() {
		return totalDeCompra;
	}

	public void setTotalDeCompra(Double totalDeCompra) {
		this.totalDeCompra = totalDeCompra;
	}
	
	
}
