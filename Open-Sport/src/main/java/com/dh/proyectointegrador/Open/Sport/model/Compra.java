package com.dh.proyectointegrador.Open.Sport.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "compra_productos",
    joinColumns = @JoinColumn(name = "compra_nro_factura"),
    inverseJoinColumns = @JoinColumn(name = "productos_id"))
	private List<Producto> listaProductos;
	
	private Date fechaDeCompra;
	private Double totalDeCompra;
	
	public Compra() {
		this.listaProductos = new ArrayList<Producto>();
	}
	public Compra(Integer nroFactura, Usuario cliente, List<Producto> productos, Date fechaDeCompra,
			Double totalDeCompra) {
		this.nroFactura = nroFactura;
		this.cliente = cliente;
		this.listaProductos = productos;
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
		return totalDeCompra;
	}

	public void setTotalDeCompra(Double totalDeCompra) {
		this.totalDeCompra = totalDeCompra;
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
}
