package com.dh.proyectointegrador.Open.Sport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	@GetMapping("registro")
	public String irAlRegistro() {
		return "/registro/registro";
	}
	@GetMapping("faq")
	public String irAlFaq() {
		return "/faq/faq";
	}
	@GetMapping("sucursales")
	public String irALasSucursales() {
		return "/sucursales/sucursales";
	}
}
