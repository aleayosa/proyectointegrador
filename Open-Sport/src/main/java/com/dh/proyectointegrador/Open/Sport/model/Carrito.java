package com.dh.proyectointegrador.Open.Sport.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="compra_productos")
public class Carrito {
	
	@Id
	private Integer id;

	public Carrito(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

}
