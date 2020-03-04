package com.dh.proyectointegrador.Open.Sport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="productos")
public class Producto {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message ="Este campo no puede quedar vacío")
	@Column(nullable=false)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="marca_id")
	private Marca marca;
	
	private String descripcion;
	private Double precio;
	private String imagen;
	
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	public Producto() {
		}

	public Producto(Long id, @NotBlank(message = "Este campo no puede quedar vacío") String nombre, Marca marca,
			String descripcion, Double precio, String imagen, Categoria categoria) {
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagen = imagen;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
}
