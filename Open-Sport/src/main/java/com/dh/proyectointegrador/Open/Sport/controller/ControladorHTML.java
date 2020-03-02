package com.dh.proyectointegrador.Open.Sport.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dh.proyectointegrador.Open.Sport.model.Producto;
import com.dh.proyectointegrador.Open.Sport.repository.productoJpaRepository;

@Controller
public class ControladorHTML {

	

	
	
	@GetMapping("login")
	public String irAlLogin() {
		return "/login/login";
	}
	
	@GetMapping("faq")
	public String irAlFaq() {
		return "/faq/faq";
	}
	@GetMapping("sucursales")
	public String irALasSucursales() {
		return "/sucursales/sucursales";
	}
	
	@GetMapping("carrito")
	public String irAlCarrito() {
		return "/carrito/carrito";
	}
	@GetMapping("pagar")
	public String irAPagar() {
		return "/carrito/pago";
	}
}
