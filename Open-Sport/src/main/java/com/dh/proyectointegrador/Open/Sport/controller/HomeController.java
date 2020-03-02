package com.dh.proyectointegrador.Open.Sport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dh.proyectointegrador.Open.Sport.model.Producto;
import com.dh.proyectointegrador.Open.Sport.repository.productoJpaRepository;

@Controller
public class HomeController {

	@Autowired
	private productoJpaRepository productoJpaRepository;
	
	@GetMapping("home")
	public String irAlHome(Model model) {
		List<Producto> listaDeProductos = productoJpaRepository.findAll();
		model.addAttribute("listaDeProductos", listaDeProductos);
		return "/home/home";
	}
}
