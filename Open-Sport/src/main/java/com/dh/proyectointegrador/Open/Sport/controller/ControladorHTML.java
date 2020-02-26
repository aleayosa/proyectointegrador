package com.dh.proyectointegrador.Open.Sport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorHTML {

	@GetMapping("home")
	public String irAlHome() {
		return "/home/home";
	}
	
	
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
	
	@GetMapping("pago")
	public String irAPagar() {
		return "/carrito/pago";
	}
	
	@GetMapping("listaProductos")
	public String irALaListaDeProductos() {
		return "/productos/ListadoProductos";
	}
	
}
