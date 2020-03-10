package com.dh.proyectointegrador.Open.Sport.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="productos")
public class Producto {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	protected Long id;
	
	@NotBlank(message ="Debes ingresar un nombre para el producto")
	@Column(nullable=false)
	protected String nombre;
	
	@ManyToOne
	@JoinColumn(name="marca_id")
	protected Marca marca;
	
	@Size(min=10, message="Esperábamos una descripción mas completa... ")
	protected String descripcion;
	
	@NotNull(message ="El precio es un campo obligatorio")
	protected Double precio;
	
	@NotBlank(message ="Necesitamos que cargues una imagen")
	protected String imagen;
	
	@ManyToOne
	@JoinColumn(name="categoria_id")
	protected Categoria categoria;
	
	@ManyToMany(mappedBy = "listaProductos")
    protected List<Usuario> usuario;
	
	public Producto() {
		}

	

	public Producto(Long id, @NotBlank(message = "Debes ingresar un nombre para el producto") String nombre, 
			Marca marca,
			@Size(min=10, message="Esperábamos una descripción mas completa... ") String descripcion,
			@NotNull(message = "El precio es un campo obligatorio") Double precio,
			@NotBlank(message = "Necesitamos que cargues una imagen") String imagen,
			Categoria categoria) {
		
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

	public List<Usuario> getCompras() {
		return usuario;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
}
