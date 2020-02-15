package com.dh.proyectointegrador.Open.Sport.model;

/**
 * POJO PRODUCTO.
 * 
 * @author Sil
 *  
 *
 */

public class Producto {
	private String marca;
	private String nombre;
	private Integer id;
	private Double precio;
	private String categoria;
	private Integer cantidad;
	
	public Producto() {
		super();
	}

	public Producto(String marca, String nombre, Integer unId, Double precio, String categoria, Integer cantidad) {
		this.categoria = categoria;
		this.id = unId;
		this.marca = marca;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	
	public String getMarca() {
		return marca;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getId() {
		return id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
