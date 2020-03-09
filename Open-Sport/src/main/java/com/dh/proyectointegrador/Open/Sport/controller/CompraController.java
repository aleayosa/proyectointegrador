package com.dh.proyectointegrador.Open.Sport.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.dh.proyectointegrador.Open.Sport.model.Compra;
import com.dh.proyectointegrador.Open.Sport.model.Producto;
import com.dh.proyectointegrador.Open.Sport.repository.compraJpaRepository;

@Controller
@RequestMapping
public class CompraController {

	@Autowired
	private compraJpaRepository compraJpaRepository;
	
	
	@GetMapping("ver_carrito")
	public String getCarrito(Model model) {
		Optional<Compra> unaCompra = this.compraJpaRepository.findById((Integer) 1);
		Compra compra = unaCompra.get();
		
		List<Producto> listaDeProductosDelCarrito = compra.verCarrito();
		
		model.addAttribute("listaDeProductosDelCarrito", listaDeProductosDelCarrito);
		

		return "/carrito/carrito";
	}
		
	
}
