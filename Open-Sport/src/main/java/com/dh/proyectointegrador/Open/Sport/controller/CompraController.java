package com.dh.proyectointegrador.Open.Sport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dh.proyectointegrador.Open.Sport.model.Compra;
import com.dh.proyectointegrador.Open.Sport.repository.compraJpaRepository;

public class CompraController {

	@Autowired
	private compraJpaRepository compraJpaRepository;
	
	@GetMapping("carrito")
	public String getCarrito() {
		return "/carrito/carrito";
}
	
	//cuando entro POR POST en localhost:8080/pagar se genera la factura en la base de datos y me remite a la 
	//vista de seleccionar el método de pago.
	
	@PostMapping("pagar")
	public String iniciarPago(Compra unaCompra) {
		compraJpaRepository.save(unaCompra);
		return "/carrito/pago";
	}
}
